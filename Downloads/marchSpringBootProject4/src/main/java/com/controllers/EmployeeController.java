package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping({ "/login", "/" })
    public String callLoginPage() {
        return "login";
    }

    // Registration operation

    @GetMapping("/register")
    public String callRegistrationPage() {
        return "employeeRegistration";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
        employeeService.registerEmp(employeeDTO);
        model.addAttribute("message", "Registration completed successfully");
        return "employeeRegistration";
    }

    @PostMapping("/loginValidate")
    public String authenticate(@RequestParam String emailId, @RequestParam String password, Model model) {
        EmployeeDTO employeeDTO = employeeService.authenticate(emailId, password);

        if (employeeDTO != null) {
            model.addAttribute("employeeDTO", employeeDTO);
            return "congratulation";
        } else {
            model.addAttribute("message", "Wrong credential!!! Re-Try");
            return "login";
        }
    }

    @GetMapping("/fetchAllRecords")
    public String showAllRecords(@RequestParam(required = false, defaultValue = "id") String sortBy, Model model) {
        List<EmployeeDTO> employeeDtoList;

        if ("name".equals(sortBy)) {
            employeeDtoList = employeeService.findAllEmployeesSortedByName();
        } else {
            employeeDtoList = employeeService.findAllEmployeesSortedById();
        }

        model.addAttribute("employeeDtoList", employeeDtoList);
        return "showAll";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam int employeeId, Model model) {
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employeeDTO", employeeDTO);
        return "edit";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
        employeeService.updateEmployee(employeeDTO);
        model.addAttribute("message", "Employee updated successfully");
        return "update";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int employeeId, Model model) {
        employeeService.deleteEmployeeById(employeeId);
        model.addAttribute("message", "Employee deleted successfully");
        return "update";
    }
}
