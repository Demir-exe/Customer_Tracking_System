package com.akdenizbank.mls.xaction;

import com.akdenizbank.mls.category.ProductCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductXAction {
    public  String name;
    private String id;
    private String price;
    public ProductCategory Category;
}
