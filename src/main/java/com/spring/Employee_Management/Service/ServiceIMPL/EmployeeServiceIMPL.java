package com.spring.Employee_Management.Service.ServiceIMPL;

import com.spring.Employee_Management.Entity.EmployeeEntity;
import com.spring.Employee_Management.Repository.EmployeeRepository;
import com.spring.Employee_Management.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

//    @Override
//    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
//        return employeeRepository.findById(id).map(employee -> {
//            employee.setFirstName(employeeDetails.getFirstName());
//            employee.setLastName(employeeDetails.getLastName());
//            employee.setEmail(employeeDetails.getEmail());
////            employee.setDepartment(employeeDetails.getDepartment());
//            return employeeRepository.save(employee);
//        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
//    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}