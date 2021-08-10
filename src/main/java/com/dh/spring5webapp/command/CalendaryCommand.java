package com.dh.spring5webapp.command;

public class CalendaryCommand {
    private Long id;
    private String nombreMes;

    public CalendaryCommand() {

    }

    public CalendaryCommand(Long id,String nombreMes) {
        this.id=id;
        this.nombreMes = nombreMes;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }
}
