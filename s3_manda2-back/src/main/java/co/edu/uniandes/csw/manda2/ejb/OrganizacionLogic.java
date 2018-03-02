/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.OrganizacionPersistence;
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
public class OrganizacionLogic {
     private static final Logger LOGGER = Logger.getLogger(OrganizacionLogic.class.getName());

    @Inject
    private OrganizacionPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public OrganizacionEntity createOrganizacion(OrganizacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Organizacion");
        // Verifica la regla de negocio que dice que no puede haber dos cities con el mismo nombre
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getId() + "\"");
        }
        // Invoca la persistencia para crear la Organizacion
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Organizacion");
        return entity;
    }

    public List<OrganizacionEntity> getCities() {
        LOGGER.info("Inicia proceso de consultar todas las cities");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<OrganizacionEntity> editorials = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las cities");
        return editorials;
    }

    public OrganizacionEntity getOrganizacion(Long id) {
        return persistence.find(id);
    }

    public OrganizacionEntity updateOrganizacion(OrganizacionEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getId() + "\"");
        }
        return persistence.update(entity);
    }
    
    public void deleteOrganizacion(OrganizacionEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar ciudad con id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar libro con id={0}", entity.getId());
    }
}
