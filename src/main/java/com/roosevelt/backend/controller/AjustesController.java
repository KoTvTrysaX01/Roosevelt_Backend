package com.roosevelt.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roosevelt.backend.model.Ajustes;
import com.roosevelt.backend.service.AjustesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "ajustes", description = "API para gestión de ajustes")
@RestController
@RequestMapping("/api/ajustes")
@CrossOrigin(origins = "/*")
public class AjustesController {

    @Autowired
    private AjustesService ajustesService;

    // ***************************************************************************
    // CONSULTAS
    // ***************************************************************************
    // http://localhost:8080/roosevelt/api/ajustes
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener todos los Ajustes", description = "Retorna una lista con todos los ajustess disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ajustes obtenidos con éxito")
    })
    // ***************************************************************************
    @GetMapping("")
    public ResponseEntity<List<Ajustes>> showajustess() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ajustesService.findAll());
    }

    // http://localhost:8080/roosevelt/api/ajustes/2
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener ajustes por ID", description = "Retorna un ajustes especifico basado en su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ajustes encontrado"),
            @ApiResponse(responseCode = "404", description = "ajustes no encontrado", content = @Content())
    })
    // ***************************************************************************
    @GetMapping("/{id}")
    public ResponseEntity<Ajustes> detailsajustes(@PathVariable int id) {
        Ajustes ajustes = ajustesService.findById(id);

        if (ajustes == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null); // 404 Not Found
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ajustes);
        }
    }

    // http://localhost:8080/roosevelt/api/ajustess/idioma/english
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener ajustes con idioma especifica", description = "Retorna una lista con todos los ajustess de una Ruta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ajustes obtenidos con éxito")
    })
    // ***************************************************************************
    @GetMapping("/idioma/{idioma}")
    public ResponseEntity<List<Ajustes>> showAjustesIdioma(@PathVariable String idioma) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ajustesService.findByIdioma(idioma));
    }

    // http://localhost:8080/roosevelt/api/ajustess/rec_noticias/true
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener ajustes donde rec_noticias es...", description = "Retorna una lista con todos los ajustess de una Ruta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ajustes obtenidos con éxito")
    })
    // ***************************************************************************
    @GetMapping("/noticias/{rec_noticias}")
    public ResponseEntity<List<Ajustes>> showAjustesRecNoticias(@PathVariable boolean rec_noticias) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ajustesService.findByRecNoticias(rec_noticias));
    }


    // http://localhost:8080/roosevelt/api/ajustess/rec_notificaciones/true
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener ajustes donde rec_notificaciones es...", description = "Retorna una lista con todos los ajustess de una Ruta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ajustes obtenidos con éxito")
    })
    // ***************************************************************************
    @GetMapping("/notificaciones/{rec_notificaciones}")
    public ResponseEntity<List<Ajustes>> showAjustesRecNotificaciones(@PathVariable boolean rec_notificaciones) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ajustesService.findByRecNotificaciones(rec_notificaciones));
    }

    // http://localhost:8080/roosevelt/api/ajustess/count
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener el número de ajustess existentes", description = "Retorna la cantidad de ajustess")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Número de ajustess obtenidos con éxito", content = @Content())
    })
    // ***************************************************************************
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> countajustess() {

        ResponseEntity<Map<String, Object>> response = null;

        Map<String, Object> map = new HashMap<>();
        map.put("ajustess", ajustesService.count());

        response = ResponseEntity
                .status(HttpStatus.OK)
                .body(map);

        return response;
    }

    // ***************************************************************************
    // ACTUALIZACIONES
    // ***************************************************************************
    // ****************************************************************************
    // INSERT (POST)
    // http://localhost:8080/roosevelt/api/ajustess
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Crear un nuev ajustes", description = "Registra un nuev ajustes en el sistema con los datos proporcionados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ajustes creado con éxito", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content())
    })
    // ***************************************************************************
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createajustes(
            @Valid @RequestBody Ajustes ajustes) {

        ResponseEntity<Map<String, Object>> response;

        if (ajustes == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");

            response = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(map);
        } else {

            if (ajustes.getTema() == null || ajustes.getTema().trim().isEmpty()
                    || ajustes.getIdioma() == null || ajustes.getIdioma().trim().isEmpty()
                    || ajustes.getFoto() == null || ajustes.getFoto().trim().isEmpty()) {

                Map<String, Object> map = new HashMap<>();
                map.put("error",
                        "Los campos 'tema', 'idioma' y 'foto' son obligatorios");

                response = ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(map);
            } else {
                System.out.println(ajustes);
                Ajustes ajustesPost = ajustesService.save(ajustes);

                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "Ajustes creados con éxito");
                map.put("insertAjustes", ajustesPost);

                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(map);
            }
        }
        return response;
    }

    // ****************************************************************************
    // UPDATE (PUT)
    // http://localhost:8080/roosevelt/api/ajustes
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Actualizar un ajustes existente", description = "Reemplaza completamente los datos de un ajustes identificado por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ajustes actualizado con éxito", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content()),
            @ApiResponse(responseCode = "404", description = "ajustes no encontrado", content = @Content())
    })
    // ***************************************************************************
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateajustes(
            @Valid @RequestBody Ajustes ajustesUpdate) {

        ResponseEntity<Map<String, Object>> response;

        if (ajustesUpdate == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");

            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        } else {
            int id = ajustesUpdate.getId();
            Ajustes existingAjustes = ajustesService.findById(id);

            if (existingAjustes == null) {
                Map<String, Object> map = new HashMap<>();
                map.put("error", "ajustes no encontrado");
                map.put("id", id);

                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
            } else {

                // Actualizar campos si están presentes
                if (ajustesUpdate.getTema() != null) {
                    existingAjustes.setTema(ajustesUpdate.getTema());
                }
                if (ajustesUpdate.getIdioma() != null) {
                    existingAjustes.setIdioma(ajustesUpdate.getIdioma());
                }
                if (ajustesUpdate.getFoto() != null) {
                    existingAjustes.setFoto(ajustesUpdate.getFoto());
                }
                existingAjustes.setRecibir_noticias(ajustesUpdate.isRecibir_noticias());
                existingAjustes.setRecibir_notificaciones(ajustesUpdate.isRecibir_notificaciones());

                Ajustes ajustesPut = ajustesService.save(existingAjustes);

                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "ajustes actualizado con éxito");
                map.put("updatedajustes", ajustesPut);

                response = ResponseEntity.status(HttpStatus.OK).body(map);
            }
        }
        return response;
    }

    // ****************************************************************************
    // DELETE
    // http://localhost:8080/roosevelt/api/ajustess/16
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Eliminar ajustes por ID", description = "Elimina un ajustes especifico del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ajustes eliminado con éxito", content = @Content()),
            @ApiResponse(responseCode = "404", description = "ajustes no encontrado", content = @Content())
    })
    // ***************************************************************************
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteajustes(@PathVariable int id) {

        ResponseEntity<Map<String, Object>> response;

        Ajustes existingajustes = ajustesService.findById(id);
        if (existingajustes == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "ajustes no encontrado");
            map.put("id", id);

            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        } else {

            ajustesService.deleteById(id);

            Map<String, Object> map = new HashMap<>();
            map.put("mensaje", "ajustes eliminado con éxito");
            map.put("deletedajustes", existingajustes);

            response = ResponseEntity.status(HttpStatus.OK).body(map);
        }
        return response;
    }
}
