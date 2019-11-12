package FilmsProject.Model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film {
    @Column(name = "title")
    private String title;

    @Column(name = "imdbIdentifier",unique = true)
    private String imdbIdentifier;

    @Enumerated(EnumType.STRING)
    private FilmType filmType;

    @Column(name = "genre")
    private String genre;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "rating")
    private double rating;

    @Column(name = "description")
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
