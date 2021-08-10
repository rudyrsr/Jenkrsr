package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Contract;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.model.ModelBase;
import com.dh.spring5webapp.model.Position;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeCommand extends ModelBase {

    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDate;
    private Long phone;
    private Long ci;
    private String name;
    private String image;
    private String jobPosition;
    private String jobCode;
    private Boolean featured;
    private String jobDescription;
    private PositionCommand position;

    public EmployeeCommand() {
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

    public PositionCommand getPosition() {
        return position;
    }

    public void setPosition(PositionCommand position) {
        this.position = position;
    }

    public EmployeeCommand(Employee employee) {
        setId(employee.getId());
        setFirstName(employee.getFirstName());
        setLastName(employee.getLastName());
        setVersion(employee.getVersion());
        setCreatedOn(employee.getCreatedOn());
        setUpdatedOn(employee.getUpdatedOn());
        setCi(employee.getCi());
        setAddress(employee.getAddress());
        setPhone(employee.getPhone());
        setGender(employee.getGender());
        setBirthDate(employee.getBirthDate());
        if(employee.getContracts().size() > 0) {
            Contract c = new ArrayList<>(employee.getContracts()).get(0);
            if(c.getPosition() != null) {
                PositionCommand position = new PositionCommand();
                position.setId(c.getPosition().getId());
                position.setPositionName(c.getPosition().getName());
                position.setPositionDescription(c.getPosition().getPositionDescription());
                setPosition(position);
            }
        }
    }

    private void setImageBase64(Employee employee) {
        if (employee.getImage() != null) {
            byte[] bytes = new byte[employee.getImage().length];
            for (int i = 0; i < employee.getImage().length; i++) {
                bytes[i] = employee.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            this.setImage(imageStr);

        }
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getCi() {
        return ci;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setFirstName(getFirstName());
        employee.setLastName(getLastName());
        employee.setId(getId());
        employee.setVersion(getVersion());
        employee.setCreatedOn(getCreatedOn());
        employee.setUpdatedOn(getUpdatedOn());
        employee.setBirthDate(getBirthDate());
        employee.setAddress(getAddress());
        employee.setCi(getCi());
        employee.setPhone(getPhone());
        employee.setGender(getGender());
        return employee;
    }
}