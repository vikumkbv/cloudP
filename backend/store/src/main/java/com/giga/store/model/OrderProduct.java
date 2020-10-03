package com.giga.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Order products model
 */
@Entity(name = "orderProducts")
public class OrderProduct {
    public static final String SEQUENCE_NAME = "orderProducts_sequence";

    @Id
    private String orderProductsId;
    private String prod_Id;
    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(String orderProductsId, String prod_Id, int quantity) {
        this.orderProductsId = orderProductsId;
        this.prod_Id = prod_Id;
        this.quantity = quantity;
    }

    public String getOrderProductsId() {
        return orderProductsId;
    }

    public void setOrderProductsId(String orderProductsId) {
        this.orderProductsId = orderProductsId;
    }

    public String getProd_Id() {
        return prod_Id;
    }

    public void setProd_Id(String prod_Id) {
        this.prod_Id = prod_Id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
