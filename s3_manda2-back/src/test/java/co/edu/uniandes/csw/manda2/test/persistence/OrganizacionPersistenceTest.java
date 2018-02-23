/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.persistence.OrganizacionPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
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
public class OrganizacionPersistenceTest {
     @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OrganizacionEntity.class.getPackage())
                .addPackage(OrganizacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" );
    }
    
     @Inject
    private OrganizacionPersistence OrganizacionPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        OrganizacionEntity newEntity = factory.manufacturePojo(OrganizacionEntity.class);
        OrganizacionEntity result = OrganizacionPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        OrganizacionEntity entity = em.find(OrganizacionEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCostoDuracion(), entity.getCostoDuracion());
    }
}