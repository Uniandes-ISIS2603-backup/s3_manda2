/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence; 
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.moreno
 */
@Stateless
public class PagoPersistence {
 
     private static final Logger LOGGER = Logger.getLogger(PagoPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
  
    public PagoEntity create(PagoEntity entity) {
        LOGGER.info("Creando un pago nuevo");
        em.persist(entity);
        LOGGER.info("Creando un pago nuevo");
        return entity;
    }
  
  public PagoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando pago con id={0}", id);
        return em.find(PagoEntity.class, id);
    }
  
    public List<PagoEntity> findAll() {
        LOGGER.info("Consultando todos los pagos");
        TypedQuery query = em.createQuery("select u from PagoEntity u", PagoEntity.class);
        return query.getResultList();
    }


    public PagoEntity update(PagoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando pago con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando empleado con id={0}", id);
        PagoEntity entity = em.find(PagoEntity.class, id);
        em.remove(entity);
    }
}

