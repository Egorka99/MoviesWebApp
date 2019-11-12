package FilmsProject.Model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    @Column(name = "createDate")
    private LocalDate createDate;

    //TODO ???
    private User author;

    @Column(name = "reviewText")
    private String reviewText;

    @Column(name = "rating")
    private double Rating;

    public Review(Long reviewId, LocalDate createDate, User author, String reviewText, double rating) {
        this.reviewId = reviewId;
        this.createDate = createDate;
        this.author = author;
        this.reviewText = reviewText;
        Rating = rating;
    }


    public LocalDate getCreateDate() {
        return createDate;
    }

    public User getAuthor() {
        return author;
    }

    public String getReviewText() {
        return reviewText;
    }

    public double getRating() {
        return Rating;
    }

    public Long getReviewId() {
        return reviewId;
    }

    @Override
    public String toString() {
        return "Отзыв № "+getReviewId()+". Автор: "+getAuthor().getName()+". Дата создания: "+getCreateDate()+". Оценка: "+getRating()+"";
    }
}
