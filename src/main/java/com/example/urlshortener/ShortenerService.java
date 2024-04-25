package com.example.urlshortener;

import com.example.urlshortener.entity.BoboUrl;
import com.example.urlshortener.model.UrlModel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenerService {

    private final ShortenerRepository shortenerRepository;

    public String createShortUrl(UrlModel urlModel) {
        String shortUrl = RandomStringUtils.randomAlphabetic(5);
        BoboUrl boboUrl = new BoboUrl();
        boboUrl.setUrl(urlModel.getUrl());
        boboUrl.setKey(urlModel.getKey());

        shortenerRepository.save(boboUrl);

        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
//        shortenerRepository.findByShortUrl(shortUrl)
//                .orElseThrow();
        return null;
    }
}
