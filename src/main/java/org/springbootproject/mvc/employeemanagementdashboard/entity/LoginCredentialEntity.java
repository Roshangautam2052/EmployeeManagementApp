package org.springbootproject.mvc.employeemanagementdashboard.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "login_credential")
@Entity
public class LoginCredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name="password")
    private String password;
}
