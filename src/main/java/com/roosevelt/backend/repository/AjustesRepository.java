package com.roosevelt.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roosevelt.backend.model.Ajustes;

public interface AjustesRepository extends JpaRepository<Ajustes, Integer> {
    
    // Buscar - Todos
    @Query(value = "SELECT * FROM ajustes", nativeQuery = true)
    List<Ajustes> findSqlAll();
    
    // Buscar - Por ID
    @Query(value = "SELECT * FROM ajustes WHERE id = :id", nativeQuery = true)
    Ajustes findSqlByIdAjustes(@Param("id") int id);

    // Buscar - Por idioma
    @Query(value = "SELECT * FROM ajustes WHERE idioma = :idioma", nativeQuery = true)
    List<Ajustes> findSqlByIdioma(@Param("idioma") String idioma);

    // Buscar - Por Recibir Noticias
    @Query(value = "SELECT * FROM ajustes WHERE recibir_noticias = :recibir_noticias", nativeQuery = true)
    List<Ajustes> findSqlByRecNoticias(@Param("recibir_noticias") boolean recibir_noticias);

    // Buscar - Por Recibir Notificaciones
    @Query(value = "SELECT * FROM ajustes WHERE recibir_notificaciones = :recibir_notificaciones", nativeQuery = true)
    List<Ajustes> findSqlByRecNotificaciones(@Param("recibir_notificaciones") boolean recibir_notificaciones);

    // Buscar - Contar todos
    @Query(value = "SELECT COUNT(*) as cantidad FROM ajustes", nativeQuery = true)
    Long countSql();    

    @Query(value = "SELECT COUNT(*) as cantidad FROM ajustes WHERE recibir_noticias = TRUE", nativeQuery = true)
    Long countNoticiasSql();

    @Query(value = "SELECT COUNT(*) as cantidad FROM ajustes WHERE recibir_notificaciones = TRUE", nativeQuery = true)
    Long countNotificacionesSql();
}