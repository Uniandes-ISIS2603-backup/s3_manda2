/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
import co.edu.uniandes.csw.manda2.persistence.PayPalPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author da.ramos
 */
@RunWith(Arquillian.class)
public class PayPalPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PayPalEntity.class.getPackage())
                .addPackage(PayPalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
    }
    
    @Inject
    private PayPalPersistence PayPalPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createPayPalTest(){
        PodamFactory factory = new PodamFactoryImpl();
        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
        PayPalEntity result = PayPalPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        PayPalEntity entity = em.find(PayPalEntity.class, result.getId());
        
        Assert.asserEquals(newEntity.getLinkPayPal(), entity.getLinkPayPal());
                
    }
}
