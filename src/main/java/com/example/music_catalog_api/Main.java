package com.example.music_catalog_api;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.music_catalog_api.models.Artist;
import com.example.music_catalog_api.models.Playlist;
import com.example.music_catalog_api.models.Song;
import com.example.music_catalog_api.repositories.ArtistRepository;
import com.example.music_catalog_api.repositories.PlaylistRepository;
import com.example.music_catalog_api.repositories.SongRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Main implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public void run(String... args) throws Exception {
        /*
        songRepository.deleteAll();
        artistRepository.deleteAll();
        playlistRepository.deleteAll();
        */
        if (songRepository.count() == 0 && artistRepository.count() == 0 && playlistRepository.count() == 0) {
            Song song1 = new Song("Phantom Bride", "Rock", 293);
            Song song2 = new Song("Xenon", "Rock", 197);
            Song song3 = new Song("Gore", "Rock", 299);
            Song song4 = new Song("Hearts / Wires", "Rock", 320);

            songRepository.saveAll(List.of(song1, song2, song3, song4));

            Artist artist1 = new Artist();
            artist1.setUsername("Deftones");
            artist1.setGenre("Rock");
            artist1.setSongIds(List.of(
                song1.getId(),
                song2.getId(),
                song3.getId(),
                song4.getId()
            ));
            artistRepository.save(artist1);

            song1.setArtistId(artist1.getId());
            song2.setArtistId(artist1.getId());
            song3.setArtistId(artist1.getId());
            song4.setArtistId(artist1.getId());
            songRepository.saveAll(List.of(song1, song2, song3, song4));

            Playlist playlist1 = new Playlist();
            playlist1.setTitle("Gore");
            playlist1.setGenre("Rock");
            playlist1.setArtistId(artist1.getId());
            playlist1.setSongIds(List.of(
                song1.getId(),
                song2.getId(),
                song3.getId(),
                song4.getId()
            ));
            playlistRepository.save(playlist1);

            logger.info("Sample data inserted!");
        } else {
            logger.info("Data already exists, skipping sample data insertion.");
        }
    }
}