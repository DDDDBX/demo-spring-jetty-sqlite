package com.example.spring.repository;

import com.example.spring.entity.WxFollower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WxRepository extends JpaRepository<WxFollower, String> {

  @Override
  List<WxFollower> findAll();

  @Override
  <S extends WxFollower> S save(S entity);
}
