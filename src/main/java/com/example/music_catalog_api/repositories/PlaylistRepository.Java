package com.example.music_catalog_api.repositories;

import com.example.music_catalog_api.models.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {
    
}