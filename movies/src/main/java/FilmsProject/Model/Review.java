package filmsproject.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="author_login")
    private String authorLogin;

    @Column(name = "film_identifier")
    private String filmIdentifier;

    @Column(name="review_text")
    private String reviewText;

    @Column
    private double rating;

    public Review() {
    }

    public Review(LocalDate createDate, String authorLogin, String reviewText, double rating) {
        this.createDate = createDate;
        this.authorLogin = authorLogin;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public double getRating() {
        return rating;
    }

    public String getFilmIdentifier() {
        return filmIdentifier;
    }

    public void setFilmIdentifier(String filmIdentifier) {
        this.filmIdentifier = filmIdentifier;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setAuthorLogin(String authorLogin) {
        this.authorLogin = authorLogin;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Отзыв № "+getReviewId()+" к фильму №"+ getFilmIdentifier()+". Автор: "+getAuthorLogin()+". Дата создания: "+getCreateDate()+". Оценка: "+getRating()+"";
    }
}
