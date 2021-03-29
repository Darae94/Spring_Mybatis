# Spring_Mybatis

** 프로젝트 작성 순서 (multi mapper)
1. web.xml 한글 설정 -> 날짜/시간 확인(프로젝트 실행)
	<!-- 한글설정 -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>
			org.springframework.web.filter.CharacterEncodingFilter
		</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
2. pom.xml 유효성, DB, 화일 등의 dependency 추가
  <repositories>
    <repository>
      <id>oracle</id>
      <name>ORACLE JDBC Repository</name>
      <url>http://maven.jahia.org/maven2</url>
    </repository>
  </repositories>
  <dependencies> 안에 작성
		<!-- oracle 설정 -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>12.1.0.1</version>
		</dependency>
		
		<!-- datasource설정 -->
		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.4</version>
		</dependency>
		
		<!-- 마이바티스 설정 -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.1.0</version>
		</dependency>
		
		<!-- 유효성 검사 -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>4.2.0.Final</version>
		</dependency>
		
		<!-- 화일 업로드 - cos.jar화일 추가 -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.2.2</version>
		</dependency>
		
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>1.3.2</version>
		</dependency>
		
3. web.xml 을 통해 root-context.xml 에 객체 생성 -> 여러 mapper 사용을 위해 mapperLocations 설정 안함 => SqlMapConfig.xml 에 class 별칭 처리 및  mapper 호출
  - web.xml 의 context-param -> root-context 에 객체 생성 - dataSource / sqlSessionFactoryBean / sqlSessionTemplate
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
		<property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl"></property>
		<property name="username" value="jspid"></property>
		<property name="password" value="jsppw"></property>
	</bean>

	<bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		<property name="configLocation" value="classpath:/mybatis/SqlMapConfig.xml">
    </property><property name="mapperLocations">
			<value>classpath:/mybatis/*.xml</value>
		</property>
	</bean>
	
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactoryBean"></constructor-arg>
	</bean>
  
3-1(multi). 클래스 별칭과 맵퍼(해당 실행 시 jsp 폴더 위치와 읽어들일 xml 작성)들을 해당 위치에 생성
  - src/main/java에 *.model(bean,dao), *.controller, *.mybatis(xml 2가지 생성 : SqlMapConfig.xml , *.xml 안에 내용 작성) 생성
<!-- *.xml -->
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="">

</mapper>
  
<!-- SqlMapConfig.xml -->
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
  
<configuration>
	<typeAliases>
		<typeAlias type="member.model.Member" alias="MyMember" />
  </typeAliases>

  <mappers>
    <mapper resource="mybatis/*.xml" />
  </mappers>
</configuration>

4. web.xml 기본 servlet 복사하여 각 *.?에 따른 해당 패키지 스캔 후 실행 가능하게 수정
	<!-- * 추가 -->
	<servlet>
		<servlet-name>*</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/*-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		
	<servlet-mapping>
		<servlet-name>*</servlet-name>
		<url-pattern>*.?</url-pattern>
	</servlet-mapping>
	
5. src/main/webapp/WEB-INF/spring/appServlet에 *-servlet.xml(context, mvc) -> 받은 값의 jsp가 해당 폴더에 위치하도록 설정 / 패키지 쭉 보고 controller 실행하기 위해
	<mvc:annotation-driven/>

	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/*/" />
		<property name="suffix" value=".jsp" />
	</bean>
	
	<context:component-scan base-package="*" />

