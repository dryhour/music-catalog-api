package com.example.music_catalog_api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<Song, String> {
    
}