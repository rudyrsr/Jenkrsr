package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "accident")
public class Accident extends ModelBase {
    @Column(name = "accidentCode")
    private String accidentCode;
    @Column(name = "accidentDescription")
    private String accidentDescription;
    @Column(name = "accidentSupervisor")
    private String accidentSupervisor;
    @Column(name = "accidentMedicalCenter")
    private String accidentMedicalCenter;
    @Column(name = "accidentPlace")
    private String accidentPlace;
    @Column(name = "accidentWitness")
    private String accidentWitness;
    @Column(name = "accidentRegistrationCode")
    private String accidentRegistrationCode;
    @Column(name = "accidentDisabilityDay")
    private Long accidentDisabilityDay;
    @Column(name = "deleted")
    private boolean deleted=false;

    @Transient
    private Long catalogFI_id;
    @Transient
    private Long catalogNI_id;
    @Transient
    private Long catalogTD_id;
    @Transient
    private Long catalogUA_id;
    @Transient
    private Long catalogUC_id;

    @OneToOne(targetEntity = CatalogFI.class)
    private CatalogFI catalogFI;


    @OneToOne(targetEntity = CatalogNI.class)
    private CatalogNI catalogNI;
    @OneToOne(targetEntity = CatalogTD.class)
    private CatalogTD catalogTD;
    @OneToOne(targetEntity = CatalogUA.class)
    private CatalogUA catalogUA;
    @OneToOne(targetEntity = CatalogUC.class)
    private CatalogUC catalogUC;
    @OneToMany(mappedBy = "accident", orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})

    private Set<AccidentRegistry> asignationAccidentList = new HashSet<>();


    public Accident() {
    }

    public Accident(String accidentCode, String accidentDescription, String accidentSupervisor, String accidentMedicalCenter, String accidentPlace, String accidentWitness, String accidentRegistrationCode, Long accidentDisabilityDay, Long catalogFI_id, Long catalogNI_id, Long catalogTD_id, Long catalogUA_id, Long catalogUC_id, CatalogFI catalogFI, CatalogNI catalogNI, CatalogTD catalogTD, CatalogUA catalogUA, CatalogUC catalogUC, Set<AccidentRegistry> asignationAccidentList, Long asignationAccidentId,boolean deleted) {
        this.accidentCode = accidentCode;
        this.accidentDescription = accidentDescription;
        this.accidentSupervisor = accidentSupervisor;
        this.accidentMedicalCenter = accidentMedicalCenter;
        this.accidentPlace = accidentPlace;
        this.accidentWitness = accidentWitness;
        this.accidentRegistrationCode = accidentRegistrationCode;
        this.accidentDisabilityDay = accidentDisabilityDay;
        this.catalogFI_id = catalogFI_id;
        this.catalogNI_id = catalogNI_id;
        this.catalogTD_id = catalogTD_id;
        this.catalogUA_id = catalogUA_id;
        this.catalogUC_id = catalogUC_id;
        this.catalogFI = catalogFI;
        this.catalogNI = catalogNI;
        this.catalogTD = catalogTD;
        this.catalogUA = catalogUA;
        this.catalogUC = catalogUC;
        this.deleted=deleted;
        this.asignationAccidentList = asignationAccidentList;




    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public CatalogFI getCatalogFI() {
        return catalogFI;
    }

    public void setCatalogFI(CatalogFI catalogFI) {
        this.catalogFI = catalogFI;
    }

    public CatalogNI getCatalogNI() {
        return catalogNI;
    }

    public void setCatalogNI(CatalogNI catalogNI) {
        this.catalogNI = catalogNI;
    }

    public CatalogTD getCatalogTD() {
        return catalogTD;
    }

    public void setCatalogTD(CatalogTD catalogTD) {
        this.catalogTD = catalogTD;
    }

    public CatalogUA getCatalogUA() {
        return catalogUA;
    }

    public void setCatalogUA(CatalogUA catalogUA) {
        this.catalogUA = catalogUA;
    }

    public CatalogUC getCatalogUC() {
        return catalogUC;
    }

    public void setCatalogUC(CatalogUC catalogUC) {
        this.catalogUC = catalogUC;
    }

    public Set<AccidentRegistry> getAsignationAccidentList() {
        return asignationAccidentList;
    }

    public void setAsignationAccidentList(Set<AccidentRegistry> asignationAccidentList) {
        this.asignationAccidentList = asignationAccidentList;





    }
}
