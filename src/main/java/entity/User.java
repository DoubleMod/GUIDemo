package entity;

import java.util.Date;

public class User {

  private Integer id;
  private String name;
  private String password;
  private Byte type;
  private String email;
  private Byte status;
  private Date crateDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Byte getType() {
    return type;
  }

  public void setType(Byte type) {
    this.type = type;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }

  public Date getCrateDate() {
    return crateDate;
  }

  public void setCrateDate(Date crateDate) {
    this.crateDate = crateDate;
  }
}
