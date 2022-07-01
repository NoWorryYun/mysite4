package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public int insertGallery(GalleryVo galleryVo) {
		
		int count = galleryDao.insertGallery(galleryVo);
		
		return count;
	}
	
}
