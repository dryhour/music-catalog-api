package com.example.music_catalog_api.controllers;

import com.example.music_catalog_api.models.Playlist;
import com.example.music_catalog_api.repositories.PlaylistRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable String id) {
        return playlistRepository.findById(id).orElse(null);
    }
}