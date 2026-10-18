package com.jeanEsguerra.vetTurno.repository;

import com.jeanEsguerra.vetTurno.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository
        extends JpaRepository<Veterinario, Long>{
}
