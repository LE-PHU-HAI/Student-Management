package com.example.jibc5.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationService {

    public Map<String, String> getTranslations(String lang) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Đọc dữ liệu từ tệp JSON theo ngôn ngữ đã chọn
            File file = new File("src/main/resources/static/js/lang.json");
            Map<String, Map<String, String>> translations = objectMapper.readValue(file, Map.class);
            if (translations.containsKey(lang)) {
                return translations.get(lang);
            } else {
                throw new IllegalArgumentException("Unsupported language: " + lang);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read translations file", e);
        }
    }
}
