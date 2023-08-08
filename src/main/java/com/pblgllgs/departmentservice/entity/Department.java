package com.pblgllgs.departmentservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Department")
@Table(
        name = "departments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "department_code_UK",
                        columnNames = "department_code"
                )
        }
)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name", nullable = false)
    private String departmentName;
    @Column(name = "department_description", nullable = false)
    private String departmentDescription;
    @Column(name = "department_code", nullable = false)
    private String departmentCode;
}
