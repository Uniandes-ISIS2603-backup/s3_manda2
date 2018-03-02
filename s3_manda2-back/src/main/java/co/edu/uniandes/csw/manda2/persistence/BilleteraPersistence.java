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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.moreno
 */
@Stateless
public class BilleteraPersistence {
     private static final Logger LOGGER = Logger.getLogger(BilleteraPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
  
     /**
     *
     * @param entity billetera que se crearÃ¡ en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
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
        LOGGER.info("Consultando todas las billeteras");
        TypedQuery query = em.createQuery("select u from BilleteraEntity u", BilleteraEntity.class);
        return query.getResultList();
    }


    public BilleteraEntity update(BilleteraEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
      BilleteraEntity entity = find(id);
        if(entity!= null)
        {
        em.remove(entity);
        }
}
}
