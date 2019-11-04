package FilmsProject.Model;

import java.time.LocalDate;

public class Review {
    private static int maxId;

    private int ReviewId;
    private LocalDate createDate;
    private Person author;
    private String reviewText;
    private double Rating;

    public Review(LocalDate createDate, Person author, String reviewText, double rating) {
        this.createDate = createDate;
        this.author = author;
        this.reviewText = reviewText;
        Rating = rating;
        ReviewId = maxId+1;
        maxId++;
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

    public int getReviewId() {
        return ReviewId;
    }


}
