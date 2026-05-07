package com.roosevelt.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roosevelt.backend.model.Solicitud;
import com.roosevelt.backend.model.SolicitudId;
import com.roosevelt.backend.repository.SolicitudRepository;

@Service
public class SolicitudService {
    

    @Autowired
    public SolicitudRepository solicitudRepository;

    // ************************
    // CONSULTAS
    // ************************ 
    @Transactional(readOnly = true)
    public List<Solicitud> findAll(){
        return solicitudRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Solicitud findById(int id_usuario, int id_ruta){
        return solicitudRepository.findSqlByIdSolicitud(id_usuario, id_ruta);
    }

    @Transactional(readOnly = true)
    public List<Solicitud> findByIdioma(boolean aprobada){
        return solicitudRepository.findSqlByAprobadas(aprobada);
    }


    @Transactional(readOnly = true) 
    public Long count() {
        return solicitudRepository.count();
    }
    
    // ************************
    // ACTUALIZACIONES
    // ************************ 
    @Transactional
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }


    @Transactional
    public Solicitud update(SolicitudId id, Solicitud solicitudDetails) {
        Solicitud solicitud = solicitudRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("solicitud no encontrado"));
        
        if (solicitudDetails.getFecha_pub() != null) {
            solicitud.setFecha_pub(solicitudDetails.getFecha_pub());
        }
        solicitud.setAprobada(solicitudDetails.isAprobada());
        
        return solicitudRepository.save(solicitud);
    }
    
    @Transactional
    public void deleteById(SolicitudId id) {
        if (!solicitudRepository.existsById(id)) {
            throw new RuntimeException("Solicitud no encontrada");
        }
        solicitudRepository.deleteById(id);
    }
}
