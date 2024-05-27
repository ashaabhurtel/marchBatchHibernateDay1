package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void registerEmp(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        employeeDao.save(employeeEntity);
    }

    @Override
    public EmployeeDTO authenticate(String emailId, String password) {
        Optional<EmployeeEntity> optional = employeeDao.findByEmailIdAndPassword(emailId, password);
        EmployeeDTO employeeDTO = null;

        if (optional.isPresent()) {
            EmployeeEntity employeeEntity = optional.get();
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeDao.findAll();
        List<EmployeeDTO> employeeDtoList = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntityList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
            employeeDtoList.add(employeeDTO);
        }

        return employeeDtoList;
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesSortedById() {
        List<EmployeeEntity> employeeEntityList = employeeDao.findAll(); // Assuming findAll() gives sorted by ID
        List<EmployeeDTO> employeeDtoList = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntityList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
            employeeDtoList.add(employeeDTO);
        }

        return employeeDtoList;
    }

    @Override
    public EmployeeDTO findEmployeeById(int employeeId) {
        Optional<EmployeeEntity> optional = employeeDao.findById(employeeId);
        EmployeeDTO employeeDTO = null;

        if (optional.isPresent()) {
            EmployeeEntity employeeEntity = optional.get();
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }

        return employeeDTO;
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        employeeDao.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        employeeDao.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesSortedByName() {
        List<EmployeeEntity> employeeEntityList = employeeDao.findAllByOrderByEmployeeNameAsc();
        List<EmployeeDTO> employeeDtoList = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntityList) {
        	
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
            
            employeeDtoList.add(employeeDTO);
        }

        return employeeDtoList;
    }
}
