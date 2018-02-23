/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.persistence.ElementoBusquedaReservaPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author cv.trujillo
 */
@RunWith(Arquillian.class)
public class ElementoBusquedaReservaTest {
     @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ElementoBusquedaReservaEntity.class.getPackage())
                .addPackage(ElementoBusquedaReservaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" );
    }
    
     @Inject
    private ElementoBusquedaReservaPersistence ElementoBusquedaReservaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ElementoBusquedaReservaEntity newEntity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
        ElementoBusquedaReservaEntity result = ElementoBusquedaReservaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ElementoBusquedaReservaEntity entity = em.find(ElementoBusquedaReservaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCostoDuracion(), entity.getCostoDuracion());
    }
}
