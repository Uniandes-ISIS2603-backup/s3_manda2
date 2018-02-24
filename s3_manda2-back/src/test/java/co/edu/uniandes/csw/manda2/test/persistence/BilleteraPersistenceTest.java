/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.persistence.BilleteraPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.moreno
 */
@RunWith(Arquillian.class)
public class BilleteraPersistenceTest {
        
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecciÃ³n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BilleteraEntity.class.getPackage())
                .addPackage(BilleteraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private BilleteraPersistence BilleteraPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
       /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
     /**
     * ConfiguraciÃ³n inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
     * Limpia las tablas que estÃ¡n implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from BilleteraEntity").executeUpdate();
    }

    /**
     * lista que tiene los datos de prueba
     */
    private List<BilleteraEntity> data = new ArrayList<BilleteraEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            BilleteraEntity entity = factory.manufacturePojo(BilleteraEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    /**
     * Prueba para crear una Billetera.
     *
     *
     */
    
    @Test
    public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        BilleteraEntity newEntity = factory.manufacturePojo(BilleteraEntity.class);
        BilleteraEntity result = BilleteraPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        BilleteraEntity entity = em.find(BilleteraEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getSaldo(), entity.getSaldo());
    }
}
