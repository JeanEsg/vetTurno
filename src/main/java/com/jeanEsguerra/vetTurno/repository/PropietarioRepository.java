package com.jeanEsguerra.vetTurno.repository;

import com.jeanEsguerra.vetTurno.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropietarioRepository
        extends JpaRepository<Propietario, Long> {
}
