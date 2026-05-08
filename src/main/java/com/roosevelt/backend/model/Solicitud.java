package com.roosevelt.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@AllArgsConstructor
@NoArgsConstructor
@Data

// SWAGGER
@Schema(description = "Modelo de Solicitud", name="Solicitud")

// JPA
@Entity
@Table(name = "solicitudes")

public class Solicitud implements Serializable{

    private static final long serialVersionUID = 1L;

    @Schema(description = "EmbeddedId del solicitud. Se compone de Usuario y Ruta")
    @EmbeddedId
    private SolicitudId solicitudId;

    @Schema(description = "La fecha de publicación de la solicitud", example = "2015-01-11")
    @NotNull(message = "La fecha de publicación es obligatoria")
    @Column(name = "fecha_pub", nullable = false, unique = false)
    private LocalDate fecha_pub;

    @Schema(description = "Indica si la solicitud ha sido aprobada o no. Puede ser nulo mientras no se haya revisado.", example = "true")
    @Column(name = "aprobada", nullable = true, unique = false) 
    private Boolean aprobada;
}
