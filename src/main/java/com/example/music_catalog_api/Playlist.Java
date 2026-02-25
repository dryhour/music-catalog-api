import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "playlists")
public class Playlist {
    @Id
    private String id;
    private String title;
    private List<String> songIds;
    private String artistId;
    private String genre;

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getArtistId() { return artistId; }
    public List<String> getSongIds() { return songIds; }
    public String getGenre() { return genre; }

    public void setTitle(String title) { this.title = title; }
    public void setSongIds(List<String> songIds) { this.songIds = songIds; }
    public void setArtistId(String artistId) { this.artistId = artistId; }
    public void setGenre(String genre) { this.genre = genre; }
}