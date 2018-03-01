/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ElementoBusquedaReservaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cv.trujillo
 */
@Stateless
public class ElementoBusquedaReservaLogic {
    
     private static final Logger LOGGER = Logger.getLogger(ElementoBusquedaReservaLogic.class.getName());

    @Inject
    private ElementoBusquedaReservaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public ElementoBusquedaReservaEntity createElementoBusquedaReserva(ElementoBusquedaReservaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de ElementoBusquedaReserva");
        // Verifica la regla de negocio que dice que no puede haber dos cities con el mismo nombre
        if (persistence.find(entity.getNombre()) != null) {
            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getNombre()+ "\"");
        }
        // Invoca la persistencia para crear la ElementoBusquedaReserva
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de ElementoBusquedaReserva");
        return entity;
    }

    public List<ElementoBusquedaReservaEntity> getCities() {
        LOGGER.info("Inicia proceso de consultar todas las cities");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ElementoBusquedaReservaEntity> editorials = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las cities");
        return editorials;
    }

    public ElementoBusquedaReservaEntity getElementoBusquedaReserva(String nombre) {
        return persistence.find(nombre);
    }

    public ElementoBusquedaReservaEntity updateElementoBusquedaReserva(ElementoBusquedaReservaEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getNombre()) != null) {
            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getNombre() + "\"");
        }
        return persistence.update(entity);
    }
    
    public void deleteElementoBusquedaReserva(ElementoBusquedaReservaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar ciudad con id={0}", entity.getId());    
        persistence.delete(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar libro con id={0}", entity.getId());
    }
}
