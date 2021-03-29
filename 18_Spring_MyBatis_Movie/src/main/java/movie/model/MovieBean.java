package movie.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MovieBean {

	private int num;
	
	// @NotEmpty 빈칸을 인식하지 못하므로 사용 권장하지 않음
	@NotBlank(message = "제목은 필수 입력 항목입니다.")
	private String title;
	
	@NotEmpty(message = "대륙은 필수 입력 항목입니다.")
	private String continent;

	//@NotNull(message = "나라는 필수 입력 항목입니다.@NotNull") // 셀렉트에 적용 안됨
	@NotBlank(message = "나라는 필수 입력 항목입니다.")
	private String nation;
	
	//@NotBlank(message = "최소 1개 이상 선택하세요.@NotBlank")
	//@NotEmpty(message = "최소 1개 이상 선택하세요.")
	//체크박스타입은  @NotEmpty, @NotNull, @NotBlank 모두 가능
	@NotNull(message = "최소 1개 이상 선택하세요.")
	private String genre;
	
	//@NotNull(message = "등급은 필수 입력 항목입니다.@NotNull")
	//@NotEmpty(message = "등급은 필수 입력 항목입니다.@NotEmpty")
	//라디오타입는 @NotEmpty, @NotNull, @NotBlank 모두 가능
	@NotBlank(message = "등급은 필수 입력 항목입니다.")
	private String grade;
	
	@NotBlank(message = "배우는 필수 입력 항목입니다.")
	private String actor;

	public MovieBean() {
		super();
	}

	public MovieBean(int num, String title, String continent, String nation, String genre, String grade,
			String actor) {
		super();
		this.num = num;
		this.title = title;
		this.continent = continent;
		this.nation = nation;
		this.genre = genre;
		this.grade = grade;
		this.actor = actor;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
