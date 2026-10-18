package com.jeanEsguerra.vetTurno.service;

import com.jeanEsguerra.vetTurno.model.Mascota;
import com.jeanEsguerra.vetTurno.model.Propietario;
import com.jeanEsguerra.vetTurno.repository.MascotaRepository;
import com.jeanEsguerra.vetTurno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    public MascotaService(MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
    }

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    public List<Mascota> listarPorPropietario(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    public Mascota agregarMascotas(Mascota mascota) {
        resolverPropietario(mascota);
        return mascotaRepository.save(mascota);
    }

    private void resolverPropietario(Mascota mascota) {
        if (mascota.getPropietario() != null
                && mascota.getPropietario().getId() != null) {
            Propietario propietario = propietarioRepository
                    .findById(mascota.getPropietario().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado con ID: " + mascota.getPropietario().getId()));
            mascota.setPropietario(propietario);
        }
    }
}
