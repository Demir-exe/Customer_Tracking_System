package com.akdenizbank.mls.user;

import java.util.Set;

import com.akdenizbank.mls.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerUser extends AppUser {

}
