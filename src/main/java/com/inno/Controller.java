package com.inno;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {

	@Autowired private TemplateService templateService;
	@GetMapping("string")
	public String generateStringHtmlContent() {
		System.out.println("Request Received");
		Map<String, Object> context = new HashMap<>();
		context.put("memberName", "Spring Boot");
		context.put("message", "This is a sample message");
		context.put("timestamp", new Date());
		String content =  templateService.generateTemplate("invoice_payment_failed", context);
		System.out.println(content);
		return content;

	}
}
