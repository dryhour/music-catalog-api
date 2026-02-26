package com.example.music_catalog_api.controllers;

import com.example.music_catalog_api.models.Artist;
import com.example.music_catalog_api.repositories.ArtistRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable String id) {
        return artistRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable String id, @RequestBody Artist updatedArtist) {
        return artistRepository.findById(id)
            .map(artist -> {
                artist.setUsername(updatedArtist.getUsername());
                artist.setSongIds(updatedArtist.getSongIds());
                artist.setGenre(updatedArtist.getGenre());
                artist.setPlaylistIds(updatedArtist.getPlaylistIds());
                return artistRepository.save(artist);
            })
            .orElse(null);
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist newArtist) {
        return artistRepository.save(newArtist);
    }
}