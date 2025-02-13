package com.traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.List;

@Data
@Entity
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CenterName is mandatory")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "CenterCode is mandatory")
    @Size(min = 12, max = 12, message = "CenterCode must be exactly 12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "CenterCode must be alphanumeric")
    private String centerCode;

    @Embedded
    @NotNull(message = "Address is mandatory")
    private Address address;

    @Min(value = 1, message = "Student Capacity must be at least 1")
    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @CreationTimestamp
    private long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "ContactPhone is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "ContactPhone must be a 10-digit number")
    private String contactPhone;
}

@Embeddable
@Data
class Address {
    @NotBlank(message = "Detailed Address is mandatory")
    private String detailedAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be a 6-digit number")
    private String pincode;
}