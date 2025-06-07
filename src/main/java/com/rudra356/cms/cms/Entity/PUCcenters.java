package com.rudra356.cms.cms.Entity;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class PUCcenters {
    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    @NotBlank(message = "Center name is mandatory")
    @Size(min = 3, max = 100, message = "Center name must be between 3 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Center name can contain only letters and spaces")
    private String centerName;

    @NonNull
    @NotBlank(message = "Owner name is mandatory")
    @Size(min = 3, max = 50, message = "Owner name must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Owner name can contain only letters and spaces")
    private String ownerName;

    @NonNull
    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Contact number must be a valid 10-digit Indian mobile number")
    private String contactNumber;

    @NonNull
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NonNull
    @NotBlank(message = "Address is mandatory")
    @Size(max = 200, message = "Address can be max 200 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ,./#'-]+$", message = "Address contains invalid characters")
    private String address;

    @NonNull
    @NotBlank(message = "City is mandatory")
    @Size(min = 2, max = 20, message = "City name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "City can contain only letters and spaces")
    private String city;

    @NonNull
    @NotBlank(message = "State is mandatory")
    @Size(min = 2, max = 20, message = "State name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "State can contain only letters and spaces")
    private String state;

    @NonNull
    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pincode must be a valid 6-digit Indian postal code")
    private String pincode;

    private LocalDateTime registrationDate;

    private LocalDateTime expiryDate;

    @NonNull
    private boolean isActive;
}
