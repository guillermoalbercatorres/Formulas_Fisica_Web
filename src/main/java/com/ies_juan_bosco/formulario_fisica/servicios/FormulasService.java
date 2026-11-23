package com.ies_juan_bosco.formulario_fisica.servicios;

import com.ies_juan_bosco.formulario_fisica.modelo.Formulas;
import com.ies_juan_bosco.formulario_fisica.repositorio.FormulasRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormulasService {
    private final FormulasRepositorio repositorio;

    public FormulasService(FormulasRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Formulas> findAll() {
        return repositorio.findAll();
    }

    public Optional<Formulas> findById(Integer id) {
        return repositorio.findById(id);
    }

    public Formulas create(Formulas entidad) {
        return repositorio.save(entidad);
    }

    public Optional<Formulas> update(Integer id, Formulas entidad) {
        return repositorio.findById(id).map(actual -> {
            entidad.setId(actual.getId());
            return repositorio.save(entidad);
        });
    }

    public boolean delete(Integer id) {
        if (!repositorio.existsById(id)) return false;
        repositorio.deleteById(id);
        return true;
    }
}
