package com.hsj.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsj.memories_back.common.entity.MemoryTestEntity;
import com.hsj.memories_back.common.entity.pk.MemoryTestPk;


@Repository
public interface MemoryTestRepository extends JpaRepository<MemoryTestEntity, MemoryTestPk>{
    
  int countByUserId(String userId);

  MemoryTestEntity findByUserIdAndSequence(String userId, Integer sequence);

}
