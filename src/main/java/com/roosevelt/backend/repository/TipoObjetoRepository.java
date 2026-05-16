package com.roosevelt.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roosevelt.backend.model.TipoObjeto;

public interface TipoObjetoRepository extends JpaRepository<TipoObjeto, Integer> {
    
    // Buscar - Todos
    @Query(value = "SELECT * FROM tipos_objeto", nativeQuery = true)
    List<TipoObjeto> findSqlAll();
    
    // Buscar - Por ID
    @Query(value = "SELECT * FROM tipos_objeto WHERE id = :id", nativeQuery = true)
    TipoObjeto findSqlByIdTipoObjeto(@Param("id") int id);

    // Buscar - Contar todos
    @Query(value = "SELECT COUNT(*) as cantidad FROM tipos_objeto", nativeQuery = true)
    Long countSql();    

        // Buscar - Ruta mas popular
    @Query(value = "SELECT * FROM tipos_objeto WHERE id = (SELECT id_tipo_objeto FROM objetos GROUP BY id_tipo_objeto ORDER BY COUNT(id_tipo_objeto) DESC LIMIT 1)", nativeQuery = true)
    TipoObjeto findSqlMasUsado();
}