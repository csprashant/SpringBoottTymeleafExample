package com.inno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		context.put("empsList", getDetails());
		String content =  templateService.generateTemplate("emp", context);
		System.out.println(content);
		return content;

	}
	
	public List<Employee> getDetails(){
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(101,"Raj Name to suna hi hoga",345450.00));
		list.add(new Employee(102,"Rajesh",36000.00));
		list.add(new Employee(103,"Raja",56000.00));
		list.add(new Employee(104,"Raju",26000.00));
		list.add(new Employee(105,"Rajat",96000.00));
		list.add(new Employee(107,"Golu",76000.00));
		list.add(new Employee(108,"Rajiv",16000.00));
		list.add(new Employee(109,"Sonu",46000.00));
		list.add(new Employee(110,"Tanu",56000.00));
		return list;
		
	}
}
