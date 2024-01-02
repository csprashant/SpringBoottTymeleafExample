package com.inno.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.model.Template;
import com.inno.repo.TemplateRepo;

@RestController
public class TemplateController {

	@Autowired private TemplateRepo repo;
	String t= "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
			+ "<html xmlns:th=\"https://thymeleaf.org\">\r\n"
			+ "<head><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
			+ "<style>@media screen and (max-width: 580px) {table.body-wrap td {padding-left: 10px !important; padding-right: 10px !important;}\r\n"
			+ ".big-title {font-size: 30px !important;}\r\n"
			+ ".main {margin: 0px !important;margin-left:auto;margin-right:auto;}}</style> \r\n"
			+ "<style type=\"text/css\">\r\n"
			+ "@media only screen and (max-width:480px) {@-ms-viewport {width: 320px;}@viewport {width: 320px;}}</style></head>\r\n"
			+ "<body style=\"background-color:#ffffff;\">\r\n"
			+ "<div style=\"font-size:10px;color:#ffffff;\">Chat transcript for your chat with SBICard</div>\r\n"
			+ " <div style=\"background-color:#ffffff;\"><div class=\"main\" style=\"Margin:0px auto;width:100%;padding-top:64px;\">\r\n"
			+ " <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\">\r\n"
			+ " <tbody><tr><td style=\"direction:ltr;font-size:10px;padding:0px;text-align:center;vertical-align:top;\">\r\n"
			+ "<div style=\"background:#fff;background-color:#fff;Margin:0px auto;border-radius:10px;width:100%;font-family: Arial,Helvetica, sans-serif;border:solid 1px #e0e0e0;\">\r\n"
			+ "<table class=\"body-wrap\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#fff;background-color:#fff;width:100%;border-radius:10px;\">\r\n"
			+ "<tbody><tr><td style=\"direction:ltr;font-size:10px;padding:15px;padding-top:15px;padding-bottom:50px;text-align:center;vertical-align:top;\">\r\n"
			+ "<div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:100%;\">\r\n"
			+ "<table class=\"body-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"10px\" role=\"presentation\" style=\"vertical-align:middle;\" width=\"100%\">\r\n"
			+ "<tr><td align=\"left\" style=\"font-size:10px;padding:10px 25px;padding-right:25px;padding-left:25px;word-break:break-word;\">\r\n"
			+ "<div style=\"font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:20px;text-align:center;color:#3c4043;\">\r\n"
			+ "<center><img src=\"https://www.sbicard.com/sbi-card-en/resources/img/m-logo.png\" alt=\"SBI Card Logo\" style=\"max-width: 100%;\"/></center><br/><br/>\r\n"
			+ "</div></td></tr>\r\n"
			+ "<tr th:each=\"msg:${msgList}\">\r\n"
			+ "<td align=\"left\" style=\"font-size:10px;padding:10px 25px;padding-right:25px;padding-bottom:25px;padding-left:25px;word-break:break-word;\">\r\n"
			+ "<div th:if=\"${msg.type} == '1'\" style=\"text-align: left;background-color: #cbe0f4; padding: 10px; border-radius: 5px; margin-bottom: 10px; float: left; clear: both; width: 400px;min-width:300px;font-size: 15px; \">\r\n"
			+ "<p style=\"font-weight: bold; font-size: 15px; color: #333; margin: 0;\"><span th:text=\"${msg.name}\"></span></p>\r\n"
			+ "<p style=\"margin: 5px 0;font-size: 13px; \"><span th:utext=\"${msg.messageText}\"></span></p>\r\n"
			+ "<p style=\"color: #888; font-size: 12px; margin: 0;\"><span th:text=\"${msg.receivedTime}\"></span></p>\r\n"
			+ "</div>\r\n"
			+ "<div th:unless=\"${msg.type} == '1'\"style=\"text-align: right;background-color: #eaf7fd; padding: 10px; border-radius: 5px; margin-bottom: 10px; float: right; clear: both; width: 400px;min-width:300px;font-size: 15px; \">\r\n"
			+ "<p style=\"font-weight: bold; color: #333; margin: 0;font-size: 15px; \"><span th:text=\"${msg.name}\"></span></p>\r\n"
			+ "<p style=\"margin: 5px 0;font-size: 13px; text-align : left \"><span th:utext=\"${msg.messageText}\"></span></p>\r\n"
			+ "<p style=\"color: #888; font-size: 12px; margin: 0;\"><span th:text=\"${msg.receivedTime}\"></span></p>\r\n"
			+ "</div></td></tr></table></div></td></tr></tbody></table></div></td></tr></tbody></table></div></div></body></html>";
	
	@PostMapping("temp/{id}")
	public Template saveTemplate(@PathVariable Integer id) {
		Template tep=  new Template();
		tep.setId(id);
		tep.setName(t);
		return repo.save(tep);
	}
	
	@GetMapping("temp/{id}")
	public Template getTemplateById(@PathVariable Integer id) {
		return repo.getTempalteById(id);
	}
	
}
