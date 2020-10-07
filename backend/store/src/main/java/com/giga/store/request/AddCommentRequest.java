package com.giga.FashionStore.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Add comment to product com.giga.FashionStore.request
 */
public class AddCommentRequest {
    @NotNull
    @Min(0)
    private String user_Id;
    @NotNull
    @Min(0)
    private String prod_Id;
    @Size(min = 3, max = 100)
    private String comment;
    @Min(0)
    @Max(5)
    private double rating;

    // getters & setters
    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProd_Id() {
        return prod_Id;
    }

    public void setProd_Id(String prod_Id) {
        this.prod_Id = prod_Id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
