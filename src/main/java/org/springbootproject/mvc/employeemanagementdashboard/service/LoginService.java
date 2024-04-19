package org.springbootproject.mvc.employeemanagementdashboard.service;

import org.springbootproject.mvc.employeemanagementdashboard.dto.LoginCredentialDto;

import java.util.List;

public interface LoginService {
    List<LoginCredentialDto>readLoginCredentials();
}
