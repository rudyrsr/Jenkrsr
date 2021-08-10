package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;


import com.dh.spring5webapp.model.Accident;
import com.dh.spring5webapp.model.CatalogFI;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;




public class AccidentComand {
    private Long id;
    private String accidentCode;
    private String accidentDescription;
    private String accidentSupervisor;
    private String accidentMedicalCenter;
    private String accidentPlace;
    private String accidentWitness;
    private String accidentRegistrationCode;
    private Long accidentDisabilityDay;
    private Long catalogFI_id;
    private Long catalogNI_id;
    private Long catalogTD_id;
    private Long catalogUA_id;
    private Long catalogUC_id;
    private boolean deleted;
    @Autowired
    private CatalogFICommand catalogFI;
    @Autowired
    private CatalogUCCommand catalogUC;
    @Autowired
    private CatalogNICommand catalogNI;
    @Autowired
    private CatalogUACommand catalogUA;
    @Autowired
    private CatalogTDCommand catalogTD;

    private Set<EmployeeCommand> employees = new HashSet<>();

    public AccidentComand() {
    }

    public AccidentComand(Accident accident) {
       this.setId(accident.getId());
       this.setAccidentCode(accident.getAccidentCode());
       this.setAccidentDescription(accident.getAccidentDescription());
       this.setAccidentSupervisor(accident.getAccidentSupervisor());
       this.setAccidentMedicalCenter(accident.getAccidentMedicalCenter());
       this.setAccidentPlace(accident.getAccidentPlace());
       this.setAccidentWitness(accident.getAccidentWitness());
       this.setAccidentRegistrationCode(accident.getAccidentRegistrationCode());
       this.setAccidentDisabilityDay(accident.getAccidentDisabilityDay());
       this.setCatalogFI_id(accident.getCatalogFI().getId());
       this.setCatalogNI_id(accident.getCatalogNI().getId());
       this.setCatalogTD_id(accident.getCatalogTD().getId());
       this.setCatalogUA_id(accident.getCatalogUA().getId());
       this.setCatalogUC_id(accident.getCatalogUC().getId());
       this.setCatalogFI(new CatalogFICommand(accident.getCatalogFI()));
       this.setCatalogUC(new CatalogUCCommand(accident.getCatalogUC()));
       this.setCatalogUA(new CatalogUACommand(accident.getCatalogUA()));
       this.setCatalogNI(new CatalogNICommand(accident.getCatalogNI()));
       this.setCatalogTD(new CatalogTDCommand(accident.getCatalogTD()));
       this.setDeleted(accident.isDeleted());
       accident.getAsignationAccidentList().forEach(
                asignationAccident -> this.employees.add(new EmployeeCommand(asignationAccident.getEmployee())));

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
     }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<EmployeeCommand> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeCommand> employees) {
        this.employees = employees;
    }

    public String getAccidentCode() {
        return accidentCode;
    }

    public void setAccidentCode(String accidentCode) {
        this.accidentCode = accidentCode;
    }

    public String getAccidentDescription() {
        return accidentDescription;
    }

    public void setAccidentDescription(String accidentDescription) {
        this.accidentDescription = accidentDescription;
    }

    public String getAccidentSupervisor() {
        return accidentSupervisor;
    }

    public void setAccidentSupervisor(String accidentSupervisor) {
        this.accidentSupervisor = accidentSupervisor;
    }

    public String getAccidentMedicalCenter() {
        return accidentMedicalCenter;
    }

    public void setAccidentMedicalCenter(String accidentMedicalCenter) {
        this.accidentMedicalCenter = accidentMedicalCenter;
    }




    public String getAccidentPlace() {
        return accidentPlace;
    }

    public void setAccidentPlace(String accidentPlace) {
        this.accidentPlace = accidentPlace;
    }

    public String getAccidentWitness() {
        return accidentWitness;
    }

    public void setAccidentWitness(String accidentWitness) {
        this.accidentWitness = accidentWitness;
    }

    public String getAccidentRegistrationCode() {
        return accidentRegistrationCode;
    }

    public void setAccidentRegistrationCode(String accidentRegistrationCode) {
        this.accidentRegistrationCode = accidentRegistrationCode;
    }




    public Long getAccidentDisabilityDay() {
        return accidentDisabilityDay;
    }

    public void setAccidentDisabilityDay(Long accidentDisabilityDay) {
        this.accidentDisabilityDay = accidentDisabilityDay;
    }

    public Long getCatalogFI_id() {
        return catalogFI_id;
    }

    public void setCatalogFI_id(Long catalogFI_id) {
        this.catalogFI_id = catalogFI_id;
    }

    public Long getCatalogNI_id() {
        return catalogNI_id;
    }

    public void setCatalogNI_id(Long catalogNI_id) {
        this.catalogNI_id = catalogNI_id;
    }

    public Long getCatalogTD_id() {
        return catalogTD_id;
    }

    public void setCatalogTD_id(Long catalogTD_id) {
        this.catalogTD_id = catalogTD_id;
    }

    public Long getCatalogUA_id() {
        return catalogUA_id;
    }

    public void setCatalogUA_id(Long catalogUA_id) {
        this.catalogUA_id = catalogUA_id;
    }

    public Long getCatalogUC_id() {
        return catalogUC_id;
    }

    public void setCatalogUC_id(Long catalogUC_id) {
        this.catalogUC_id = catalogUC_id;
    }

    public CatalogFICommand getCatalogFI() {
        return catalogFI;
    }

    public void setCatalogFI(CatalogFICommand catalogFI) {
        this.catalogFI = catalogFI;
    }

    public CatalogUCCommand getCatalogUC() {
        return catalogUC;
    }

    public void setCatalogUC(CatalogUCCommand catalogUC) {
        this.catalogUC = catalogUC;
    }

    public CatalogNICommand getCatalogNI() {
        return catalogNI;
    }

    public void setCatalogNI(CatalogNICommand catalogNI) {
        this.catalogNI = catalogNI;
    }

    public CatalogUACommand getCatalogUA() {
        return catalogUA;
    }

    public void setCatalogUA(CatalogUACommand catalogUA) {
        this.catalogUA = catalogUA;
    }

    public CatalogTDCommand getCatalogTD() {
        return catalogTD;
    }



    public void setCatalogTD(CatalogTDCommand catalogTD) {


        this.catalogTD = catalogTD;
    }

    public Accident toDomain()
     {
         Accident accident=new Accident();
         accident.setId(getId());
         accident.setAccidentCode(getAccidentCode());
         accident.setAccidentDescription(getAccidentDescription());
         accident.setAccidentMedicalCenter(getAccidentMedicalCenter());
         accident.setAccidentRegistrationCode(getAccidentRegistrationCode());
         accident.setAccidentSupervisor(getAccidentSupervisor());
         accident.setAccidentPlace(getAccidentPlace());
         accident.setAccidentWitness(getAccidentWitness());
         accident.setAccidentDisabilityDay(getAccidentDisabilityDay());
         accident.setAccidentWitness(getAccidentWitness());
         accident.setAccidentWitness(getAccidentWitness());

         return accident;
     }
}
