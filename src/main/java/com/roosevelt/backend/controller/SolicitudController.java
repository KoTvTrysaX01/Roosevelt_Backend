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

import com.roosevelt.backend.model.Solicitud;
import com.roosevelt.backend.model.SolicitudId;
import com.roosevelt.backend.service.SolicitudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "solicitudes", description = "API para gestión de solicitudes")
@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "/*")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    // ***************************************************************************
    // CONSULTAS
    // ***************************************************************************
    // http://localhost:8080/roosevelt/api/solicituds
    // ***************************************************************************    
    // SWAGGER
    @Operation(summary = "Obtener todos los solicituds",
            description = "Retorna una lista con todos los solicituds disponibles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "solicituds obtenidos con éxito")
    })  
    @GetMapping("")
    public ResponseEntity<List<Solicitud>> showsolicituds() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(solicitudService.findAll());
    }

    // http://localhost:8080/roosevelt/api/solicitudes/2/2
    // SWAGGER
    @Operation(summary = "Obtener solicitud por ID",
            description = "Retorna un solicitud específico basado en su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "solicitud encontrado"),
        @ApiResponse(responseCode = "404", description = "solicitud no encontrado", content = @Content())
    })
   
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> detailsSolicitud(@PathVariable Integer id_usuario, Integer id_ruta) {
        Solicitud solicitud = solicitudService.findById(id_usuario, id_ruta);

        if (solicitud == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);  // 404 Not Found
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(solicitud);
        }
    }

    // http://localhost:8080/roosevelt/api/solicitudes/nuevas
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener solicitudes nuevas", description = "Retorna una lista con todos los solicitude nuevas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ajustes obtenidos con éxito")
    })
    // ***************************************************************************
    @GetMapping("/nuevas")
    public ResponseEntity<List<Solicitud>> showSolicitudesNuevas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(solicitudService.findByNuevas());
    }

        // http://localhost:8080/roosevelt/api/solicitudes/aprobadas
    // ***************************************************************************
    // SWAGGER
    @Operation(summary = "Obtener solicitudes aprobadas", description = "Retorna una lista con todos los solicitude aprobadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ajustes obtenidos con éxito")
    })
    // ***************************************************************************
    @GetMapping("/aprobadas/{aprobada}")
    public ResponseEntity<List<Solicitud>> showSolicitudesAprobadas(@PathVariable boolean aprobada) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(solicitudService.findByAprobadas(aprobada));
    }

    // http://localhost:8080/roosevelt/api/solicituds/count
     // SWAGGER
    @Operation(summary = "Obtener el número de solicituds existentes",
            description = "Retorna la cantidad de solicituds")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Número de solicituds obtenidos con éxito", content = @Content())
    })
    // ***************************************************************************    
    
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> countsolicituds() {

        ResponseEntity<Map<String, Object>> response = null;

        Map<String, Object> map = new HashMap<>();
        map.put("solicituds", solicitudService.count());

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
    // http://localhost:8080/roosevelt/api/solicituds
    // ***************************************************************************      
    // SWAGGER
    @Operation(summary = "Crear una nueva solicitud",
            description = "Registra un nuevo solicitud en el sistema con los datos proporcionados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "solicitud creado con éxito", content = @Content()),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content())
    })
    // ***************************************************************************    

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> createsolicitud(
            @Valid @RequestBody Solicitud solicitud) {

        ResponseEntity<Map<String, Object>> response;

        if (solicitud == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");

            response = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(map);
        } else {

            if (solicitud.getFecha_pub() == null) {

                Map<String, Object> map = new HashMap<>();
                map.put("error", "Los campos 'fecha_pub' es obligatorio");

                response = ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(map);
            } else {
                System.out.println(solicitud);
                Solicitud usuPost = solicitudService.save(solicitud);

                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "solicitud creado con éxito");
                map.put("insertsolicitud", usuPost);

                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(map);
            }
        }

        return response;
    }

    // ****************************************************************************
    // UPDATE (PUT)
    // http://localhost:8080/roosevelt/api/solicituds
    // SWAGGER
    @Operation(summary = "Actualizar un solicitud existente",
            description = "Reemplaza completamente los datos de un solicitud identificado por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "solicitud actualizado con éxito", content = @Content()),
        @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos", content = @Content()),
        @ApiResponse(responseCode = "404", description = "solicitud no encontrado", content = @Content())
    })
    // ***************************************************************************    
   
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updatesolicitud(
            @Valid
            @RequestBody 
        Solicitud solicitudUpdate) {

        ResponseEntity<Map<String, Object>> response;

        if (solicitudUpdate == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "El cuerpo de la solicitud no puede estar vacío");

            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        } else {
            SolicitudId id = solicitudUpdate.getSolicitudId();
            Solicitud existingSolicitud = solicitudService.findById(id.getUsuario().getId(), id.getRuta().getId());

            if (existingSolicitud == null) {
                Map<String, Object> map = new HashMap<>();
                map.put("error", "solicitud no encontrado");
                map.put("id", id);

                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
            } else {

                // Actualizar campos si están presentes
                if (solicitudUpdate.getFecha_pub() != null) {
                    existingSolicitud.setFecha_pub(solicitudUpdate.getFecha_pub());
                }
                existingSolicitud.setAprobada(solicitudUpdate.isAprobada());
                          
                Solicitud usuPut = solicitudService.save(existingSolicitud);

                Map<String, Object> map = new HashMap<>();
                map.put("mensaje", "solicitud actualizado con éxito");
                map.put("updatedsolicitud", usuPut);

                response = ResponseEntity.status(HttpStatus.OK).body(map);
            }
        }

        return response;
    }

    // ****************************************************************************
    // DELETE
    // http://localhost:8080/roosevelt/api/solicituds/1/1
     // SWAGGER
    @Operation(summary = "Eliminar solicitud por ID",
            description = "Elimina un solicitud específico del sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "solicitud eliminado con éxito", content = @Content()),
        @ApiResponse(responseCode = "404", description = "solicitud no encontrado", content = @Content())
    })
    // ***************************************************************************    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletesolicitud(@PathVariable Integer id_usuario, Integer id_ruta) {

        ResponseEntity<Map<String, Object>> response;

        Solicitud existingsolicitud = solicitudService.findById(id_usuario, id_ruta);
        if (existingsolicitud == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "solicitud no encontrado");
            map.put("id", Integer.toString(id_usuario) + " " + Integer.toString(id_ruta));

            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        } else {

            solicitudService.deleteById(existingsolicitud.getSolicitudId());

            Map<String, Object> map = new HashMap<>();
            map.put("mensaje", "solicitud eliminado con éxito");
            map.put("deletedsolicitud", existingsolicitud);

            response = ResponseEntity.status(HttpStatus.OK).body(map);
        }
        return response;
    }
}
