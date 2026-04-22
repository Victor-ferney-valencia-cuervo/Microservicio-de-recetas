package com.recetas.controller;

import com.recetas.model.Receta;
import com.recetas.service.RecetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recetas")
@CrossOrigin("*")
@Tag(name = "Recetas", description = "Operaciones para consultar recetas colombianas")
public class RecetaController {

    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @Operation(summary = "Obtener todas las recetas", description = "Devuelve la lista completa de recetas disponibles")
    @ApiResponse(responseCode = "200", description = "Lista de recetas obtenida exitosamente")
    @GetMapping
    public List<Receta> obtenerTodas() {
        return recetaService.obtenerTodas();
    }

    @Operation(summary = "Obtener receta por ID", description = "Devuelve una receta específica según su identificador")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Receta encontrada"),
        @ApiResponse(responseCode = "404", description = "Receta no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Receta> obtenerPorId(
            @Parameter(description = "ID de la receta (1-10)", example = "1")
            @PathVariable int id) {
        return recetaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Filtrar recetas por categoría",
               description = "Devuelve todas las recetas que pertenecen a la categoría indicada. " +
                             "Categorías disponibles: Plato Fuerte, Sopa, Desayuno, Postre, Bebida")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Recetas encontradas para la categoría"),
        @ApiResponse(responseCode = "404", description = "No se encontraron recetas para esa categoría")
    })
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Receta>> obtenerPorCategoria(
            @Parameter(description = "Nombre de la categoría", example = "Sopa")
            @PathVariable String categoria) {
        List<Receta> resultado = recetaService.obtenerPorCategoria(categoria);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }
}
