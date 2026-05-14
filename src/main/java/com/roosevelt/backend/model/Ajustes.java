package com.roosevelt.backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@AllArgsConstructor
@NoArgsConstructor
@Data

// SWAGGER
@Schema(description = "Modelo de Ajustes", name = "Ajustes")

// JPA
@Entity
@Table(name = "ajustes")

public class Ajustes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "ID único del ajustes", example = "0")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Schema(description = "El tema del usuario", example = "Oscuro")
    @NotBlank(message = "El titulo del usuario es obligatorio")
    @Size(min = 1, max = 15, message = "El tema del usuario no puede tener más de 15 caracteres")
    @Column(name = "tema", nullable = false, unique = false)
    private String tema;

    @Schema(description = "La idioma del usuario", example = "English")
    @NotBlank(message = "La usuario es obligatorio")
    @Size(min = 1, max = 15, message = "La idioma no puede tener más de 15 caracteres")
    @Column(name = "idioma", nullable = false, unique = false)
    private String idioma;

    @Schema(description = "La foto del usuario", example = "./photos/user.jpg")
    @NotBlank(message = "La foto es obligatoria")
    @Size(min = 1, max = 200, message = "La foto no puede tener más de 200 caracteres")
    @Column(name = "foto", nullable = false, unique = false)
    private String foto;

    @Schema(description = "Opción para recibir noticias", example = "true")
    @NotNull(message = "Recibir noticias no puede estar vacío")
    @Column(name = "recibir_noticias", nullable = false, unique = false) 
    private boolean recibir_noticias;

    @Schema(description = "Opción para recibir notificaciones", example = "true")
    @NotNull(message = "Recibir noticias no puede estar vacío")
    @Column(name = "recibir_notificaciones", nullable = false, unique = false) 
    private boolean recibir_notificaciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @JsonIgnoreProperties("ajustes")  
    private Usuario usuario;
}
