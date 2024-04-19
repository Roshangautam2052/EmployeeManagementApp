package org.springbootproject.mvc.employeemanagementdashboard.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Integer id;
    @NotNull(message ="is required")
    @Pattern(regexp="^[a-zA-Z]*$", message ="Only alphabets are allowed")
    private String firstName;

    @Pattern(regexp="^[a-zA-Z]*$", message ="Only alphabets are allowed")
    private String middleName;

    @NotNull(message ="is required")
    @Pattern(regexp="^[a-zA-Z]*$", message ="Only alphabets are allowed")
    private String lastName;

    @NotNull(message ="is required")
    private String phoneNumber;

    @NotNull(message ="is required")
    private String email;

}
