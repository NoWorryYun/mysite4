package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;
	
//	public void insertGallery(GalleryVo galleryVo) {
//		
//	}

	public List<GalleryVo> galleryList(){
		
		System.out.println("gList > service");
		
		return galleryDao.galleryList();
		
	}
	
	public String insertGallery(MultipartFile file, String content, int userNo) {
		
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
		GalleryVo galleryVo = new GalleryVo(userNo, content, saveName, orgName, filePath, fileSize);
		System.out.println(galleryVo);
		
		// (1)Dao DB에 저장
		
		galleryDao.insertGallery(galleryVo);
		
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
