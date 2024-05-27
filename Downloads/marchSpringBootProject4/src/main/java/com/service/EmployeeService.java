package com.service;

import java.util.List;
import com.dto.EmployeeDTO;

public interface EmployeeService {

    void registerEmp(EmployeeDTO employeeDTO);

    EmployeeDTO authenticate(String emailId, String password);

    List<EmployeeDTO> findAllEmployees();

    List<EmployeeDTO> findAllEmployeesSortedByName();

    List<EmployeeDTO> findAllEmployeesSortedById();  // Add this method

    EmployeeDTO findEmployeeById(int employeeId);

    void updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployeeById(int employeeId);
}
