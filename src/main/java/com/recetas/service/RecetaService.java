package com.recetas.service;

import com.recetas.model.Receta;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecetaService {

    private final List<Receta> recetas = Arrays.asList(
        new Receta(1,  "Bandeja Paisa",          "Plato Fuerte"),
        new Receta(2,  "Ajiaco Bogotano",         "Sopa"),
        new Receta(3,  "Sancocho de Gallina",     "Sopa"),
        new Receta(4,  "Arepa de Chócolo",        "Desayuno"),
        new Receta(5,  "Changua con Huevo",       "Desayuno"),
        new Receta(6,  "Lechona Tolimense",       "Plato Fuerte"),
        new Receta(7,  "Fritanga Colombiana",     "Plato Fuerte"),
        new Receta(8,  "Torta de Tres Leches",    "Postre"),
        new Receta(9,  "Natilla Colombiana",      "Postre"),
        new Receta(10, "Limonada de Coco",        "Bebida")
    );

    public List<Receta> obtenerTodas() {
        return recetas;
    }

    public Optional<Receta> obtenerPorId(int id) {
        return recetas.stream()
                .filter(r -> r.getId() == id)
                .findFirst();
    }

    public List<Receta> obtenerPorCategoria(String categoria) {
        return recetas.stream()
                .filter(r -> r.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
}
