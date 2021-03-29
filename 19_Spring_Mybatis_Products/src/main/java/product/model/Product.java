package product.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int num ;
	
	@NotBlank(message = "상품명 누락")
	@Length(min=3, max=8, message = "상품명은 3자리~8자리 입니다.")
	private String name ;
	
	private String company ;
	
	@NotEmpty(message = "화일 선택 안함")
	private String image ; // bread.jpg
	private int stock ;
	
	@Min(value=3000,message="가격은 3000원 이상 입력하세요")
	private int price ;
	
	private String category ;
	
	@Size(min=3,max=8,message="상품설명은 3~8자리입니다.")
	private String contents ;
	private int point ;
	private String inputdate ;
	
	private MultipartFile upload;
	
	public Product() {
		super();
	}
	public Product(int num, String name, String company, String image, int stock, int price, String category,
			String contents, int point, String inputdate) {
		super();
		this.num = num;
		this.name = name;
		this.company = company;
		this.image = image;
		this.stock = stock;
		this.price = price;
		this.category = category;
		this.contents = contents;
		this.point = point;
		this.inputdate = inputdate;
	}
	
	public MultipartFile getUpload() {
		return upload;
	}
	
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("upload:" + upload);
		System.out.println("upload.getName():"+upload.getName());
		System.out.println("upload.getOriginalFilename():"+upload.getOriginalFilename());
		this.image = upload.getOriginalFilename();
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
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getInputdate() {
		return inputdate;
	}
	
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
}