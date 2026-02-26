package com.example.music_catalog_api.controllers;

import com.example.music_catalog_api.models.Artist;
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

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable String id, @RequestBody Playlist updatedPlaylist) {
        return playlistRepository.findById(id)
            .map(playlist -> {
                playlist.setTitle(updatedPlaylist.getTitle());
                playlist.setSongIds(updatedPlaylist.getSongIds());
                playlist.setGenre(updatedPlaylist.getGenre());
                playlist.setArtistId(updatedPlaylist.getArtistId());
                return playlistRepository.save(playlist);
            })
            .orElse(null);
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist newPlaylist) {
        return playlistRepository.save(newPlaylist);
    }
}