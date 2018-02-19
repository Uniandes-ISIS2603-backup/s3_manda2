/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;
import co.edu.uniandes.csw.manda2.entities.TarjetaDeCreditoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author na.caceres
 */
@Stateless
public class TarjetaDeCreditoPersistence {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(TarjetaDeCreditoPersistence.class.getName());
    //Atributos
    @PersistenceContext(unitName="Manda2PU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto Tarjeta de Credito que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TarjetaDeCreditoEntity create(TarjetaDeCreditoEntity entity) {
        LOGGER.info("Creando una Tarjeta de credito nueva");
        em.persist(entity);
        LOGGER.info("Creando una tarjeta de credito nueva");
        return entity;
    }

    /**
     * Busca si hay alguna Tarjeta de credito con el numero que se envía de argumento
     *
     * @param numeroTarjeta: Numero de la tarjeta de credito que se está buscando.
     * @return null si no existe ninguna tarjeta de credito con el numero del argumento. Si
     * existe alguna devuelve la primera.
     */
    public TarjetaDeCreditoEntity findByNumero(Integer numeroTarjeta) {
        LOGGER.log(Level.INFO, "Consultando Tarjeta de Credito por numero de tarjeta ", numeroTarjeta);

        // Se crea un query para buscar una tarjeta de credito con el numero que recibe el método como argumento. ":numeroTarjeta" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From TarjetaDeCreditoEntity e where e.numeroTarjeta = :numeroTarjeta", TarjetaDeCreditoEntity.class);
        // Se remplaza el placeholder ":numeroTarjeta" con el valor del argumento 
        query = query.setParameter("numeroTarjeta", numeroTarjeta);
        // Se invoca el query se obtiene la lista resultado
        List<TarjetaDeCreditoEntity> sameNumeroTarjeta = query.getResultList();
        if (sameNumeroTarjeta.isEmpty()) {
            return null;
        } else {
            return sameNumeroTarjeta.get(0);
        }
    }

    public List<TarjetaDeCreditoEntity> findAll() {
        LOGGER.info("Consultando todas las tarjetas de credito");
        TypedQuery query = em.createQuery("select u from TarjetaDeCreditoEntity u", TarjetaDeCreditoEntity.class);
        return query.getResultList();
    }

    public TarjetaDeCreditoEntity find(Long id) {
        return em.find(TarjetaDeCreditoEntity.class, id);
    }

    public TarjetaDeCreditoEntity update(TarjetaDeCreditoEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(TarjetaDeCreditoEntity entity) {
        em.remove(entity);
    }
}
