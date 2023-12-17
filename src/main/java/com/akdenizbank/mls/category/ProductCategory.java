package com.akdenizbank.mls.category;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.akdenizbank.mls.product.Product;
import com.akdenizbank.mls.util.StringSequenceIdentifier;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class ProductCategory {

    
    @Id
    @GenericGenerator(name = "random-15", type = StringSequenceIdentifier.class, parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Product> products;

}
