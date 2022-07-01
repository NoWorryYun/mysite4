package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value="/gallery/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String gallerylist() {
		
		System.out.println("gallery controller // list()");
		
		//List<GalleryVo> gList = galleryService.galleryList();
		
		//model.addAttribute("gList", gList);
		
		return "gallery/list";
	}
	
	@RequestMapping(value="/gallery/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("content") String content, Model model) {
		
		model.addAttribute("saveName", saveName);
		
		galleryService.insertGallery(file);
		
		return "redirect:list";
		
	}
	
	
}
