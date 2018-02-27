/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.CityEntity;
import co.edu.uniandes.csw.manda2.entities.MedioPagoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.CityPersistence;
import co.edu.uniandes.csw.manda2.persistence.MedioPagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.moreno
 */
@Stateless
public class MedioPagoLogic {
 private static final Logger LOGGER = Logger.getLogger(MedioPagoLogic.class.getName());

    @Inject
    private MedioPagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

//    public MedioPagoEntity createCity(MedioPagoEntity entity) throws BusinessLogicException {
//        LOGGER.info("Inicia proceso de creación de medio pago");
//        // Verifica la regla de negocio que dice que no puede haber dos cities con el mismo nombre
//        if (persistence.findByName(entity.getName()) != null) {
//            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getName() + "\"");
//        }
//        // Invoca la persistencia para crear la city
//        persistence.create(entity);
//        LOGGER.info("Termina proceso de creación de city");
//        return entity;
    //}

    public List<MedioPagoEntity> getMedioPago() {
        LOGGER.info("Inicia proceso de consultar todos los medios de pago");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<MedioPagoEntity> editorials = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los medios de ppag");
        return editorials;
    }

    public MedioPagoEntity getMedioPago(Long id) {
        return persistence.find(id);
    }

//    public CityEntity updateCity(CityEntity entity) throws BusinessLogicException  {
//        if (persistence.findByName(entity.getName()) != null) {
//            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getName() + "\"");
//        }
//        return persistence.update(entity);
//    }
    
//    public void deleteMedioPago(MedioPagoEntity entity) throws BusinessLogicException {
//        LOGGER.log(Level.INFO, "Inicia proceso de borrar medio pago con id={0}", entity.getId());    
//        persistence.delete(entity);
//        LOGGER.log(Level.INFO, "Termina proceso de borrar medio pago con id={0}", entity.getId());
//    }
}
   
