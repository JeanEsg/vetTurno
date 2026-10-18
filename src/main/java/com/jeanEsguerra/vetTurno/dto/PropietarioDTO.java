package com.jeanEsguerra.vetTurno.dto;

import com.jeanEsguerra.vetTurno.model.Propietario;

public class PropietarioDTO {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;

    public PropietarioDTO(Propietario propietario) {
        this.id = propietario.getId();
        this.nombre = propietario.getNombre();
        this.telefono = propietario.getTelefono();
        this.email = propietario.getEmail();
    }

    //gets y sets
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
