package com.giga.store.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Product model.
 */
@Entity
public class Product {
    public static final String SEQUENCE_NAME = "product_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String prod_id;
    private String prodName;
    private String prodDescription;
    private String prodPrice;
//    private String prodImage;
//    @DBRef
//    private Category prodCategory;
//    @DBRef
//    private Discount prodDiscount;
//    @DBRef
//    private List<Comment> prodComments = new ArrayList<>();
//    @DBRef
//    private List<Rating> prodRatings = new ArrayList<>();

    public Product() {}

    public Product(String prod_id, String prodName, String prodDescription, String prodPrice) {
        this.prod_id = prod_id;
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.prodPrice = prodPrice;
    }

    // getters
    public String getProd_id() {
        return prod_id;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public String getProdPrice() {
        return prodPrice;
    }

//    public Category getProdCategory() {
//        return prodCategory;
//    }
//
//    public Discount getProdDiscount() {
//        return prodDiscount;
//    }
//
//    public List<Comment> getProdComments() {
//        return prodComments;
//    }
//
//    public List<Rating> getProdRatings() {
//        return prodRatings;
//    }
//
//    public String getProdImage() {
//        return prodImage;
//    }

    // setters
    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }
//
//    public void setProdCategory(Category prodCategory) {
//        this.prodCategory = prodCategory;
//    }
//
//    public void setProdDiscount(Discount prodDiscount) {
//        this.prodDiscount = prodDiscount;
//    }
//
//    public void setProdComments(List<Comment> prodComments) {
//        this.prodComments = prodComments;
//    }
//
//    public void setProdRatings(List<Rating> prodRatings) {
//        this.prodRatings = prodRatings;
//    }
//
//    public void setProdImage(String prodImage) {
//        this.prodImage = prodImage;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prod_id == null) ? 0 : prod_id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (prod_id == null) {
            return other.prod_id == null;
        } else return prod_id.equals(other.prod_id);
    }
}
