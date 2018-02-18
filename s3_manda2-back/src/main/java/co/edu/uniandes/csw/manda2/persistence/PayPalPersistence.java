/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
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
public class PayPalPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PayPalPersistence.class.getName());
    
    @PersistenceContext(unitName="Manda2PU")
    protected EntityManager em;
    
    public PayPalEntity create(PayPalEntity entity){
        LOGGER.info("Creando un paypal nuevo");
        em.persist(entity);
        LOGGER.info("Creando un paypal nuevo");
        return entity;
    }
    
    public PayPalEntity find( Long id ){
        return em.find(PayPalEntity.class, id);
    }
    
    public List<PayPalEntity> findAll(){
        LOGGER.info("Consultando todos los paypals");
        TypedQuery query = em.createQuery("select u from PayPalEntity u", PayPalEntity.class);
        return query.getResultList();
    }
    
    public PayPalEntity update( PayPalEntity entity ){
        return em.merge(entity);
    }
    
    public void delete( PayPalEntity entity ){
        em.remove(entity);
    }
}
