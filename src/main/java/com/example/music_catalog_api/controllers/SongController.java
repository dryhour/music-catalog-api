package com.example.music_catalog_api.controllers;

import com.example.music_catalog_api.models.Song;
import com.example.music_catalog_api.repositories.SongRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable String id) {
        return songRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable String id, @RequestBody Song updatedSong) {
        return songRepository.findById(id)
            .map(song -> {
                song.setTitle(updatedSong.getTitle());
                song.setGenre(updatedSong.getGenre());
                song.setArtistId(updatedSong.getArtistId());
                song.setDurationSeconds(updatedSong.getDurationSeconds());
                return songRepository.save(song);
            })
            .orElse(null);
    }

    @PostMapping
    public Song createSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }
}