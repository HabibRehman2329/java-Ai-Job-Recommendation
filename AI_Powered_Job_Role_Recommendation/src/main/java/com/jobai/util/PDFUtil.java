package com.jobai.util;

import java.io.InputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {

	public static String extractText(InputStream inputStream) {
		try (PDDocument doc = PDDocument.load(inputStream)) {
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
