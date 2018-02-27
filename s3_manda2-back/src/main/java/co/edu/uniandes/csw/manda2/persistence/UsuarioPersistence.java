/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;


import co.edu.uniandes.csw.manda2.entities.UsuarioEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author n.bello
 */
@Stateless
public class UsuarioPersistence {
    private static final Logger LOGGER = Logger.getLogger(UsuarioPersistence.class.getName());
    
    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;
    
    public UsuarioEntity create(UsuarioEntity entity){
        LOGGER.info("Creando un servicio nuevo");
        em.persist(entity);
        LOGGER.info("Creando un servicio nuevo");
        return entity;
    }
    
    public UsuarioEntity find( Long id ){
        return em.find(UsuarioEntity.class, id);
    }
    
    public List<UsuarioEntity> findAll(){
        LOGGER.info("Consultando todos los servicios");
        TypedQuery query = em.createQuery("select u from ServicioEnity u", UsuarioEntity.class);
        return query.getResultList();
    }
    
    public UsuarioEntity update( UsuarioEntity entity ){
        return em.merge(entity);
    }
    
    public void delete( UsuarioEntity entity ){
        em.remove(entity);
    }
}
