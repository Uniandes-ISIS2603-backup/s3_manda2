
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;
import co.edu.uniandes.csw.manda2.entities.PSEEntity;
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
public class PSEPersistence {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(PSEPersistence.class.getName());
    //Atributos
    @PersistenceContext(unitName="Manda2PU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto PSE que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PSEEntity create(PSEEntity entity) {
        LOGGER.info("Creando un PSE nuevo");
        em.persist(entity);
        LOGGER.info("Creando un PSE nuevo");
        return entity;
    }

    /**
     * Busca si hay algun PSE con el link que se envía de argumento
     *
     * @param link: Link del PSE que se está buscando
     * @return null si no existe ninguna PSE con el link del argumento. Si
     * existe alguna devuelve la primera.
     */
    public PSEEntity findByLink(String link) {
        LOGGER.log(Level.INFO, "Consultando PSE por link ", link);

        // Se crea un query para buscar pse con el link que recibe el método como argumento. ":link" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From PSEEntity e where e.linkPse = :link", PSEEntity.class);
        // Se remplaza el placeholder ":link" con el valor del argumento 
        query = query.setParameter("link", link);
        // Se invoca el query se obtiene la lista resultado
        List<PSEEntity> sameLink = query.getResultList();
        if (sameLink.isEmpty()) {
            return null;
        } else {
            return sameLink.get(0);
        }
    }

    public List<PSEEntity> findAll() {
        LOGGER.info("Consultando todas los PSE");
        TypedQuery query = em.createQuery("select u from PSEEntity u", PSEEntity.class);
        return query.getResultList();
    }

    public PSEEntity find(Long id) {
        return em.find(PSEEntity.class, id);
    }

    public PSEEntity update(PSEEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(Long id) {
        PSEEntity entidad = find(id);
        if(entidad!= null)
        {
        em.remove(entidad);
        }
    }
}
