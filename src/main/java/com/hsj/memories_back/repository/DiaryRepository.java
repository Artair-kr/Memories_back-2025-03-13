package com.hsj.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsj.memories_back.common.entity.DiaryEntity;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {
  
}
