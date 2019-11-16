package FilmsProject.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {

    @Column
    private String title;

    @Id
    @Column(name = "imdb_identifier",unique = true)
    private String imdbIdentifier;

    @Column(name = "film_type")
    @Enumerated(EnumType.ORDINAL)
    private FilmType filmType;

    @Column
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column
    private double rating;

    @Column
    private String description;

    public Film(String title, String imdbIdentifier, FilmType filmType, String genre, LocalDate releaseDate, double rating,
                String description) {
        this.title = title;
        this.imdbIdentifier = imdbIdentifier;
        this.filmType = filmType;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.description = description;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public String getImdbIdentifier() {
        return imdbIdentifier;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

}
