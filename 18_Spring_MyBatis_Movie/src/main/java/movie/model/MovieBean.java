package movie.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MovieBean {

	private int num;
	
	// @NotEmpty ��ĭ�� �ν����� ���ϹǷ� ��� �������� ����
	@NotBlank(message = "������ �ʼ� �Է� �׸��Դϴ�.")
	private String title;
	
	@NotEmpty(message = "����� �ʼ� �Է� �׸��Դϴ�.")
	private String continent;

	//@NotNull(message = "����� �ʼ� �Է� �׸��Դϴ�.@NotNull") // ����Ʈ�� ���� �ȵ�
	@NotBlank(message = "����� �ʼ� �Է� �׸��Դϴ�.")
	private String nation;
	
	//@NotBlank(message = "�ּ� 1�� �̻� �����ϼ���.@NotBlank")
	//@NotEmpty(message = "�ּ� 1�� �̻� �����ϼ���.")
	//üũ�ڽ�Ÿ����  @NotEmpty, @NotNull, @NotBlank ��� ����
	@NotNull(message = "�ּ� 1�� �̻� �����ϼ���.")
	private String genre;
	
	//@NotNull(message = "����� �ʼ� �Է� �׸��Դϴ�.@NotNull")
	//@NotEmpty(message = "����� �ʼ� �Է� �׸��Դϴ�.@NotEmpty")
	//����Ÿ�Դ� @NotEmpty, @NotNull, @NotBlank ��� ����
	@NotBlank(message = "����� �ʼ� �Է� �׸��Դϴ�.")
	private String grade;
	
	@NotBlank(message = "���� �ʼ� �Է� �׸��Դϴ�.")
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
