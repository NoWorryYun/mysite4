package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value="/gallery/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String gallerylist(Model model) {
		
		System.out.println("gallery controller // list()");
		
		List<GalleryVo> gList = galleryService.galleryList();
		
		model.addAttribute("gList", gList);
		
		return "gallery/list";
	}
	
	@RequestMapping(value="/gallery/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file, 
						 @RequestParam("content") String content,
						 @RequestParam("userNo") int userNo ) {

		
		galleryService.insertGallery(file, content, userNo);

		return "redirect:list";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/gallery/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestBody int no) {
		System.out.println("gallery Controller > delete");
		System.out.println(no);
	
		String state = galleryService.deleteGallery(no);
		
		return state;
	}
	
	
}
