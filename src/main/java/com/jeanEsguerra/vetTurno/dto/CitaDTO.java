package com.jeanEsguerra.vetTurno.dto;

import com.jeanEsguerra.vetTurno.model.Cita;

import java.time.LocalDateTime;

public class CitaDTO {

    private Long id;
    private String motivo;
    private String mascota;
    private String propietario;
    private String veterinario;
    private LocalDateTime fechaHora;

    public CitaDTO(Cita cita) {
        this.id = cita.getId();
        this.motivo = cita.getMotivo();
        this.mascota = cita.getMascota() != null
                ? cita.getMascota().getNombre() : null;
        this.propietario = cita.getMascota() != null
                && cita.getMascota().getPropietario() != null
                ? cita.getMascota().getPropietario().getNombre()
                : null;
        this.veterinario = cita.getVeterinario() != null
                ? cita.getVeterinario().getNombre() : null;
        this.fechaHora = cita.getFechaHora();
    }

    // gets y sets
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
