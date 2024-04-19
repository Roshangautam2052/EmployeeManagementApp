package org.springbootproject.mvc.employeemanagementdashboard.dao;

import org.springbootproject.mvc.employeemanagementdashboard.entity.LoginCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginCredentialRepo extends JpaRepository<LoginCredentialEntity, Integer> {
}
