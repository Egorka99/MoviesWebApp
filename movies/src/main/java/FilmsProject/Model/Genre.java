package FilmsProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    @Column(name = "genre_id")
    private int genreId;

    @Column(name="genre_name")
    private int genreName;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getGenreName() {
        return genreName;
    }

    public void setGenreName(int genreName) {
        this.genreName = genreName;
    }
}
