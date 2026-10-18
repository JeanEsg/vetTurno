package com.jeanEsguerra.vetTurno.dto;

import com.jeanEsguerra.vetTurno.model.Mascota;

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Long propietarioId;
    private String propietarioNombre;

        public MascotaDTO(Mascota mascota) {
            this.id = mascota.getId();
            this.nombre = mascota.getNombre();
            this.especie = mascota.getEspecie();
            this.raza = mascota.getRaza();
            this.propietarioId = mascota.getPropietario() != null
                    ? mascota.getPropietario().getId() : null;

            this.propietarioNombre = mascota.getPropietario() != null
                    ? mascota.getPropietario().getNombre() : null;
        }

    // gets y sets
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Long getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(Long propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getPropietarioNombre() {
        return propietarioNombre;
    }

    public void setPropietarioNombre(String propietarioNombre) {
        this.propietarioNombre = propietarioNombre;
    }
}
