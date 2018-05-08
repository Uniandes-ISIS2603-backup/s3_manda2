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
        return em.find(OrganizacionEntity.class, id);
    }

    public OrganizacionEntity findByName(String name) {
     LOGGER.log(Level.INFO, "Consultando Organizacion por nombre ", name);

        // Se crea un query para buscar pse con el name que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From OrganizacionEntity e where e.name= :name", OrganizacionEntity.class);
        // Se remplaza el placeholder ":link" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<OrganizacionEntity> nombre = query.getResultList();
        if (nombre.isEmpty()) {
            return null;
        } else {
            return nombre.get(0);
        }
    }

    public List<OrganizacionEntity> findAll() {
        LOGGER.info("Consultando todos los Organizacions");
        TypedQuery query = em.createQuery("select u from OrganizacionEntity u", OrganizacionEntity.class);
        return query.getResultList();
    }

    public OrganizacionEntity create(OrganizacionEntity entity) {
        LOGGER.info("Creando un Organizacion nuevo");
        em.persist(entity);
        LOGGER.info("Organizacion creado");
        return entity;
    }

    public OrganizacionEntity update(OrganizacionEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
       OrganizacionEntity entidad = find(id);
        if(entidad!= null)
        {
        em.remove(entidad);
        }
}
}