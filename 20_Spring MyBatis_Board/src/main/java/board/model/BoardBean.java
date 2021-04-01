package board.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

public class BoardBean {

	private int num;
	
	@NotBlank(message = "작성자는 필수 항목입니다.")
	private String writer;
	private String email;
	
	@NotBlank(message = "제목은 필수 항목입니다.")
	private String subject;

	@NotBlank(message = "비밀번호는 필수 항목입니다.")
	private String passwd;
	private Timestamp regDate;
	private int readcount;
	private int ref;
	private int reStep;
	private int reLevel;
	
	@NotBlank(message = "내용는 필수 항목입니다.")
	private String content;
	private String ip;
	
	public BoardBean() {
		super();
	}
	
	public BoardBean(int num, String writer, String email, String subject, String passwd, Timestamp regDate, int readcount,
			int ref, int reStep, int reLevel, String content, String ip) {
		super();
		this.num = num;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.passwd = passwd;
		this.regDate = regDate;
		this.readcount = readcount;
		this.ref = ref;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.content = content;
		this.ip = ip;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
