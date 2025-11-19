package com.company.opexhub.entity;

import javax.persistence.*;

/**
 * Entity class representing a Discipline in the OpEx Hub system.
 * Disciplines represent different operational areas like Operation, Engineering, Environment, etc.
 * 
 * @author OpEx Development Team
 */
@Entity
@Table(name = "OPEX_Discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 100)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "details", length = 500)
    private String details;

    @Column(name = "is_active")
    private Boolean isActive = true;

    // Constructors
    public Discipline() {
    }

    public Discipline(String code, String name, String details) {
        this.code = code;
        this.name = name;
        this.details = details;
        this.isActive = true;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}