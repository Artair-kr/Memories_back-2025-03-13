package com.hsj.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hsj.memories_back.service.FileService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;
    
  @PostMapping("/upload")
  public String upload( 
    // @RequestParam("Key에 해당하는 내용") 받을 파일 타입 / 매개변수명)
    @RequestParam("file") MultipartFile file
  ) { 
    String url = fileService.upload(file);
    return url;
  }
  
}