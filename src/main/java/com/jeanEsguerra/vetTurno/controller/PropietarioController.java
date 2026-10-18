package com.jeanEsguerra.vetTurno.controller;

import com.jeanEsguerra.vetTurno.dto.PropietarioDTO;
import com.jeanEsguerra.vetTurno.dto.PropietarioRequest;
import com.jeanEsguerra.vetTurno.model.Propietario;
import com.jeanEsguerra.vetTurno.service.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @GetMapping
    public List<PropietarioDTO> obtenerPropietarios() {
        return propietarioService.listarPropietarios().stream().map(PropietarioDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<PropietarioDTO> crearPropietario(@Valid @RequestBody PropietarioRequest req) {
        Propietario p = new Propietario();
        p.setNombre(req.getNombre());
        p.setTelefono(req.getTelefono());
        p.setEmail(req.getEmail());
        Propietario guardado = propietarioService.agregarPropietario(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PropietarioDTO(guardado));
    }
}

