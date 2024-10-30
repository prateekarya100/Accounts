package com.tomcatdevs.Accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;

   //nested mapping accountsDto details to customerDto
    private AccountsDto accountsDto;
}
