package bean;

/**
 * 部署テーブルの１件分のデータを格納するためのクラス.
 * 値を保持するフィールドと、そのgetterを持つ
 *
 * @author Yoshiki Nakamura
 */
public class SectionBean {
  private int header;
  private int id;
  private String name;
  private String department;
  private String course;
  private String company;
  private int phone;
  private String location;
  private String area;
  private String industry;
  private String occupations;
  private int year;
  private int time;
  private String sof;
  private String comment1;
  private String comment2;
  private String comment3;


  public SectionBean() {
  }

  /**
   * 引数付きコンストラクタ.
   * SectionBeanクラスの変数を引数で更新
   *
   * @param id
   * @param name
   */

  public SectionBean(int header, int id, String name, String department, String course, String company, int phone,
  String location, String area,String industry, String occupations, int year, int time, String sof, String comment1, String comment2,
  String comment3) {
    this.header = header;
    this.id = id;
    this.name = name;
    this.department = department;
    this.course = course;
	this.company = company;
	this.phone = phone;
	this.location = location;
	this.area = area;
	this.industry = industry;
	this.occupations = occupations;
	this.year = year;
	this.time = time;
    this.sof = sof;
    this.comment1 = comment1;
    this.comment2 = comment2;
    this.comment3 = comment3;
  }


  public int getHeader() {
		return header;
	}

	public void setHeader(int header) {
		this.header = header;
	}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getOccupations() {
		return occupations;
	}

	public void setOccupations(String occupations) {
		this.occupations = occupations;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getSof() {
	return sof;
	}

	public void setSof(String sof) {
	this.sof = sof;
	}

public String getComment1() {
	return comment1;
}

public void setComment1(String comment1) {
	this.comment1 = comment1;
}

public String getComment2() {
	return comment2;
}

public void setComment2(String comment2) {
	this.comment2 = comment2;
}

public String getComment3() {
	return comment3;
}

public void setComment3(String comment3) {
	this.comment3 = comment3;
}
}