package org.springbootproject.mvc.employeemanagementdashboard.service;

import org.springbootproject.mvc.employeemanagementdashboard.dto.EmployeeDto;
import org.springbootproject.mvc.employeemanagementdashboard.entity.EmployeeEntity;

import java.util.List;

public interface ManageEmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findEntries();

    void deleteById(Integer theId);

    EmployeeEntity findById(Integer id);

    EmployeeEntity save(EmployeeEntity employeeEntity);

}
