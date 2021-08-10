
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.AuditHistory;

import java.util.Date;


public class AuditHistoryCommand {

    private long audithistoryid;
    private String tablename;
    private String columnname;
    private long id;
    private Date date;
    private String oldvalue;
    private String newvalue;
    private long modifiedby;


    public AuditHistoryCommand(AuditHistory audit) {

        this.setAudithistoryid(audit.getAudithistoryid());
        this.setTablename(audit.getTablename());
        this.setColumnname(audit.getColumnname());
        this.setId(audit.getId());
        this.setDate(audit.getDate());
        this.setOldvalue(audit.getOldvalue());
        this.setNewvalue(audit.getNewvalue());
        this.setModifiedby(audit.getModifiedby());
    }

    public AuditHistoryCommand() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public AuditHistory toDomain() {
        AuditHistory auditory = new AuditHistory();
        auditory.setAudithistoryid(getId());
        auditory.setTablename(getTablename());
        auditory.setColumnname(getColumnname());
        auditory.setId(getId());
        auditory.setDate(getDate());
        auditory.setOldvalue(getOldvalue());
        auditory.setNewvalue(getNewvalue());
        auditory.setModifiedby(getModifiedby());
        return auditory;
    }
}
