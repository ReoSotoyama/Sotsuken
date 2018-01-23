package bean;

/**
 * 社員テーブルの１件分のデータを格納するためのクラス.
 * @author Yoshiki Nakamura
 *
 */
public class EmployeeBean {
  private int id;
  private String name;
  private String department;
  private String course;
  private String x;
  private String pass;
  private String address;



  public EmployeeBean() {
  }

  /**
   * 引数付きコンストラクタ.
   * EmployeeBeanクラスの変数を引数で更新
   *
   * @param id
   * @param name
   * @param sectionId
   * @param birthdate
   * @param address
   * @param remark
   */

  public EmployeeBean(int id, String name, String department,
      String course, String x, String pass, String address) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.course = course;
    this.x = x;
    this.pass = pass;
    this.address = address;
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

public String getX() {
	return x;
}

public void setX(String x) {
	this.x = x;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

}