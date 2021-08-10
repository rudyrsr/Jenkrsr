package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_history")
public class AuditHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long audithistoryid;

    private String tablename;
    private String columnname;
    private long id;
    private Date date;
    private String oldvalue;
    private String newvalue;

    private long modifiedby;

    public AuditHistory() {
    }

    public long getAudithistoryid() {
        return audithistoryid;
    }

    public void setAudithistoryid(long audithistoryid) {
        this.audithistoryid = audithistoryid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
    }

    public long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(long modifiedby) {
        this.modifiedby = modifiedby;
    }
}
