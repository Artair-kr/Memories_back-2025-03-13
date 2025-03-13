package com.hsj.memories_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "memoryTest")
@Table(name = "memory_test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemoryTestEntity {
    
    @Id
    private String userId;
    @Id
    private Integer sequence;
    private Integer measurementTime;
    private String testDate;
    private Integer gap;

}
