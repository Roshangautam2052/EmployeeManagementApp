package org.springbootproject.mvc.employeemanagementdashboard.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginCredentialDto {
    private Integer id;
    private String userName;
    private String password;
}
