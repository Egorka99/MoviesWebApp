package FilmsProject.Model;


import java.time.LocalDate;

public class Review {

    private Long reviewId;
    private LocalDate createDate;
    private Person author;
    private String reviewText;
    private double Rating;

    public Review(Long reviewId, LocalDate createDate, Person author, String reviewText, double rating) {
        this.reviewId = reviewId;
        this.createDate = createDate;
        this.author = author;
        this.reviewText = reviewText;
        Rating = rating;
    }


    public LocalDate getCreateDate() {
        return createDate;
    }

    public Person getAuthor() {
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
