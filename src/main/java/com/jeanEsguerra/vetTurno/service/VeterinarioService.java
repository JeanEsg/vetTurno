package com.jeanEsguerra.vetTurno.service;

import com.jeanEsguerra.vetTurno.model.Veterinario;
import com.jeanEsguerra.vetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<Veterinario> listarVeterinarios() {
        return veterinarioRepository.findAll();
    }

    public Veterinario agregarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }
}
