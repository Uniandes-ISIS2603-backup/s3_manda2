/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dv.gonzalez10
 */
@Stateless
public class VueltasConDemoraEnOficinaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaPersistence.class.getName());
    
    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
     /**
     * @param entity objeto city que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public VueltasConDemoraEnOficinaEntity create(VueltasConDemoraEnOficinaEntity entity) {
        LOGGER.info("Creando una vuelta con demora en oficina nueva");
        em.persist(entity);
        LOGGER.info("Creando una vuelta con demora en oficina nueva");
        return entity;
    }
    
    
}
