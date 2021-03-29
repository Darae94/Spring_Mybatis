package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	private int num;
	
	@NotBlank(message = "이름은 필수 입력 사항입니다.")
	private String name;

//	@Min(value = 10, message = "10~100으로 작성해야합니다.")
//	@Max(value = 100, message = "10~100으로 작성해야합니다.")
	//@NotBlank(message = "나이는 필수 입력 사항입니다.")
	//@NotEmpty(message = "나이는 필수 입력 사항입니다.")
	@Range(min = 10, max = 100, message = "10~100으로 작성해야합니다.")
	private int age;
	
	//@NotEmpty(message = "관심지역은 1개 이상 선택해야 합니다.")
	@NotNull(message = "관심지역은 1개 이상 선택해야 합니다.")
	private String area;

	//@NotEmpty(message = "원하는 여행 타입을 선택해 주세요")
	@NotNull(message = "원하는 여행 타입을 선택해 주세요")
	private String style;

	//@NotNull(message = "원하는 여행 타입을 선택해 주세요")
	@NotEmpty(message = "원하는 가격대를 선택하세요")
	private String price;
	
	public TravelBean() {
		super();
	}
	
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
}
