/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

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
public class OrganizacionPersistence {
       //Constantes
    private static final Logger LOGGER = Logger.getLogger(OrganizacionPersistence.class.getName());
    //Atributos
    @PersistenceContext(unitName="Manda2PU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto Organizacion que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public OrganizacionEntity create(OrganizacionEntity entity) {
        LOGGER.info("Creando un Organizacion nuevo");
        em.persist(entity);
        LOGGER.info("Creando un Organizacion nuevo");
        return entity;
    }

    /**
     * Busca si hay algun Organizacion con el link que se envía de argumento
     *
     * @param link: Link del Organizacion que se está buscando
     * @return null si no existe ninguna Organizacion con el link del argumento. Si
     * existe alguna devuelve la primera.
     */
    public OrganizacionEntity findByLink(String link) {
        LOGGER.log(Level.INFO, "Consultando Organizacion por link ", link);

        // Se crea un query para buscar Organizacion con el link que recibe el método como argumento. ":link" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From OrganizacionEntity e where e.linkOrganizacion = :link", OrganizacionEntity.class);
        // Se remplaza el placeholder ":link" con el valor del argumento 
        query = query.setParameter("link", link);
        // Se invoca el query se obtiene la lista resultado
        List<OrganizacionEntity> sameLink = query.getResultList();
        if (sameLink.isEmpty()) {
            return null;
        } else {
            return sameLink.get(0);
        }
    }

    public List<OrganizacionEntity> findAll() {
        LOGGER.info("Consultando todas los Organizacion");
        TypedQuery query = em.createQuery("select u from OrganizacionEntity u", OrganizacionEntity.class);
        return query.getResultList();
    }

    public OrganizacionEntity find(Double duracion) {
        return em.find(OrganizacionEntity.class, duracion);
    }

    public OrganizacionEntity update(OrganizacionEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(OrganizacionEntity entity) {
        em.remove(entity);
    }
}
