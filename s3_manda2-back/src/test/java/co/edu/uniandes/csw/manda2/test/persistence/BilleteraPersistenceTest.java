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
     * Prueba para crear un Billetera.
     *
     *
     */
    @Test
    public void createBilleteraTest() {
        PodamFactory factory = new PodamFactoryImpl();
        BilleteraEntity newEntity = factory.manufacturePojo(BilleteraEntity.class);
        BilleteraEntity result = BilleteraPersistence.create(newEntity);

        Assert.assertNotNull(result);

        BilleteraEntity entity = em.find(BilleteraEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    /**
     * Prueba para consultar la lista de Billeteras.
     *
     * 
     */
    @Test
    public void getBilleterasTest() {
        List<BilleteraEntity> list = BilleteraPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (BilleteraEntity ent : list) {
            boolean found = false;
            for (BilleteraEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un Billetera.
     *
     * 
     */
    @Test
    public void getBilleteraTest() {
        BilleteraEntity newEntity = data.get(0);
        BilleteraEntity resp= BilleteraPersistence.find(newEntity.getId());
        Assert.assertNotNull(newEntity);
         Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getSaldo(), resp.getSaldo());
        Assert.assertEquals(newEntity.getPuntosFidelidad(), resp.getPuntosFidelidad());
    }
   
    /**
     * Prueba para eliminar un Billetera.
     *
     * 
     */
    @Test
    public void deleteBilleteraTest() {
        BilleteraEntity entity = data.get(0);
        BilleteraPersistence.delete(entity.getId());
        BilleteraEntity deleted = em.find(BilleteraEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para actualizar un Billetera.
     *
     * 
     */
    @Test
    public void updateBilleteraTest() {
        BilleteraEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        BilleteraEntity newEntity = factory.manufacturePojo(BilleteraEntity.class);

        newEntity.setId(entity.getId());

        BilleteraPersistence.update(newEntity);

        BilleteraEntity resp = em.find(BilleteraEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getSaldo(), resp.getSaldo());
        Assert.assertEquals(newEntity.getPuntosFidelidad(), resp.getPuntosFidelidad());
    }
}

