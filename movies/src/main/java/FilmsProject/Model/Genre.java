package FilmsProject.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    //TODO Long
    @Id
    @Column(name = "genre_id")
    @SequenceGenerator(name= "GENRE_SEQUENCE", sequenceName = "GENRE_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="GENRE_SEQUENCE")
    private int genreId;

    @Column(name="genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films = new ArrayList<>();

    public Genre() {
    }

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
