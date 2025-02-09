package com.jpa_concepts;

import com.jpa_concepts.model.Address;
import com.jpa_concepts.model.Department;
import com.jpa_concepts.model.Employee;
import com.jpa_concepts.repository.DepartmentRepository;
import com.jpa_concepts.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaConceptsApplication implements CommandLineRunner {

    private final EmployeeRepository employeeRepository ;

    private final DepartmentRepository departmentRepository;

    JpaConceptsApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaConceptsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Department engineering = new Department.Builder()
                .departmentName("Engineering")
                .build();
        departmentRepository.save(engineering);

        Address address1 = new Address.Builder()
                .addressLine1("123 Main St")
                .city("Springfield")
                .state("IL")
                .country("USA")
                .zipCode("62704")
                .build();

        Address address2 = new Address.Builder()
                .addressLine1("456 Elm St")
                .city("Springfield")
                .state("IL")
                .country("USA")
                .zipCode("62705")
                .build();

        Employee john = new Employee.Builder()
                .firstName("John")
                .lastName("Doe")
                .addresses(List.of(address1))
                .department(engineering)
                .build();

        Employee jane = new Employee.Builder()
                .firstName("Jane")
                .lastName("Smith")
                .addresses(List.of(address2))
                .department(engineering)
                .build();
        employeeRepository.save(john);
        employeeRepository.save(jane);

    }
}