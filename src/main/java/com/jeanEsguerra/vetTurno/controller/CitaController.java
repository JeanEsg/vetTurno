package com.jeanEsguerra.vetTurno.controller;

import com.jeanEsguerra.vetTurno.dto.CitaDTO;
import com.jeanEsguerra.vetTurno.dto.CitaRequest;
import com.jeanEsguerra.vetTurno.model.Cita;
import com.jeanEsguerra.vetTurno.model.Mascota;
import com.jeanEsguerra.vetTurno.model.Veterinario;
import com.jeanEsguerra.vetTurno.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<CitaDTO> obtenerCitas() {
        return citaService.listarCitas().stream().map(CitaDTO::new).toList();
    }

    @GetMapping("/veterinario/{id}")
    public List<CitaDTO> obtenerPorVeterinario(@PathVariable Long id) {
        return citaService.listarPorVeterinario(id).stream().map(CitaDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<CitaDTO> agendarCita(@Valid @RequestBody CitaRequest req) {
        Cita c = new Cita();
        c.setMotivo(req.getMotivo());
        c.setFechaHora(req.getFechaHora());
        Mascota m = new Mascota(); m.setId(req.getMascotaId()); c.setMascota(m);
        Veterinario v = new Veterinario(); v.setId(req.getVeterinarioId()); c.setVeterinario(v);
        Cita guardada = citaService.agregarCita(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CitaDTO(guardada));
    }
}
