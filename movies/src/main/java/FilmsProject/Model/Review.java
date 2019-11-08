package FilmsProject.Model;


import java.time.LocalDate;

public class Review {
    private static Long maxId;

    private Long reviewId;
    private LocalDate createDate;
    private Person author;
    private String reviewText;
    private double Rating;

    public Review(LocalDate createDate, Person author, String reviewText, double rating) {
        this.createDate = createDate;
        this.author = author;
        this.reviewText = reviewText;
        Rating = rating;
        reviewId = maxId+1;
        maxId++;
    }

    public Review() {
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
