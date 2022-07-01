package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> galleryList(){
		
		System.out.println("gList > Dao");
		
		List<GalleryVo> gVo= sqlSession.selectList("gallery.galleryList");
		System.out.println(gVo);
		return gVo;
	}
	
	public int insertGallery(GalleryVo galleryVo) {
		
		int count = sqlSession.insert("gallery.insertGallery", galleryVo);
		
		return count;
		
	}
}
