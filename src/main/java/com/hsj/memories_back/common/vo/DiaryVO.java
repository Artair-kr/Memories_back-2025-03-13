package com.hsj.memories_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.hsj.memories_back.common.entity.DiaryEntity;

import lombok.Getter;

@Getter
public class DiaryVO {
    private Integer diaryNumber;
    private String writeDate;
    private String title;
    private String weather;
    private String feeling;

    private DiaryVO(DiaryEntity diaryEntity){ 
        this.diaryNumber = diaryEntity.getDiaryNumber();
        this.writeDate = diaryEntity.getWriteDate();
        this.title = diaryEntity.getTitle();
        this.weather = diaryEntity.getWeather();
        this.feeling = diaryEntity.getFeeling();
    }

    // 클래스 자체로 접근 가능 하게 작성
    public static List<DiaryVO> getList(List<DiaryEntity> diaryEntities){ 

        List<DiaryVO> list = new ArrayList<>();
        for(DiaryEntity diaryEntity: diaryEntities){ 
            DiaryVO vo = new DiaryVO(diaryEntity);
            list.add(vo);
        }
        return list;
    }
}
