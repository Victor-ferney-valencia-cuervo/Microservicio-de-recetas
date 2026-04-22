package com.recetas.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa una receta de cocina")
public class Receta {

    @Schema(description = "Identificador único de la receta", example = "1")
    private int id;

    @Schema(description = "Nombre de la receta", example = "Bandeja Paisa")
    private String nombre;

    @Schema(description = "Categoría a la que pertenece la receta", example = "Plato Fuerte")
    private String categoria;

    public Receta() {}

    public Receta(int id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Receta{id=" + id + ", nombre='" + nombre + "', categoria='" + categoria + "'}";
    }
}
