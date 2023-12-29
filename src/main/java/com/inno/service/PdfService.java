package com.inno.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java. util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.PDFEncryption;

import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfService {
	private Logger log = LoggerFactory.getLogger(PdfService.class);

	public String htmlStringToPdf(String content) {
		String encodeBase64String = null;
		byte[] owner = "1234".getBytes();
		byte[] userPass = "12345".getBytes();
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(content);
			renderer.layout();
			renderer.setPDFEncryption(new PDFEncryption(owner, userPass, PdfWriter.ALLOW_COPY, PdfWriter.STANDARD_ENCRYPTION_40));
			renderer.createPDF(outputStream, false);
			renderer.finishPDF();
			encodeBase64String= saveFile(outputStream);
			log.info("Successfully encoded to base64 String");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return encodeBase64String;
	}

	private String saveFile(ByteArrayOutputStream byteArrayOutputStream) throws FileNotFoundException, IOException {
		
		FileOutputStream fout = new FileOutputStream("C:\\Users\\acer\\Desktop\\pdfservice.pdf");
		byteArrayOutputStream.writeTo(fout);
		byteArrayOutputStream.close();
		byteArrayOutputStream.flush();
		log.info("file created");
		fout.close();
		return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
	}

}
