package com.hsj.memories_back.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hsj.memories_back.service.FileService;

@Service
public class FileServiceImplement implements FileService{

    @Value("${file.path}") 
    private String filePath;

    @Value("${file.url}")
    private String fileUrl;

    @Override
    public String upload(MultipartFile file) {

      // 파일 업로드에 성공한다면 파일에 접근할수 있는 url을 반환
      // description: 빈 파일인지 확인 / 비어있다면 true 반환 //
      if(file.isEmpty()) return null;

      // description: 원본 파일명 구하기 //
      // 파일의 확장자를 구하기 위해 가져온다. //
      // 다른 저장된 파일과 이름이 중복되어 서버에 저장되지 않거나, 이름이 변경될 수 있기에 확인 //
      // 임의의 이름으로 저장하여 중복이 되지 않도록 수정한다. (원본 이름은 따로 보관) //
      String originalFileName = file.getOriginalFilename();

      // description: 확장자(.jpg , .png등) 구하기 //
      // 맨 마지막 .의 위치 찾아 구한다. // 
      String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

      // description: UUID 형식의 임의의 파일명 (범용 고유 식별자 형식) 문자열//
      String uuid = UUID.randomUUID().toString();

      // description: 저장될 파일명 (UUID + 확장자) //
      String saveFileName = uuid + extension;

      // description: 파일이 저장될 경로 //
      String savePath = filePath + saveFileName;

      // description: 파일 저장 //
      try{ 
        file.transferTo(new File(savePath));
      } catch(Exception exception){ 
        exception.printStackTrace();
        return null;
      }

      // description: 파일을 불러올 수 있는 경로 생성 //
      String url =  fileUrl + saveFileName;
      return url;
    }

    @Override
    public Resource getImageFile(String fileName) {
    
      Resource resource = null;

      // description: 파일 저장 경로에 있는 파일명에 해당하는 파일 불러오기 //
      try{ 
        String uri = "file:" + filePath + fileName;
        resource = new UrlResource(uri);
      }catch (Exception exception){ 
        exception.printStackTrace();
        return null;
      }
      return resource;
    }

}
