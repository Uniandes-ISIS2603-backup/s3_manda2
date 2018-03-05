/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;


import co.edu.uniandes.csw.manda2.ejb.VueltasConDemoraEnOficinaLogic;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import co.edu.uniandes.csw.manda2.persistence.VueltasConDemoraEnOficinaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import static javax.ws.rs.client.Entity.entity;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author dv.gonzalez10
 */
@RunWith(Arquillian.class)
public class VueltasConDemoraEnOficinaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
     @Inject
    private VueltasConDemoraEnOficinaLogic vueltasConDemoraEnOficinaLogic;
     
     @PersistenceContext
    private EntityManager em;
     
     @Inject
    private UserTransaction utx;
     
    private List<VueltasConDemoraEnOficinaEntity> data = new ArrayList<VueltasConDemoraEnOficinaEntity>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VueltasConDemoraEnOficinaEntity.class.getPackage())
                .addPackage(VueltasConDemoraEnOficinaLogic.class.getPackage())
                .addPackage(VueltasConDemoraEnOficinaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from BookEntity").executeUpdate();
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    
    private void insertData (){
        for (int i = 0; i < 3; i++) {
            VueltasConDemoraEnOficinaEntity entity = factory.manufacturePojo(VueltasConDemoraEnOficinaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
}