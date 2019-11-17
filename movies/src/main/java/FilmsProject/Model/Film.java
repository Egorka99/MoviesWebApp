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

    //TODO Убрать genre
    @Column
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column
    private double rating;

    @Column
    private String description;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "FILM_GENRE",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres = new ArrayList<>();

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

    public void addGenre(Genre genre){
        genres.add(genre);
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImdbIdentifier(String imdbIdentifier) {
        this.imdbIdentifier = imdbIdentifier;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
