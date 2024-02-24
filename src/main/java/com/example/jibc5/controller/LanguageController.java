package com.example.jibc5.controller;

import com.example.jibc5.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LanguageController {

    @Autowired
    private TranslationService translationService;

    @GetMapping("/change-language")
    public ResponseEntity<Map<String, String>> changeLanguage(@RequestParam String lang) {
        if (lang == null || lang.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Map<String, String> translations = translationService.getTranslations(lang);
        if (translations == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok().body(translations);
    }
}
