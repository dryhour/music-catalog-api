import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
public class Song {
    @Id
    private String id;
    private String title;
    private String artistId;
    private String genre;
    private int durationSeconds;

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getArtistId() { return artistId; }
    public String getGenre() { return genre; }
    public int getDurationSeconds() { return durationSeconds; }

    public void setTitle(String title) { this.title = title; }
    public void setArtistId(String artistId) { this.artistId = artistId; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setDurationSeconds(int durationSeconds) { this.durationSeconds = durationSeconds; }
}