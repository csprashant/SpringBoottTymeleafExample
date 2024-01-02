package com.inno.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.config.StringTemplateService;
import com.inno.dto.Message;
import com.inno.repo.TemplateRepo;
import com.inno.service.PasswordProtctedPdfService;
import com.inno.service.PdfService;

@RestController
public class StringTemplateController {
	
	@Autowired private StringTemplateService templateService;
	@Autowired PasswordProtctedPdfService passwordProtctedPdfService;
	@Autowired private PdfService service;
	@Autowired private TemplateRepo repo;
	private Logger log = LoggerFactory.getLogger(StringTemplateController.class);
	
	@GetMapping("spt")
	public String trasncrpt() {
		log.info("Request Received passwordtrasncrpt");
		Map<String, Object> context = new HashMap<>();
		context.put("msgList", getMessages());
		String template = repo.getTempalteById(1).getName();
		String content =  templateService.getTemplateFromAttributes(template, context);
		System.out.println(content);
		return passwordProtctedPdfService.htmlStringToPdf(content);
	}
	
	@GetMapping("spdf")
	public String pdf() {
		log.info("Request Received pdf");
		Map<String, Object> context = new HashMap<>();
		context.put("msgList", getMessages());
		String template = repo.getTempalteById(1).getName();
		String content =  templateService.getTemplateFromAttributes(template, context);
		System.out.println(content);
		return service.htmlStringToPdf(content);
	}
	
	public List<Message> getMessages(){
		List<Message> list =  new ArrayList<Message>();
		list.add(new Message("Agent -Raj",1,new Date(),"<html><body><h1>This is a test</h1><p><b>This text is bold</b></p><p><i>This text is italic</i></p><p>This content is in html tag to render the html styled messages</p> <img src=\"https://pics.sbicard.com/SBICardsCEJ8/images/title-image.png\" height=\"20px\" width=\"100px\"/></body></html> "));
		list.add(new Message("Prashant",2,new Date(),"Customer meessage1"));
		list.add(new Message("Agent -Raj",1,new Date(),"Agent message2"));
		list.add(new Message("Prashant",2,new Date(),"Customer meessage2 Customer meessage2 Customer meessage2 Customer meessage2 Customer meessage2 Customer meessage2 Customer meessage2 Customer meessage2"));
		list.add(new Message("Agent -Raj",1,new Date(),"Agent message3"));
		list.add(new Message("Prashant",2,new Date(),"Customer meessage3"));
		list.add(new Message("Agent -Raj",1,new Date(),"Agent message4"));
		list.add(new Message("Prashant",2,new Date(),"Customer meessage4"));
		list.add(new Message("Agent -Raj",1,new Date(),"Agent message long message for testing Agent message long message for testing Agent message long message for testing Agent message long message for testing5"));
		list.add(new Message("Prashant",2,new Date(),""));
		return list;
	}
}
