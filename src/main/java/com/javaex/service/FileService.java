package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileDao;
import com.javaex.vo.FileVo;

@Service
public class FileService {

	@Autowired
	private FileDao fileDao;
	
	// file 하드디스크 저장, 파일 정보(DB저장) 추출 저장
	public String save(MultipartFile file) {
		System.out.println("fileService > save()");
		System.out.println(file.getOriginalFilename());
	
		String saveDir = "C:\\javaStudy\\upload";
		
		//파일 정보(DB저장) 추출 저장
	
		//오리지날파일명, 저장경로+파일(랜덤)명, 파일사이즈
		String orgName = file.getOriginalFilename();
	
		//확장자(.jpg)
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exName);
		
		//저장파일명(현재시간 + 이름 난수)
		String saveName =  System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일 사이즈
		long fileSize = file.getSize();
		
		//Vo로 묶기
		FileVo fileVo = new FileVo(orgName, saveName, filePath, fileSize);
		System.out.println(fileVo);
		
		// (1)Dao DB에 저장
		
		fileDao.save(fileVo);
		
		// (2)파일(하드디스크) 저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			os.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
	}

}
