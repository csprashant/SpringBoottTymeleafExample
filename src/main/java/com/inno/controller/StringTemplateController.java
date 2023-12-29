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
import com.inno.service.PasswordProtctedPdfService;
import com.inno.service.PdfService;

@RestController
public class StringTemplateController {

	String template = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
			+ "<html xmlns:th=\"https://thymeleaf.org\">    \r\n"
			+ " <head>\r\n"
			+ "    <title></title>\r\n"
			+ "    <!--[if !mso]><!== -->\r\n"
			+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
			+ "    <!--<![endif]-->\r\n"
			+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
			+ "    <style>\r\n"
			+ "      @media screen and (max-width: 580px) {\r\n"
			+ "        table.body-wrap td {\r\n"
			+ "          padding-left: 10px !important;\r\n"
			+ "          padding-right: 10px !important;\r\n"
			+ "        }\r\n"
			+ "        .big-title {\r\n"
			+ "          font-size: 30px !important;\r\n"
			+ "        }\r\n"
			+ "        .main {\r\n"
			+ "          margin: 0px !important;\r\n"
			+ "		  margin-left:auto;\r\n"
			+ "		  margin-right:auto;\r\n"
			+ "        }\r\n"
			+ "      }\r\n"
			+ "	</style>\r\n"
			+ "    \r\n"
			+ "    <style type=\"text/css\">\r\n"
			+ "      @media only screen and (max-width:480px) {\r\n"
			+ "        @-ms-viewport {\r\n"
			+ "          width: 320px;\r\n"
			+ "        }\r\n"
			+ "        @viewport {\r\n"
			+ "          width: 320px;\r\n"
			+ "        }\r\n"
			+ "      }\r\n"
			+ "	</style>\r\n"
			+ "   </head>\r\n"
			+ "\r\n"
			+ "  <body style=\"background-color:#ffffff;\">\r\n"
			+ "    <div style=\"font-size:10px;color:#ffffff;\">\r\n"
			+ "      Chat transcript for your chat with SBICard\r\n"
			+ "    </div>\r\n"
			+ "    <div style=\"background-color:#ffffff;\">\r\n"
			+ "      <div class=\"main\" style=\"Margin:0px auto;width:100%;padding-top:64px;\">\r\n"
			+ "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\">\r\n"
			+ "          <tbody>\r\n"
			+ "            <tr>\r\n"
			+ "              <td style=\"direction:ltr;font-size:10px;padding:0px;text-align:center;vertical-align:top;\">\r\n"
			+ "                <div style=\"background:#fff;background-color:#fff;Margin:0px auto;border-radius:10px;width:100%;font-family: Arial,Helvetica, sans-serif;border:solid 1px #e0e0e0;\">\r\n"
			+ "                  <table class=\"body-wrap\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#fff;background-color:#fff;width:100%;border-radius:10px;\">\r\n"
			+ "                    <tbody>\r\n"
			+ "                      <tr>\r\n"
			+ "                        <td style=\"direction:ltr;font-size:10px;padding:15px;padding-top:15px;padding-bottom:50px;text-align:center;vertical-align:top;\">\r\n"
			+ "                          <div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:100%;\">\r\n"
			+ "                            <table class=\"body-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"10px\" role=\"presentation\" style=\"vertical-align:middle;\" width=\"100%\">\r\n"
			+ "                              \r\n"
			+ "								<tr>\r\n"
			+ "									<td align=\"left\" style=\"font-size:10px;padding:10px 25px;padding-right:25px;padding-left:25px;word-break:break-word;\">\r\n"
			+ "									<div style=\"font-family:Arial,Helvetica,sans-serif;font-size:15px;line-height:20px;text-align:center;color:#3c4043;\">\r\n"
			+ "										<center><img src=\"https://www.sbicard.com/sbi-card-en/resources/img/m-logo.png\" alt=\"SBI Card Logo\" style=\"max-width: 100%;\"/></center><br/><br/>\r\n"
			+ "										</div>\r\n"
			+ "									</td>\r\n"
			+ "								</tr>\r\n"
			+ "								\r\n"
			+ "								<tr th:each=\"msg:${msgList}\">\r\n"
			+ "									<td align=\"left\" style=\"font-size:10px;padding:10px 25px;padding-right:25px;padding-bottom:25px;padding-left:25px;word-break:break-word;\">\r\n"
			+ "										<div th:if=\"${msg.type} == '1'\" style=\"text-align: left;background-color: #cbe0f4; padding: 10px; border-radius: 5px; margin-bottom: 10px; float: left; clear: both; width: 400px;min-width:300px;font-size: 15px; \">\r\n"
			+ "									      <p style=\"font-weight: bold; font-size: 15px; color: #333; margin: 0;\"><span th:text=\"${msg.name}\"></span></p>\r\n"
			+ "									      <p style=\"margin: 5px 0;font-size: 13px; \"><span th:utext=\"${msg.messageText}\"></span></p>\r\n"
			+ "									      <p style=\"color: #888; font-size: 12px; margin: 0;\"><span th:text=\"${msg.receivedTime}\"></span></p>\r\n"
			+ "									    </div>\r\n"
			+ "									    <div th:unless=\"${msg.type} == '1'\"style=\"text-align: right;background-color: #eaf7fd; padding: 10px; border-radius: 5px; margin-bottom: 10px; float: right; clear: both; width: 400px;min-width:300px;font-size: 15px; \">\r\n"
			+ "									      <p style=\"font-weight: bold; color: #333; margin: 0;font-size: 15px; \"><span th:text=\"${msg.name}\"></span></p>\r\n"
			+ "									      <p style=\"margin: 5px 0;font-size: 13px; text-align : left \"><span th:utext=\"${msg.messageText}\"></span></p>\r\n"
			+ "									      <p style=\"color: #888; font-size: 12px; margin: 0;\"><span th:text=\"${msg.receivedTime}\"></span></p>\r\n"
			+ "									    </div>\r\n"
			+ "									</td>\r\n"
			+ "								</tr>\r\n"
			+ "							\r\n"
			+ "                             \r\n"
			+ "                            </table>\r\n"
			+ "                          </div>\r\n"
			+ "                        </td>\r\n"
			+ "                      </tr>\r\n"
			+ "                    </tbody>\r\n"
			+ "                  </table>\r\n"
			+ "                </div>\r\n"
			+ "				<!-- Body content ends -->\r\n"
			+ "				\r\n"
			+ "				\r\n"
			+ "              </td>\r\n"
			+ "            </tr>\r\n"
			+ "          </tbody>\r\n"
			+ "        </table>\r\n"
			+ "      </div>\r\n"
			+ "    </div>\r\n"
			+ "    <!--[if mso | IE]>\r\n"
			+ "            </td>\r\n"
			+ "		</tr>\r\n"
			+ "    </table>\r\n"
			+ "	<![endif]-->\r\n"
			+ "	<!-- Email Container ends -->\r\n"
			+ "	\r\n"
			+ "  </body>\r\n"
			+ "\r\n"
			+ "</html>";
	
	@Autowired private StringTemplateService templateService;
	@Autowired PasswordProtctedPdfService passwordProtctedPdfService;
	@Autowired private PdfService service;
	private Logger log = LoggerFactory.getLogger(StringTemplateController.class);
	
	@GetMapping("spt")
	public String trasncrpt() {
		log.info("Request Received passwordtrasncrpt");
		Map<String, Object> context = new HashMap<>();
		context.put("msgList", getMessages());
		String content =  templateService.getTemplateFromAttributes(template, context);
		System.out.println(content);
		return passwordProtctedPdfService.htmlStringToPdf(content);
	}
	
	@GetMapping("spdf")
	public String pdf() {
		log.info("Request Received pdf");
		Map<String, Object> context = new HashMap<>();
		context.put("msgList", getMessages());
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
