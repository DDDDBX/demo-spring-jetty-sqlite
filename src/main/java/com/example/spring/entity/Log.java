package com.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Log {
  private Long id;
  @Column(name = "user_ip")
  private String userIp;
  private String operation;
  private String arguments;
  private String description;
  private Long timestamp;

  public Log() {
  }

  public Log(String userIp, String operation, String arguments, String description, Long timestamp) {
    this.userIp = userIp;
    this.operation = operation;
    this.arguments = arguments;
    this.description = description;
    this.timestamp = timestamp;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserIp() {
    return userIp;
  }

  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getArguments() {
    return arguments;
  }

  public void setArguments(String arguments) {
    this.arguments = arguments;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "Log{" +
            "id=" + id +
            ", userIp='" + userIp + '\'' +
            ", operation='" + operation + '\'' +
            ", arguments='" + arguments + '\'' +
            ", description='" + description + '\'' +
            ", timestamp=" + timestamp +
            '}';
  }
}
