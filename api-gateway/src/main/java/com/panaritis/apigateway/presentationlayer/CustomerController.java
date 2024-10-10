package com.panaritis.apigateway.presentationlayer;

import com.panaritis.apigateway.businesslayer.customerservices.CustomerService;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerRequestModel;
import com.panaritis.apigateway.presentationlayer.customerdtos.CustomerResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<CustomerResponseModel>> getCustomers(){
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseModel> getCustomerById(@PathVariable String customerId){
        return ResponseEntity.ok().body(customerService.getCustomerById(customerId));
    }

    @PostMapping(value = "",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<CustomerResponseModel> addCustomer(@RequestBody CustomerRequestModel customerRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customerRequestModel));
    }

    @PutMapping(value = "/{customerId}",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<CustomerResponseModel> updateCustomer(@RequestBody CustomerRequestModel customerRequestModel,
                                                                @PathVariable String customerId){
        customerService.updateCustomer(customerId, customerRequestModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId){
        customerService.removeCustomer(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
