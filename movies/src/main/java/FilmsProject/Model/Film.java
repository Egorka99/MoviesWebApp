package FilmsProject.Model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Film {
    private String title;
    private String imdbIdentifier;
    private FilmType filmType;
    private String genre;
    private LocalDate releaseDate;
    private double rating;
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
