package com.example.music_catalog_api.repositories;

import com.example.music_catalog_api.models.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
    
}