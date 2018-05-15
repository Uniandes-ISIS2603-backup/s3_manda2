/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;


import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
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
 * @author n.bello
 */
@Stateless
public class ReclamoPersistence {
    private static final Logger LOGGER = Logger.getLogger(ReclamoPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    public ReclamoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando employee con id={0}", id);
        return em.find(ReclamoEntity.class, id);
    }
    
    public ReclamoEntity findByNumero(Integer numero) {
        LOGGER.log(Level.INFO, "Consultando reclamo con numero= ", numero);
        TypedQuery<ReclamoEntity> q
                = em.createQuery("select u from ReclamoEntity u where u.numero = :numero", ReclamoEntity.class);
        q = q.setParameter("numero", numero);
        return q.getSingleResult();
    }
    
    public List<ReclamoEntity> findAll() {
        LOGGER.info("Consultando todos los reclamos");
        Query q = em.createQuery("select u from ReclamoEntity u", ReclamoEntity.class);
        return q.getResultList();
    }

    public ReclamoEntity create(ReclamoEntity entity) {
        LOGGER.info("Creando un reclamo nuevo");
        em.persist(entity);
        LOGGER.info("reclamo creado");
        return entity;
    }

    public ReclamoEntity update(ReclamoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando reclamo con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando reclamo con id={0}", id);
        ReclamoEntity entity = em.find(ReclamoEntity.class, id);
        em.remove(entity);
    }
}
