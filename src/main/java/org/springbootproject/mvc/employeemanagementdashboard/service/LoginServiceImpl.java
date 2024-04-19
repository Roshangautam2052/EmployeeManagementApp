package org.springbootproject.mvc.employeemanagementdashboard.service;

import org.springbootproject.mvc.employeemanagementdashboard.dao.LoginCredentialRepo;
import org.springbootproject.mvc.employeemanagementdashboard.dto.LoginCredentialDto;
import org.springbootproject.mvc.employeemanagementdashboard.entity.LoginCredentialEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{
    private final LoginCredentialRepo loginCredentialRepo;
    public LoginServiceImpl(LoginCredentialRepo loginCredentialRepo){
        this.loginCredentialRepo= loginCredentialRepo;
    }
    @Override
    public List<LoginCredentialDto> readLoginCredentials() {
        List<LoginCredentialEntity> loginCredentialEntity = loginCredentialRepo.findAll();
        List<LoginCredentialDto>loginCredentialDto = new ArrayList<>();
        for(LoginCredentialEntity loginDetail : loginCredentialEntity){
            loginCredentialDto.add(
                   LoginCredentialDto
                           .builder()
                           .id(loginDetail.getId())
                           .userName(loginDetail.getUserName())
                           .password(loginDetail.getPassword())
                           .build()

            );
        }
        return loginCredentialDto;
    }

}


