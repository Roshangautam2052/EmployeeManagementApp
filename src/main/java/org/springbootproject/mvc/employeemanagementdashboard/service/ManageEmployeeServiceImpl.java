package org.springbootproject.mvc.employeemanagementdashboard.service;

import org.springbootproject.mvc.employeemanagementdashboard.dao.EmployeeRepo;
import org.springbootproject.mvc.employeemanagementdashboard.dto.EmployeeDto;
import org.springbootproject.mvc.employeemanagementdashboard.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageEmployeeServiceImpl implements ManageEmployeeService{
    private final EmployeeRepo employeeRepo;
    public ManageEmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .firstName(employeeDto.getFirstName())
                .middleName(employeeDto.getMiddleName())
                .lastName(employeeDto.getLastName())
                .phoneNumber(employeeDto.getPhoneNumber())
                .email(employeeDto.getEmail())
                .build();

        employeeEntity = employeeRepo.save(employeeEntity);
        return EmployeeDto.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .middleName(employeeEntity.getMiddleName())
                .lastName(employeeEntity.getLastName())
                .email(employeeEntity.getEmail())
                .phoneNumber(employeeEntity.getPhoneNumber())
                .build();
    }
    public List<EmployeeDto> findEntries(){
        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
        List<EmployeeDto>employeeDtoList = new ArrayList<>();
        for(EmployeeEntity entry: employeeEntityList){
            employeeDtoList.add(EmployeeDto.builder()
                    .id(entry.getId())
                    .firstName(entry.getFirstName())
                    .middleName(entry.getMiddleName())
                    .lastName(entry.getLastName())
                    .phoneNumber(entry.getPhoneNumber())
                    .email(entry.getEmail())
                    .build());
        }
        return employeeDtoList;

    }

    @Override
    public void deleteById(Integer theId) {
        employeeRepo.deleteById(theId);
    }

    @Override
    public EmployeeEntity findById(Integer id) {
       EmployeeEntity employeeEntity;
       Optional<EmployeeEntity>result = employeeRepo.findById(id);
       if(result.isPresent()){
           employeeEntity= result.get();
       }
       else {
           throw new RuntimeException("Did not find the employee" + id);
       }
       return employeeEntity;
    }
    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity){
        return employeeRepo.save(employeeEntity);
    }




}
