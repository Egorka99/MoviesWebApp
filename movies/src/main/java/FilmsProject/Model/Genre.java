package FilmsProject.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    @Id
    @Column(name = "genre_id")
    @SequenceGenerator(name= "GENRE_SEQUENCE", sequenceName = "GENRE_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="GENRE_SEQUENCE")
    private Long genreId;

    @Column(name="genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films = new ArrayList<>();

    public Genre() {
    }

    public Long getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
