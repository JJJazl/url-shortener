package com.example.urlshortener.controller;

import com.example.urlshortener.ShortenerService;
import com.example.urlshortener.model.UrlModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/shortener")
public class UrlShortenerController {

    private final ShortenerService service;

    public UrlShortenerController(ShortenerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> acceptLongUrl(@RequestBody UrlModel urlModel) {
        String responseUrl = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(service.createShortUrl(urlModel))
                .buildAndExpand()
                .toString();
        return ResponseEntity.ok(responseUrl);

    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> getShortUrl(@PathVariable String shortUrl) {
        var originalUrl = service.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("location", originalUrl)
                .build();
    }

}
