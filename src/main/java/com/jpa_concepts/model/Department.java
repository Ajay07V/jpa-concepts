package com.jpa_concepts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private Integer id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    private Department(Builder builder) {
        this.id = builder.id;
        this.departmentName = builder.departmentName;
        this.employees = builder.employees;
    }

    public static class Builder {
        private Integer id;
        private String departmentName;
        private List<Employee> employees = new ArrayList<>();

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder employees(List<Employee> employees) {
            this.employees = employees;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}