package com.inno;


import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ironsoftware.ironpdf.internal.proto.PdfDocument;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.clipper.Paths;


@Service
public class DocumentGenerator {

	private Logger log = LoggerFactory.getLogger(DocumentGenerator.class);

	public void htmlStringToPdf(String content) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			PdfWriter pdfwriter = new PdfWriter(byteArrayOutputStream);
			DefaultFontProvider defaultFont = new DefaultFontProvider(false, true, false);
			ConverterProperties converterProperties = new ConverterProperties();
			converterProperties.setFontProvider(defaultFont);
			HtmlConverter.convertToPdf(content, pdfwriter, converterProperties);
			FileOutputStream fout = new FileOutputStream("C:\\Users\\acer\\Desktop\\employee.pdf");
			byteArrayOutputStream.writeTo(fout);
			byteArrayOutputStream.close();
			byteArrayOutputStream.flush();
			log.info("file created");
			fout.close();

		} catch (Exception ex) {
			log.error("Exception := "+ex.getMessage());
		}
	}
}
