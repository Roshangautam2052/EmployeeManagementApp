package org.springbootproject.mvc.employeemanagementdashboard.dao;

import org.springbootproject.mvc.employeemanagementdashboard.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
