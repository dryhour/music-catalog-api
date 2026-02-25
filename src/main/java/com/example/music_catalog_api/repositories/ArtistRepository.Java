package com.example.music_catalog_api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Song, String> {
    
}