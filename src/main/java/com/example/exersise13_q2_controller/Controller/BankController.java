package com.example.exersise13_q2_controller.Controller;

import com.example.exersise13_q2_controller.Amount.Amount;
import com.example.exersise13_q2_controller.Api.ApiRespons;
import com.example.exersise13_q2_controller.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class BankController {
    ArrayList<Customers>customersList = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Customers> getCustomersList() {
        return customersList;
    }
   @PostMapping("/add")
    public ApiRespons addCustomer(@RequestBody Customers customer) {
        customersList.add(customer);
        return new ApiRespons("Customer Added Successfully");
    }
    @PutMapping("/update/{index}")
    public ApiRespons updateCustomer(@RequestBody Customers customers,@PathVariable int index) {
        customersList.set(index,customers);
        return new ApiRespons("Customer Updated Successfully");

    }
    @DeleteMapping("/delete/{index}")
    public ApiRespons deleteCustomer(@PathVariable int index) {
        customersList.remove(index);
        return new ApiRespons("Customer Deleted Successfully");

    }
    @PostMapping("/deposit/{index}")
    public ApiRespons deposit( @PathVariable int index,@RequestBody Amount amount) {
        Customers customer = customersList.get(index);
       customer.setBalance(customer.getBalance() +amount.getAmount());

        return new ApiRespons("Amount Deposited Successfully");

    }
    @PostMapping("/withdraw/{index}")
    public ApiRespons withdraw(@PathVariable int index, @RequestBody Amount amount) {
        Customers customer = customersList.get(index);
        if (customer.getBalance() >= amount.getAmount()) {
            customer.setBalance(customer.getBalance() - amount.getAmount());

            return new ApiRespons("Amount withdraw Successfully");

        }
      else  return new ApiRespons("not enough Balance");
    }

    }
