package com.akdenizbank.mls.user.service;
import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.user.repository.CustomerUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserService {
    private CustomerUserRepository customerUserRepository;

    public CustomerUserService(CustomerUserRepository customerUserRepository){
        this.customerUserRepository=customerUserRepository;
    }

    public CustomerUser create(CustomerUser customerUser){
        return this.customerUserRepository.save(customerUser);
    }

    public CustomerUser getCustomerByID(String id){
        return this.customerUserRepository.findById(id).orElse(null);
    }
    public CustomerUser getByEmail(String email) {
        return this.customerUserRepository.findByEmail(email).orElse(null);
    }

    public Page<CustomerUser> getAllCustomers(Pageable pageable){
        return this.customerUserRepository.findAll(pageable);
    }

    public void deleteCustomer(String id){
        CustomerUser customerUserInDB=getCustomerByID(id);
        if (customerUserInDB == null) {
            throw new RuntimeException("No Such Customer");
        }
        customerUserRepository.delete(customerUserInDB);
    }



}
