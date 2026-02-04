package com.jobai.util;

public class AiTextUtil {

    public static String cleanAiResponse(String aiText) {
        if (aiText == null) return "";

        return aiText
                .replaceAll("[#*`•-]", "")
                .replaceAll("\\s{2,}", " ")
                .trim();
    }
}
