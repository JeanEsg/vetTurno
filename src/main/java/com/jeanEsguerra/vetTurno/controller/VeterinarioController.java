package com.jeanEsguerra.vetTurno.controller;


import com.jeanEsguerra.vetTurno.dto.VeterinarioDTO;
import com.jeanEsguerra.vetTurno.dto.VeterinarioRequest;
import com.jeanEsguerra.vetTurno.model.Veterinario;
import com.jeanEsguerra.vetTurno.service.VeterinarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public List<VeterinarioDTO> obtenerVeterinarios() {
        return veterinarioService.listarVeterinarios().stream().map(VeterinarioDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<VeterinarioDTO> crearVeterinario(@Valid @RequestBody VeterinarioRequest req) {
        Veterinario v = new Veterinario();
        v.setNombre(req.getNombre());
        v.setEspecialidad(req.getEspecialidad());
        Veterinario guardado = veterinarioService.agregarVeterinario(v);
        return ResponseEntity.status(HttpStatus.CREATED).body(new VeterinarioDTO(guardado));
    }
}
