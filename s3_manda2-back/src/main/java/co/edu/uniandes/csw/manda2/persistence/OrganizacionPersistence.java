/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
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
 * @author cv.trujillo
 */
@Stateless
public class OrganizacionPersistence  {
       //Constantes
    private static final Logger LOGGER = Logger.getLogger(OrganizacionPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    public OrganizacionEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando employee con id={0}", id);
        return em.find(OrganizacionEntity.class, id);
    }

    public OrganizacionEntity findByName(String numero) {
        LOGGER.log(Level.INFO, "Consultando Organizacion con numero= ", numero);
        TypedQuery<OrganizacionEntity> q
                = em.createQuery("select u from OrganizacionEntity u where u.numero = :numero", OrganizacionEntity.class);
        q = q.setParameter("nombre", numero);
        return q.getSingleResult();
    }

    public List<OrganizacionEntity> findAll() {
        LOGGER.info("Consultando todos los Organizacions");
        Query q = em.createQuery("select u from OrganizacionEntity u");
        return q.getResultList();
    }

    public OrganizacionEntity create(OrganizacionEntity entity) {
        LOGGER.info("Creando un Organizacion nuevo");
        em.persist(entity);
        LOGGER.info("Organizacion creado");
        return entity;
    }

    public OrganizacionEntity update(OrganizacionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Organizacion con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Organizacion con id={0}", id);
        OrganizacionEntity entity = em.find(OrganizacionEntity.class, id);
        em.remove(entity);
}
}