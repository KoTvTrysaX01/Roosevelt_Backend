package com.roosevelt.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roosevelt.backend.model.Ajustes;
import com.roosevelt.backend.repository.AjustesRepository;

@Service
public class AjustesService {
    

    @Autowired
    public AjustesRepository ajustesRepository;

    // ************************
    // CONSULTAS
    // ************************ 
    @Transactional(readOnly = true)
    public List<Ajustes> findAll(){
        return ajustesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Ajustes findById(int id){
        return ajustesRepository.findSqlByIdAjustes(id);
    }

    @Transactional(readOnly = true)
    public List<Ajustes> findByIdioma(String idioma){
        return ajustesRepository.findSqlByIdioma(idioma);
    }

    @Transactional(readOnly = true)
    public List<Ajustes> findByRecNoticias(boolean recibir_noticias){
        return ajustesRepository.findSqlByRecNoticias(recibir_noticias);
    }

        @Transactional(readOnly = true)
    public List<Ajustes> findByRecNotificaciones(boolean recibir_notificaciones){
        return ajustesRepository.findSqlByRecNotificaciones(recibir_notificaciones);
    }


    @Transactional(readOnly = true) 
    public Long count() {
        return ajustesRepository.count();
    }


    @Transactional(readOnly = true) 
    public Long countNoticias() {
        return ajustesRepository.countNoticiasSql();
    }


    @Transactional(readOnly = true) 
    public Long countNotificaciones() {
        return ajustesRepository.countNotificacionesSql();
    }
    
    // ************************
    // ACTUALIZACIONES
    // ************************ 
    @Transactional
    public Ajustes save(Ajustes ajustes) {
        return ajustesRepository.save(ajustes);
    }


    @Transactional
    public Ajustes update(int id, Ajustes ajustesDetails) {
        Ajustes ajustes = ajustesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("ajustes no encontrado"));
        
        if (ajustesDetails.getTema() != null) {
            ajustes.setTema(ajustesDetails.getTema());
        }
        if (ajustesDetails.getIdioma() != null) {
            ajustes.setIdioma(ajustesDetails.getIdioma());
        }
        if (ajustesDetails.getFoto() != null) {
            ajustes.setFoto(ajustesDetails.getFoto());
        }
        ajustes.setRecibir_noticias(ajustes.isRecibir_noticias());
        ajustes.setRecibir_notificaciones(ajustes.isRecibir_notificaciones());

        if (ajustesDetails.getUsuario() != null) {
            ajustes.setUsuario(ajustesDetails.getUsuario());
        }
        return ajustesRepository.save(ajustes);
    }
    
    @Transactional
    public void deleteById(int id) {
        if (!ajustesRepository.existsById(id)) {
            throw new RuntimeException("Ajustes no encontrado");
        }
        ajustesRepository.deleteById(id);
    }
}
