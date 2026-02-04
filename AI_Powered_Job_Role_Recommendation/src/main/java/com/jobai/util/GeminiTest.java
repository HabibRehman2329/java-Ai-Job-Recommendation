package com.jobai.util;

public class GeminiTest {

	public static void main(String[] args) {

		String rawResponse = GeminiAIUtil.getTestResponse();

		System.out.println("=== RAW JSON RESPONSE ===");
		System.out.println(rawResponse);

		String extractedText = GeminiAIUtil.extractTextFromResponse(rawResponse);

		System.out.println("\n=== EXTRACTED AI TEXT ===");
		System.out.println(extractedText);
	}
}
