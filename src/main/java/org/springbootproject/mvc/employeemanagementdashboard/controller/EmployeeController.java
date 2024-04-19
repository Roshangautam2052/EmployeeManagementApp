package org.springbootproject.mvc.employeemanagementdashboard.controller;

import jakarta.validation.Valid;
import org.springbootproject.mvc.employeemanagementdashboard.dto.EmployeeDto;
import org.springbootproject.mvc.employeemanagementdashboard.entity.EmployeeEntity;
import org.springbootproject.mvc.employeemanagementdashboard.service.ManageEmployeeServiceImpl;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final ManageEmployeeServiceImpl manageEmployeeServiceImpl;

    public EmployeeController(ManageEmployeeServiceImpl manageEmployeeServiceImpl) {
        this.manageEmployeeServiceImpl = manageEmployeeServiceImpl;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showDashboard")
    public String showDashBoard(Model model){
        model.addAttribute("employeeDtoList", manageEmployeeServiceImpl.findEntries());
        return "dash-board";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "add-employee";
    }

    @PostMapping("/save")
    @Transactional
    public String addEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                                        BindingResult theBindingResult, RedirectAttributes redirectAttributes
                                        ) {

        if(theBindingResult.hasErrors()){
            return "add-employee";
        }
        else {
            employeeDto = manageEmployeeServiceImpl.addEmployee(employeeDto);
            if(employeeDto.getId()!= null){
                redirectAttributes.addFlashAttribute("successMessage", employeeDto.getFirstName()+" Added Successfully");
                redirectAttributes.addFlashAttribute("employeeDtoList", manageEmployeeServiceImpl.findEntries());
            }

            return "redirect:/employee/addEmployee";

        }
    }
    @GetMapping("/delete")
    @Transactional
    public String deleteEmployee(@RequestParam("employeeId") Integer theId){
        // delete the employee
        manageEmployeeServiceImpl.deleteById(theId);

        // redirect to the dashboard
        return "redirect:/employee/showDashboard";

    }
  @GetMapping("/show-update-form")
    public String showUpdateEmployeeForm(@RequestParam("employeeId") Integer id, Model model ){
        EmployeeEntity employeeEntity= manageEmployeeServiceImpl.findById(id);
        model.addAttribute("updatedEmployeeEntity", employeeEntity);
        return "update-employee";
  }

  @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employeeUpdateDto") EmployeeEntity employeeEntity){
        manageEmployeeServiceImpl.save(employeeEntity);
        return "redirect:/employee/showDashboard";
  }
}
