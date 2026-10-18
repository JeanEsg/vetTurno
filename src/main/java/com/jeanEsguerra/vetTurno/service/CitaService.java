package com.jeanEsguerra.vetTurno.service;

import com.jeanEsguerra.vetTurno.model.Cita;
import com.jeanEsguerra.vetTurno.model.Mascota;
import com.jeanEsguerra.vetTurno.model.Veterinario;
import com.jeanEsguerra.vetTurno.repository.CitaRepository;
import com.jeanEsguerra.vetTurno.repository.MascotaRepository;
import com.jeanEsguerra.vetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaService(CitaRepository citaRepository, MascotaRepository mascotaRepository, VeterinarioRepository veterinarioRepository) {
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public List<Cita> listarPorVeterinario(Long veterinarioId) {
        return citaRepository.findByVeterinarioId(veterinarioId);
    }

    public Cita agregarCita(Cita cita) {
        resolverMascota(cita);
        resolverVeterinario(cita);

        if (!cita.getFechaHora().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "La fecha de la cita debe ser futura"
            );
        }

        if (citaRepository.existsByVeterinarioIdAndFechaHora(
                cita.getVeterinario().getId(),
                cita.getFechaHora())) {
            throw new IllegalArgumentException(
                    "El veterinario ya tiene una cita en ese horario"
            );
        }

        return citaRepository.save(cita);
    }

    private void resolverMascota(Cita cita) {
        if (cita.getMascota() != null
                && cita.getMascota().getId() != null) {
            Mascota mascota = mascotaRepository
                    .findById(cita.getMascota().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada con ID: " + cita.getMascota().getId()));
            cita.setMascota(mascota);
        }
    }

    private void resolverVeterinario(Cita cita) {
        if (cita.getVeterinario() != null
                && cita.getVeterinario().getId() != null) {
            Veterinario veterinario = veterinarioRepository
                    .findById(cita.getVeterinario().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Veterinario no encontardo con ID: " + cita.getVeterinario().getId()));
            cita.setVeterinario(veterinario);
        }
    }
}
