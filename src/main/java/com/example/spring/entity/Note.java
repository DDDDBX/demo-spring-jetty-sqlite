package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

  private Long id;
  private String name;
  private String message;

  public Note() {
  }

  public Note(Long id, String name, String message) {
    this.id = id;
    this.name = name;
    this.message = message;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Note{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", message='" + message + '\'' +
            '}';
  }
}
