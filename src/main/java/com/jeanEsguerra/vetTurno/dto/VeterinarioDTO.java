package com.jeanEsguerra.vetTurno.dto;

import com.jeanEsguerra.vetTurno.model.Veterinario;

public class VeterinarioDTO {

    private Long id;
    private String nombre;
    private String especialidad;

    public VeterinarioDTO(Veterinario veterinario){
        this.id = veterinario.getId();
        this.nombre = veterinario.getNombre();
        this.especialidad = veterinario.getEspecialidad();
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
