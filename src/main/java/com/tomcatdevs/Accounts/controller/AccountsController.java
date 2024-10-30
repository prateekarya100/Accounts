package com.tomcatdevs.Accounts.controller;

import com.tomcatdevs.Accounts.dto.CustomerDto;
import com.tomcatdevs.Accounts.dto.ResponseDto;
import com.tomcatdevs.Accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(path = "/api",produces = "application/json")
@AllArgsConstructor
public class AccountsController {

//    @Autowired
    private IAccountsService iAccountsService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto> create(@RequestBody CustomerDto customerDto){
        System.out.println(customerDto);
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.toString(),"account created"));
    }

    @GetMapping(value = "/fetch")
    public ResponseEntity<CustomerDto> fetch(@RequestParam String mobileNumber){
        CustomerDto customerDto=iAccountsService.fetchAccountDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ResponseDto> update(@RequestBody CustomerDto customerDto){
        boolean isUpdated = iAccountsService.updateCustomerAccountDetails(customerDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new ResponseDto(HttpStatus.ACCEPTED.toString(),"account updated successfully"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(HttpStatus.EXPECTATION_FAILED.toString(),"customer account details updation failed"));
        }
    }

    @DeleteMapping(value = "/delete")
    ResponseEntity<ResponseDto> delete(@RequestParam String mobileNumber){
        boolean isDeleted=iAccountsService.deleteCustomerAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(HttpStatus.OK.toString(),"customer account deleted successfully"));
        }else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(HttpStatus.EXPECTATION_FAILED.toString(),"customer account deletion failed"));
        }
    }

}
