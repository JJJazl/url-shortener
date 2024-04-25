package com.example.urlshortener.controller;

import com.example.urlshortener.ShortenerService;
import com.example.urlshortener.model.UrlModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shortener")
public class UrlShortenerController {

    private final ShortenerService service;

    public UrlShortenerController(ShortenerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> acceptLongUrl(@RequestBody UrlModel urlModel) {
        return ResponseEntity.ok(service.createShortUrl(urlModel));

    }

    @GetMapping
    public void getShortUrl(@PathVariable String shortUrl) {

    }

}
