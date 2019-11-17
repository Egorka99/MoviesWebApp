package FilmsProject.Model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue
    private Long reviewId;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="author_login")
    private String authorLogin;

    @Column(name="review_text")
    private String reviewText;

    @Column
    private double rating;

    public Review() {
    }

    public Review(Long reviewId, LocalDate createDate, String authorLogin, String reviewText, double rating) {
        this.reviewId = reviewId;
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
        return "Отзыв № "+getReviewId()+". Автор: "+getAuthorLogin()+". Дата создания: "+getCreateDate()+". Оценка: "+getRating()+"";
    }
}
