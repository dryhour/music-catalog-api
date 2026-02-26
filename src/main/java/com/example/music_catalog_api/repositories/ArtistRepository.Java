package com.example.music_catalog_api.repositories;

import com.example.music_catalog_api.models.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {
    
}