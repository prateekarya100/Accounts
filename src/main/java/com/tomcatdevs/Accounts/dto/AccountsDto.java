package com.tomcatdevs.Accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountsDto {
    @Pattern(regexp = "$|[0-9]{10}",message = "bank account number must be of 10 digit")
    private Long accountNumber;

    @NotEmpty(message = "bank account type must not be null or empty")
    private String accountType;

    @NotEmpty(message = "bank address must not be null or empty")
    @Size(min = 10,message = "bank address must be atleast of 10 digits")
    private String branchAddress;
}
