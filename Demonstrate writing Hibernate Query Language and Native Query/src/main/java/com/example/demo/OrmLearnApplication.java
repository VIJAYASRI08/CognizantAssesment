package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAllEmployeesNative();
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        employees.forEach(e -> LOGGER.debug("Employee: {} Skills: {}", e, e.getSkillList()));
        LOGGER.info("End testGetAllPermanentEmployees");
    }

    private static void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary");
        double avg = employeeService.getAverageSalary(2);
        LOGGER.debug("Average Salary for Dept 2: {}", avg);
        LOGGER.info("End testGetAverageSalary");
    }

    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(e -> LOGGER.debug("Employee: {}", e));
        LOGGER.info("End testGetAllEmployeesNative");
    }
}
