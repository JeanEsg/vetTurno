package com.jeanEsguerra.vetTurno.controller;

import com.jeanEsguerra.vetTurno.dto.MascotaDTO;
import com.jeanEsguerra.vetTurno.dto.MascotaRequest;
import com.jeanEsguerra.vetTurno.model.Mascota;
import com.jeanEsguerra.vetTurno.model.Propietario;
import com.jeanEsguerra.vetTurno.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<MascotaDTO> obtenerMascotas() {
        return mascotaService.listarMascotas().stream().map(MascotaDTO::new).toList();
    }

    @GetMapping("/propietario/{propietarioId}")
    public List<MascotaDTO> obtenerPorPropietario(@PathVariable Long propietarioId) {
        return mascotaService.listarPorPropietario(propietarioId).stream().map(MascotaDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> crearMascota(@Valid @RequestBody MascotaRequest req) {
        Mascota m = new Mascota();
        m.setNombre(req.getNombre());
        m.setEspecie(req.getEspecie());
        m.setRaza(req.getRaza());
        Propietario p = new Propietario(); p.setId(req.getPropietarioId()); m.setPropietario(p);
        Mascota guardado = mascotaService.agregarMascotas(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MascotaDTO(guardado));
    }
}
