/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.persistence.ArticuloPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author cv.trujillo
 */

public class ArticuloPersistenceTest {
    
   /**
    *  Inyección de la dependencia a la clase ArticuloPersistence cuyos métodos
     * se van a probar.
    */
    
    @Inject
    private ArticuloPersistence articuloPersistence;
    
     /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    /**
     * Prueba para crear un Articulo.
     *
     *
     */
    @Test
    public void createArticuloTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ArticuloEntity newEntity = factory.manufacturePojo(ArticuloEntity.class);
        ArticuloEntity result = articuloPersistence.create(newEntity);
        //HASTA AQUÍ SOLO LO HE LLAMADO PARA QUE SE CREE, el verde indica que es mi metodo

        Assert.assertNotNull(result);

        ArticuloEntity entity = em.find(ArticuloEntity.class, result.getNombre());
        
        //le pido que me de el registro

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        //lo comparo
    }
    
}
