package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee extends ModelBase {
    private String firstName;
    private String lastName;
    private String address;
    private Long phone;
    private Long ci;
    private String gender;
    @Temporal(TemporalType.TIMESTAMP)
    @Column()
    private Date birthDate;
    private Byte[] image;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<AsignationProject> asignationProjectList = new HashSet<>();

    //para el relacionamiento de tabla
    @OneToMany(mappedBy = "employee", orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<ItemAsignation> itemAsignations = new HashSet<>();

    @OneToMany(mappedBy = "employee", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<MachineryAssignation> machineryAssignations = new HashSet<>();

    @OneToMany(mappedBy = "employee", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<AccidentRegistry> asignationAccidents = new HashSet<>();

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Contract> contracts = new HashSet<>();

    /*@ManyToMany
    Incident incident;*/

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }
    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCi() {
        return ci;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}