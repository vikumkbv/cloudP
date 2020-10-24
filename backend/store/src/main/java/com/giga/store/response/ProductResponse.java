package com.giga.FashionStore.response;

import com.giga.FashionStore.model.Comment;
import com.giga.FashionStore.model.Discount;

import java.util.List;

/**
 * Single product com.giga.FashionStore.response com.giga.FashionStore.model
 */
public class ProductResponse {
    private String prod_id;
    private String prodName;
    private String prodDescription;
    private String prodPrice;
    private List<Comment> prodComments;
    private double prodRating;
    private double averageRating;
    private Discount prodDiscount;
    private String prodImage;

    public ProductResponse(String prod_id, String prodName, String prodDescription, String prodPrice, List<Comment> prodComments, double averageRating, Discount prodDiscount) {
        this.prod_id = prod_id;
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.prodPrice = prodPrice;
        this.prodComments = prodComments;
        this.averageRating = averageRating;
        this.prodDiscount = prodDiscount;
    }

    // getters & setters
    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescriptio) {
        this.prodDescription = prodDescriptio;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Comment> getProdComments() {
        return prodComments;
    }

    public void setProdComments(List<Comment> prodComments) {
        this.prodComments = prodComments;
    }

    public Discount getProdDiscount() {
        return prodDiscount;
    }

    public void setProdDiscount(Discount prodDiscount) {
        this.prodDiscount = prodDiscount;
    }

    public double getProdRating() {
        return prodRating;
    }

    public void setProdRating(double prodRating) {
        this.prodRating = prodRating;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }
}
