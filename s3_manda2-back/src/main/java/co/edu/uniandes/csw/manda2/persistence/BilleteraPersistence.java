/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.persistence;

import co.edu.uniandes.csw.manda2.entities.BaseEntity;
import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author m.moreno
 */
@Stateless
public class BilleteraPersistence {

    private static final Logger LOGGER = Logger.getLogger(BilleteraPersistence.class.getName());

    @PersistenceContext(unitName = "Manda2PU")
    protected EntityManager em;

    /**
     *
     * @param entity billetera que se crearÃ¡ en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public BilleteraEntity create(BilleteraEntity entity) {
        LOGGER.info("Creando una billetera nueva");
        em.persist(entity);
        LOGGER.info("Creando una billetera nueva");
        return entity;
    }

    public BilleteraEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando billetera con id={0}", id);
        return em.find(BilleteraEntity.class, id);
    }

    public List<BilleteraEntity> findAll() {
        LOGGER.info("Consultando todas las billeteras");
        TypedQuery query = em.createQuery("select u from BilleteraEntity u", BilleteraEntity.class);
        return query.getResultList();
    }

    public BilleteraEntity update(BilleteraEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        BilleteraEntity entity = find(id);
        if (entity != null) {
            em.remove(entity);
        }
    }

//    public BilleteraEntity findByCedula(String cedula) {
//        
//        LOGGER.log(Level.INFO, "Consultando cliente por numero de cedula ", cedula);
//
//        // Se crea un query para buscar un cliente con el numero de cedula que recibe el método como argumento. ":cedula" es un placeholder que debe ser remplazado
//        TypedQuery query = em.createQuery("Select e From ClienteEntity e where e.cedula = :cedula", BilleteraEntity.class);
//        // Se remplaza el placeholder ":cedula" con el valor del argumento 
//        query = query.setParameter("cedula", cedula);
//        // Se invoca el query se obtiene la lista resultado
//        List<BilleteraEntity> sameCedula = query.getResultList();
//        if (sameCedula.isEmpty()) {
//            return null;
//        } else {
//            return sameCedula.get(0);
//        }
//    }

    public BilleteraEntity find(SingularAttribute<BaseEntity, Long> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
