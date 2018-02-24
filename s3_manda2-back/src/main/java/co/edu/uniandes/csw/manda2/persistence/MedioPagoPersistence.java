/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.MedioPagoEntity;
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
public class MedioPagoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(MedioPagoPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
  /**
     *
     * @param entity objeto medio pago que se crearÃ¡ en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MedioPagoEntity create(MedioPagoEntity entity) {
        LOGGER.info("Creando un medio de pago nuevo");
        em.persist(entity);
        LOGGER.info("Creando un medio de pago nuevo");
        return entity;
    }
    
  
  public MedioPagoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando medio pago con id={0}", id);
        return em.find(MedioPagoEntity.class, id);
    }
  
    public List<MedioPagoEntity> findAll() {
        LOGGER.info("Consultando todos los medios de pago");
        TypedQuery query = em.createQuery("select u from CityEntity u", MedioPagoEntity.class);
        return query.getResultList();
    }


    public MedioPagoEntity update(MedioPagoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando pago con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando empleado con id={0}", id);
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, id);
        em.remove(entity);
    }
}
