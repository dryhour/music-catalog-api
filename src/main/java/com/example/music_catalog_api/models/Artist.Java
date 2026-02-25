package com.example.music_catalog_api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "artists")
public class Artist {
    @Id
    private String id;
    private String username;
    private List<String> songIds;
    private String genre;
    private List<String> playlistIds;

    public String getId() { return id; }
    public String getUsername() { return username; }
    public List<String> getSongIds() { return songIds; }
    public String getGenre() { return genre; }
    public List<String> getPlaylistIds() { return playlistIds; }

    public void setUsername(String username) { this.username = username; }
    public void setSongIds(List<String> songIds) { this.songIds = songIds; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPlaylistIds(List<String> playlistIds) { this.playlistIds = playlistIds; }
}