/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.moreno
 */
public class BilleteraPersistence {
     private static final Logger LOGGER = Logger.getLogger(PagoPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
  
    public BilleteraEntity create(BilleteraEntity entity) {
        LOGGER.info("Creando una billetera nueva");
        em.persist(entity);
        LOGGER.info("Creando una billetera nueva");
        return entity;
    }
  
  public BilleteraEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando billetera con id={0}", id);
        return em.find(BilleteraEntity.class, id);
    }
  
    public List<BilleteraEntity> findAll() {
        LOGGER.info("Consultando todas las cities");
        TypedQuery query = em.createQuery("select u from CityEntity u", BilleteraEntity.class);
        return query.getResultList();
    }


    public BilleteraEntity update(BilleteraEntity entity) {
        return em.merge(entity);
    }

    public void delete(BilleteraEntity entity) {
      
        em.remove(entity);
}
}
