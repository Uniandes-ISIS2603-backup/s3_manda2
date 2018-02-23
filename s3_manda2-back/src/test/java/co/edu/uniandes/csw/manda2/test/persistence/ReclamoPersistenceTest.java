/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;


import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.persistence.ReclamoPersistence;
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
 * @author n.bello
 */
@RunWith(Arquillian.class)
public class ReclamoPersistenceTest {
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReclamoEntity.class.getPackage())
                .addPackage(ReclamoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" );
    }
    
    @Inject
    private ReclamoPersistence reclamoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createReclamoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ReclamoEntity newEntity = factory.manufacturePojo(ReclamoEntity.class);
        ReclamoEntity result = reclamoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ReclamoEntity entity = em.find(ReclamoEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
    }
}
