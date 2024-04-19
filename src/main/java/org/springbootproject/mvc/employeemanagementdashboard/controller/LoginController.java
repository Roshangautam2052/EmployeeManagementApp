package org.springbootproject.mvc.employeemanagementdashboard.controller;

import org.springbootproject.mvc.employeemanagementdashboard.dto.LoginCredentialDto;
import org.springbootproject.mvc.employeemanagementdashboard.service.LoginService;
import org.springbootproject.mvc.employeemanagementdashboard.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginServiceImpl loginServiceImpl) {
        this.loginService = loginServiceImpl;
    }

    @GetMapping("/")
    public String openLoginPage(Model model) {
        model.addAttribute("loginCredentials", new LoginCredentialDto());
        return "login";
    }

    @PostMapping("/processLogin")
    public String validateUserCredentials(@ModelAttribute("loginCredentials") LoginCredentialDto loginCredentialDto, RedirectAttributes redirectAttributes) {
        List<LoginCredentialDto> loginCredentialDtoList = loginService.readLoginCredentials();
        String formValidations;
        boolean flag = false;
        for (LoginCredentialDto loginDetails : loginCredentialDtoList) {
            if (loginDetails.getUserName().equals(loginCredentialDto.getUserName()) &&
                    loginDetails.getPassword().equals(loginCredentialDto.getPassword())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return "redirect:/employee/showDashboard";
        }
        else {
            formValidations = "Wrong user credentials";
            redirectAttributes.addFlashAttribute("message", formValidations);
            return "redirect:/";
        }

    }
}
