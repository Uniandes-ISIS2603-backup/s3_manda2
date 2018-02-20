/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cv.trujillo
 */
@Stateless
public class ElementoBusquedaReservaPersistence {
     //Constantes
    private static final Logger LOGGER = Logger.getLogger(ElementoBusquedaReservaPersistence.class.getName());
    //Atributos
    @PersistenceContext(unitName="Manda2PU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto ElementoBusquedaReserva que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ElementoBusquedaReservaEntity create(ElementoBusquedaReservaEntity entity) {
        LOGGER.info("Creando un ElementoBusquedaReserva nuevo");
        em.persist(entity);
        LOGGER.info("Creando un ElementoBusquedaReserva nuevo");
        return entity;
    }

    /**
     * Busca si hay algun ElementoBusquedaReserva con el link que se envía de argumento
     *
     * @param link: Link del ElementoBusquedaReserva que se está buscando
     * @return null si no existe ninguna ElementoBusquedaReserva con el link del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ElementoBusquedaReservaEntity findByLink(String link) {
        LOGGER.log(Level.INFO, "Consultando ElementoBusquedaReserva por link ", link);

        // Se crea un query para buscar ElementoBusquedaReserva con el link que recibe el método como argumento. ":link" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ElementoBusquedaReservaEntity e where e.linkElementoBusquedaReserva = :link", ElementoBusquedaReservaEntity.class);
        // Se remplaza el placeholder ":link" con el valor del argumento 
        query = query.setParameter("link", link);
        // Se invoca el query se obtiene la lista resultado
        List<ElementoBusquedaReservaEntity> sameLink = query.getResultList();
        if (sameLink.isEmpty()) {
            return null;
        } else {
            return sameLink.get(0);
        }
    }

    public List<ElementoBusquedaReservaEntity> findAll() {
        LOGGER.info("Consultando todas los ElementoBusquedaReserva");
        TypedQuery query = em.createQuery("select u from ElementoBusquedaReservaEntity u", ElementoBusquedaReservaEntity.class);
        return query.getResultList();
    }

    public ElementoBusquedaReservaEntity find(String nombre) {
        return em.find(ElementoBusquedaReservaEntity.class, nombre);
    }

    public ElementoBusquedaReservaEntity update(ElementoBusquedaReservaEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(ElementoBusquedaReservaEntity entity) {
        em.remove(entity);
    }
}
