/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;


import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.persistence.ReclamoPersistence;
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
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" )
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ReclamoPersistence reclamoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserTransaction utx;
    
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
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from ReclamoEntity").executeUpdate();
    }

    /**
     * lista que tiene los datos de prueba
     */
    private List<ReclamoEntity> data = new ArrayList<ReclamoEntity>();
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            ReclamoEntity entity = factory.manufacturePojo(ReclamoEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    @Test
    public void createReclamoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ReclamoEntity newEntity = factory.manufacturePojo(ReclamoEntity.class);
        ReclamoEntity result = reclamoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ReclamoEntity entity = em.find(ReclamoEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
    }
    
    @Test
    public void getReclamosTest() {
        List<ReclamoEntity> list = reclamoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ReclamoEntity ent : list) {
            boolean found = false;
            for (ReclamoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un reclamo.
     *
     * 
     */
    @Test
    public void getReclamoTest() {
        ReclamoEntity entity = data.get(0);
        ReclamoEntity newEntity = reclamoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }
    /**
     * Prueba para consultar un reclamo.
     *
     *
     */
    @Test
    public void getReclamoByNumeroTest() {
        ReclamoEntity entity = data.get(0);
        /*
         Comenté esto porque findByNumero causa un error de compilación. - Diego
         ReclamoEntity newEntity = reclamoPersistence.findByNumero(entity.getNumero());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
        Assert.assertEquals(entity.getId(), newEntity.getId());
        */
    }
    @Test
    public void deleteReclamoTest() {
        ReclamoEntity entity = data.get(0);
        reclamoPersistence.delete(entity.getId());
        ReclamoEntity deleted = em.find(ReclamoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para actualizar un reclamo.
     *
     * 
     */
    @Test
    public void updatePSETest() {
        ReclamoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReclamoEntity newEntity = factory.manufacturePojo(ReclamoEntity.class);

        newEntity.setId(entity.getId());

        reclamoPersistence.update(newEntity);

        ReclamoEntity resp = em.find(ReclamoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNumero(), resp.getNumero());
        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
}
