package com.akdenizbank.mls.order;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.akdenizbank.mls.product.Product;
import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.util.StringSequenceIdentifier;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="userorder")
public class Order {

    @Id
    @GenericGenerator(name = "random-15", type = StringSequenceIdentifier.class, parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    private String name;

    @OneToMany(mappedBy = "userorder", cascade = CascadeType.REMOVE)
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerUser customer;

}
