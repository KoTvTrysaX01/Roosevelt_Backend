package com.roosevelt.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roosevelt.backend.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    
    // Buscar - Todos
    @Query(value = "SELECT * FROM solicitudes", nativeQuery = true)
    List<Solicitud> findSqlAll();
    
    // Buscar - Por ID
    @Query(value = "SELECT * FROM solicitudes WHERE id_usuario = :id_usuario AND id_ruta = :id_ruta", nativeQuery = true)
    Solicitud findSqlByIdSolicitud(@Param("id_usuario") int id_usuario, @Param("id_ruta") int id_ruta);

    // Buscar - Nuevos
    @Query(value = "SELECT * FROM solicitudes WHERE aprobada = null", nativeQuery = true)
    List<Solicitud> findSqlByNuevos();

    // Buscar - Aprobadas
    @Query(value = "SELECT * FROM solicitudes WHERE aprobada = true", nativeQuery = true)
    List<Solicitud> findSqlByAprobadas();

        // Buscar - Rechazadas
    @Query(value = "SELECT * FROM solicitudes WHERE aprobada = false", nativeQuery = true)
    List<Solicitud> findSqlByRechazadas();

    // Buscar - Contar todos
    @Query(value = "SELECT COUNT(*) as cantidad FROM solicitudes", nativeQuery = true)
    Long countSql();    
}