package album.model;

import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotBlank;

public class AlbumBean {
	
	private int num;
	
	//@NotEmpty(message = "���� �����Ǿ����ϴ�.") => ���� �Է� ó�� ����
	//@NotNull(message = "���� �����Ǿ����ϴ�.") => �ƹ� ó���� ����
	@NotBlank(message = "���� �����Ǿ����ϴ�.")
	private String title;
	
	@Length(min = 3, max = 7, message = "�������� �ּ� 3�ڸ�~�ִ� 7�ڸ��Դϴ�.")
	private String singer;
	
	@Min(value = 1000, message = "������ �ּ� 1000�� �̻��Դϴ�.")
	// @Size(min = 4, message = "������ �ּ� 1000�� �̻��Դϴ�.")
	@Pattern(regexp = "^[0-9]+$", message = "������ ���ڷ� �Է��ϼ���.")
	private String price;
	
	private String day;
	
	public AlbumBean() {
		super();
	}

	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		System.out.println("bean getTitle()"+title);
		return title;
	}

	public void setTitle(String title) {
		System.out.println("bean setTitle()"+title);
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
