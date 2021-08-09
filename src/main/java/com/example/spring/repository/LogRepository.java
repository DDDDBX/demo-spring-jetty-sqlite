package com.example.spring.repository;

import com.example.spring.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

  @Override
  List<Log> findAll();

  @Override
  <S extends Log> S save(S entity);
}
