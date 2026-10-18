package com.jeanEsguerra.vetTurno.service;

import com.jeanEsguerra.vetTurno.model.Propietario;
import com.jeanEsguerra.vetTurno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public List<Propietario> listarPropietarios() {
        return propietarioRepository.findAll();
    }

    public Propietario agregarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }
}
