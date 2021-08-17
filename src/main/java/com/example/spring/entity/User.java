package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
  private Long id;
  private String name;
  private String password;
  private String email;
  private Integer role;

  public User() {
  }

  public User(Long id, String name, String password, String email, Integer role) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.role = role;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", role=" + role +
            '}';
  }
}
