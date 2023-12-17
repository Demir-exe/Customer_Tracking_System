package com.akdenizbank.mls.product;

import org.hibernate.annotations.GenericGenerator;

import com.akdenizbank.mls.category.ProductCategory;
import com.akdenizbank.mls.order.Order;
import com.akdenizbank.mls.util.StringSequenceIdentifier;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GenericGenerator(name = "random-15", type = StringSequenceIdentifier.class, parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties({"products"})
    private Order userorder;
}
