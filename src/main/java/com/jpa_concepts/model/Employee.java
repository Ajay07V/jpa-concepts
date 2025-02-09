package com.jpa_concepts.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Embedded
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "EMPLOYEE_ADDRESS", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    private List<Address> addresses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    private Employee(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.addresses = builder.addresses;
        this.department = builder.department;
    }

    public static class Builder {
        private Integer id;
        private String firstName;
        private String lastName;
        private List<Address> addresses = new ArrayList<>();
        private Department department;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder addresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}