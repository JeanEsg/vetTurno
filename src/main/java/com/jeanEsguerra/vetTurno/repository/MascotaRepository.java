package com.jeanEsguerra.vetTurno.repository;

import com.jeanEsguerra.vetTurno.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository
        extends JpaRepository<Mascota, Long> {

    List<Mascota> findByPropietarioId(Long propietarioId);
}
