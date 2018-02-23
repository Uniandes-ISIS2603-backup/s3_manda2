/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author da.ramos
 */
@Stateless
public class ServicioPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ServicioPersistence.class.getName());
    
    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    public ServicioEntity create(ServicioEntity entity){
        LOGGER.info("Creando un servicio nuevo");
        em.persist(entity);
        LOGGER.info("Creando un servicio nuevo");
        return entity;
    }
    
    public ServicioEntity find( Long id ){
        return em.find(ServicioEntity.class, id);
    }
    
    public List<ServicioEntity> findAll(){
        LOGGER.info("Consultando todos los servicios");
        TypedQuery query = em.createQuery("select u from ServicioEntity u", ServicioEntity.class);
        return query.getResultList();
    }
    
    public ServicioEntity update( ServicioEntity entity ){
        return em.merge(entity);
    }
    
    public void delete( ServicioEntity entity ){
        em.remove(entity);
    }
}
