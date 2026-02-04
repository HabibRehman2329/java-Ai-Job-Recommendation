package com.jobai.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeminiAIUtil {

	// 🔑 PUT YOUR GEMINI API KEY HERE
	private static final String API_KEY = "AIzaSyDkhbwd1zyt2iY4PLBQaQtbHcwKY2G1RtQ";

	// Gemini API URL (Stable)
	private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
			+ API_KEY;

	public static String getTestResponse() {

		StringBuilder responseText = new StringBuilder();

		try {
			URL url = new URL(GEMINI_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);

			String requestBody = """
					{
					  "contents": [
					    {
					      "parts": [
					        { "text": "Say hello to a Java student in one sentence." }
					      ]
					    }
					  ]
					}
					""";

			try (OutputStream os = con.getOutputStream()) {
				os.write(requestBody.getBytes());
			}

			int statusCode = con.getResponseCode();
			System.out.println("HTTP Status Code: " + statusCode);

			BufferedReader br;

			if (statusCode >= 200 && statusCode < 300) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line;
			while ((line = br.readLine()) != null) {
				responseText.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseText.toString();
	}

	public static String extractTextFromResponse(String jsonResponse) {

		if (jsonResponse == null || jsonResponse.isEmpty()) {
			return "No response from AI.";
		}

		String searchKey = "\"text\":";
		int index = jsonResponse.indexOf(searchKey);

		if (index == -1) {
			return "AI response text not found.";
		}

		// Move index to start of actual text
		int start = jsonResponse.indexOf("\"", index + searchKey.length()) + 1;
		int end = jsonResponse.indexOf("\"", start);

		if (start < 0 || end < 0) {
			return "Unable to parse AI response.";
		}

		return jsonResponse.substring(start, end);
	}

	public static String getJobSuggestionsFromResume(String resumeText) {

		// Safety check (avoid huge prompt or empty input)
		if (resumeText == null || resumeText.trim().isEmpty()) {
			return "No resume content found to analyze.";
		}

		// Optional: limit text length to avoid token overload
		if (resumeText.length() > 4000) {
			resumeText = resumeText.substring(0, 4000);
		}

		String prompt = "You are an AI career expert and resume analyzer. "
				+ "Based on the following resume content, suggest 3 suitable IT job roles. "
				+ "For each role, give a short explanation and 2 missing skills to improve.\n\n" + "Resume Content:\n"
				+ resumeText;

		StringBuilder responseText = new StringBuilder();

		try {
			URL url = new URL(GEMINI_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);

			String requestBody = """
					{
					  "contents": [
					    {
					      "parts": [
					        { "text": "%s" }
					      ]
					    }
					  ]
					}
					""".formatted(prompt.replace("\"", "\\\""));

			try (OutputStream os = con.getOutputStream()) {
				os.write(requestBody.getBytes());
			}

			int statusCode = con.getResponseCode();

			BufferedReader br;
			if (statusCode >= 200 && statusCode < 300) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line;
			while ((line = br.readLine()) != null) {
				responseText.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Error communicating with AI service.";
		}

		// Extract & clean AI output
		String aiText = extractTextFromResponse(responseText.toString());
		aiText = aiText.replace("\\n", "\n");

		return aiText;
	}

	public static String getJobSuggestionsFromSkills(String skills) {

		if (skills == null || skills.trim().isEmpty()) {
			return "No skills provided for analysis.";
		}

		String prompt = "You are a career guidance expert. "
				+ "Based on the following skills, suggest 3 suitable IT job roles "
				+ "with a short explanation for each role.\n\n" + "Skills: " + skills;

		StringBuilder responseText = new StringBuilder();

		try {
			URL url = new URL(GEMINI_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);

			String requestBody = """
					{
					  "contents": [
					    {
					      "parts": [
					        { "text": "%s" }
					      ]
					    }
					  ]
					}
					""".formatted(prompt.replace("\"", "\\\""));

			try (OutputStream os = con.getOutputStream()) {
				os.write(requestBody.getBytes());
			}

			int statusCode = con.getResponseCode();

			BufferedReader br;
			if (statusCode >= 200 && statusCode < 300) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line;
			while ((line = br.readLine()) != null) {
				responseText.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Error communicating with AI service.";
		}

		// Extract & clean AI text
		String aiText = extractTextFromResponse(responseText.toString());
		aiText = aiText.replace("\\n", "\n");

		return aiText;
	}

}
