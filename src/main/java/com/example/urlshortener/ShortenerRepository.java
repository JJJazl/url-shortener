package com.example.urlshortener;

import com.example.urlshortener.entity.BoboUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenerRepository extends JpaRepository<BoboUrl, Long> {
    Optional<BoboUrl> findByKey(String key);
}
