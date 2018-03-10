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
    //Atributos
    @Inject
    private OrganizacionPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los organizaciones que hay en la base de datos.
     * @return Lista de entidades de tipo organizacion.
     */
    public List<OrganizacionEntity> getOrganizaciones() {
        LOGGER.info("Inicia proceso de consultar todos los organizaciones");
        List<OrganizacionEntity> organizaciones = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los organizaciones");
        return organizaciones;
    }
    /**
     * Busca un organizacion por ID
     * @param id El id del organizacion a buscar
     * @return El organizacion encontrado, null si no lo encuentra.
     */
    public OrganizacionEntity getOrganizacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar organizacion con id={0}", id);
        OrganizacionEntity organizacion = persistence.find(id);
        if (organizacion == null) {
            LOGGER.log(Level.SEVERE, "El organizacion con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar organizacion"
                + " con id={0}", id);
        return organizacion;
    }
    /**
     * Eliminar un Organizacion
     * @param id El ID del organizacion a eliminar
     */
    public void deleteOrganizacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar organizacion con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar organizacion con id={0}", id);
    }
    /**
     * Guardar un nuevo Organizacion
     * @param entity La entidad de tipo organizacion del nuevo organizacion a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban vacios. 
     */
    public OrganizacionEntity createOrganizacion(OrganizacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación del organizacion");
      
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de organizacion");
        return entity;
    }
    /**
     * Actualizar un organizacion por ID
     * @param id El ID del organizacion a actualizar
     * @param entity La entidad del organizacion con los cambios deseados
     * @return La entidad del organizacion luego de actualizarla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban vacios o se intento cambiar el id.
     */
    public OrganizacionEntity updateOrganizacion(Long id, OrganizacionEntity entity) throws BusinessLogicException {
        return persistence.update(entity);
    }
    
        
    }



