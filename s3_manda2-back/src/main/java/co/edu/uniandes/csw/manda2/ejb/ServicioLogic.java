/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.persistence.ServicioPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author da.ramos
 */
@Stateless
public class ServicioLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ServicioLogic.class.getName());
    
    @Inject
    ServicioPersistence servicioPersistence;
    
    public List<ServicioEntity> getServicios(){
        LOGGER.info("Inicia proceso de consultar servicios");
        List<ServicioEntity> list = servicioPersistence.findAll();
        LOGGER.info("Termina proceso de consultar servicios");
        return list;
    }
    
    public ServicioEntity getServicio(Long id){
        
    }
    
    
    private boolean validateServicio( String nombre, Double costo, String estado, String puntoDeEncuentro, String puntoDeRealizacion, String descripcion, Double calificacion, EmpleadoEntity empleado, ClienteEntity cliente, PagoEntity pago){
        return (validateCalificacion(calificacion)
                && validateCliente(cliente)
                && validateCosto(costo)
                && validateDescripcion(descripcion)
                && validateEmpleado(empleado)
                && validateEstado(estado)
                && validateNombre(nombre)
                && validatePago(pago)
                && validatePuntoDeEncuentro(puntoDeEncuentro)
                && validatePuntoDeRealizacion(puntoDeRealizacion));
    }
    
    private boolean validateNombre( String nombre ){
        return (nombre != null && !nombre.isEmpty());
    }
    
    private boolean validateCosto( Double costo ){
        return (costo != null && costo > 0);
    }
    
    private boolean validateEstado( String estado ){
        return ( estado != null 
                && (ServicioEntity.EN_DESARROLLO.equals(estado) 
                    || ServicioEntity.EN_ESPERA.equals(estado) 
                    || ServicioEntity.FINALIZADO.equals(estado)) );
    }
    
    private boolean validatePuntoDeEncuentro( String puntoDeEncuentro ){
        return (puntoDeEncuentro != null && !puntoDeEncuentro.isEmpty());
    } 
    
    private boolean validatePuntoDeRealizacion( String puntoDeRealizacion ){
        return (puntoDeRealizacion != null && !puntoDeRealizacion.isEmpty());
    }
    
    private boolean validateCalificacion( Double calificacion ){
        return (calificacion != null && calificacion >= 0);
    }
    
    private boolean validateDescripcion( String descripcion ){
        return (descripcion != null && !descripcion.isEmpty());
    }
    
    private boolean validatePago( PagoEntity pago ){
        return pago != null;
    }
    
    private boolean validateEmpleado( EmpleadoEntity empleado ){
        return empleado != null;
    }
    
    private boolean validateCliente( ClienteEntity cliente ){
        return cliente != null;
    }
}
