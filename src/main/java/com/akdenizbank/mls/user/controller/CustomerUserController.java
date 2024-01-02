package com.akdenizbank.mls.user.controller;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.user.service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/customer-users")
public class CustomerUserController {
    @Autowired
    private CustomerUserService customerUserService;


    @GetMapping
    public GenericApiResponse getAllCustomers(Pageable pageable){
        Page<CustomerUser> customerUserPage=customerUserService.getAllCustomers(pageable);
        return new GenericApiResponse(200,"Success","123123",customerUserPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getCustomerByID(@PathVariable String id){
        CustomerUser customerUserInDB= customerUserService.getCustomerByID(id);
        if (customerUserInDB == null) {
            throw new RuntimeException("No such Customer");
        }
        return new GenericApiResponse(200,"Success","123123",customerUserInDB);
    }
    @DeleteMapping("/{id}")
    public GenericApiResponse deleteCustomer(@PathVariable String id){
        CustomerUser customerUserInDB= customerUserService.getCustomerByID(id);
        if (customerUserInDB == null) {
            throw new RuntimeException("No such Customer");
        }
        customerUserService.deleteCustomer(id);
        return new GenericApiResponse(200,"Success","123123");
    }
}
