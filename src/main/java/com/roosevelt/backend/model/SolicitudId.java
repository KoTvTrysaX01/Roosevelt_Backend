package com.roosevelt.backend.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class SolicitudId implements Serializable{

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id")
    private Ruta ruta;


    // Getters & Setters

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Ruta getRuta(){
        return this.ruta;
    }

    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }
}