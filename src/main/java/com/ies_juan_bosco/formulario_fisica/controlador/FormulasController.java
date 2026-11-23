package com.ies_juan_bosco.formulario_fisica.controlador;

import com.ies_juan_bosco.formulario_fisica.modelo.Formulas;
import com.ies_juan_bosco.formulario_fisica.servicios.FormulasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulass")
public class FormulasController {
    private final FormulasService service;

    public FormulasController(FormulasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Formulas> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formulas> findById(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Formulas> create(@RequestBody Formulas entidad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formulas> update(@PathVariable Integer id,
                                               @RequestBody Formulas entidad) {
        return service.update(id, entidad).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
