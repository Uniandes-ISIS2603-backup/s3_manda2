/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;
import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
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
public class ClientePersistence {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(ClientePersistence.class.getName());
    //Atributos
    @PersistenceContext(unitName="Manda2PU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto cliente que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ClienteEntity create( ClienteEntity entity) {
        LOGGER.info("Creando un cliente nuevo");
        em.persist(entity);
        LOGGER.info("Creando un cliente nuevo");
        return entity;
    }

    /**
     * Busca si hay algun cliente con el numero de cedula que se envía de argumento
     *
     * @param cedula: Numero de la cedula del cliente que se está buscando.
     * @return null si no existe ningun cliente con el numero de cedula del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ClienteEntity findByCedula(String cedula) {
        LOGGER.log(Level.INFO, "Consultando cliente por numero de cedula ", cedula);

        // Se crea un query para buscar un cliente con el numero de cedula que recibe el método como argumento. ":cedula" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ClienteEntity e where e.cedula = :cedula", ClienteEntity.class);
        // Se remplaza el placeholder ":cedula" con el valor del argumento 
        query = query.setParameter("cedula", cedula);
        // Se invoca el query se obtiene la lista resultado
        List<ClienteEntity> sameCedula = query.getResultList();
        if (sameCedula.isEmpty()) {
            return null;
        } else {
            return sameCedula.get(0);
        }
    }

    public List<ClienteEntity> findAll() {
        LOGGER.info("Consultando todas los clientes");
        TypedQuery query = em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
        return query.getResultList();
    }

    public ClienteEntity find(Long id) {
        return em.find(ClienteEntity.class, id);
    }

    public ClienteEntity update(ClienteEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(ClienteEntity entity) {
        em.remove(entity);
    }
}
