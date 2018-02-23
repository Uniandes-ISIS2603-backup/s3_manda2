/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
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
public class ArticuloPersistence  {
      
    private static final Logger LOGGER = Logger.getLogger(ArticuloPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
   /**
     *
     * @param entity objeto Articulo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ArticuloEntity create(ArticuloEntity entity) {
        LOGGER.info("Creando un Articulo nuevo");
        em.persist(entity);
        LOGGER.info("Creando un Articulo nuevo");
        return entity;
    }

    /**
     * Busca si hay algun Articulo con el Nombre que se envía de argumento
     *
     * @param nombre: Nombre del Articulo que se está buscando
     * @return null si no existe ninguna Articulo con el Nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ArticuloEntity findByNombre(String nombre) {
        LOGGER.log(Level.INFO, "Consultando Articulo por Nombre ", nombre);

        // Se crea un query para buscar Articulo con el Nombre que recibe el método como argumento. ":Nombre" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ArticuloEntity e where e.NombreArticulo = :Nombre", ArticuloEntity.class);
        // Se remplaza el placeholder ":Nombre" con el valor del argumento 
        query = query.setParameter("Nombre", nombre);
        // Se invoca el query se obtiene la lista resultado
        List<ArticuloEntity> sameNombre = query.getResultList();
        if (sameNombre.isEmpty()) {
            return null;
        } else {
            return sameNombre.get(0);
        }
    }

    public List<ArticuloEntity> findAll() {
        LOGGER.info("Consultando todas los Articulo");
        TypedQuery query = em.createQuery("select u from ArticuloEntity u", ArticuloEntity.class);
        return query.getResultList();
    }

    public ArticuloEntity find(Long id) {
        return em.find(ArticuloEntity.class, id);
    }

    public ArticuloEntity update(ArticuloEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(ArticuloEntity entity) {
        em.remove(entity);
    }
}
