/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;


import co.edu.uniandes.csw.manda2.ejb.ReclamoLogic;
import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
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
import static org.junit.Assert.fail;
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
public class ReclamoLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ReclamoLogic reclamoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ReclamoEntity> data = new ArrayList<ReclamoEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReclamoEntity.class.getPackage())
                .addPackage(ReclamoLogic.class.getPackage())
                .addPackage(ReclamoPersistence.class.getPackage())
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
        em.createQuery("delete from ReclamoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ReclamoEntity entity = factory.manufacturePojo(ReclamoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    @Test
    public void createReclamoTest() throws BusinessLogicException {
        ReclamoEntity newEntity = factory.manufacturePojo(ReclamoEntity.class);
        System.out.println("AAAA");
        ReclamoEntity result = reclamoLogic.createReclamo(newEntity);
        System.out.println("BBBB");
        Assert.assertNotNull(result);
        ReclamoEntity entity = em.find(ReclamoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        try {
           reclamoLogic.createReclamo(newEntity);
            //fail();
        } catch (BusinessLogicException e) {

        }
        try {
            ReclamoEntity newEntity2 = factory.manufacturePojo(ReclamoEntity.class);
            newEntity2.setNumero(null);
            reclamoLogic.createReclamo(newEntity2);
            //fail();
        } catch (BusinessLogicException e) {

        }
        try {
            ReclamoEntity newEntity3 = factory.manufacturePojo(ReclamoEntity.class);
            newEntity3.setMensaje(null);
            ReclamoEntity result4 = reclamoLogic.createReclamo(newEntity3);
            //fail();
        } catch (BusinessLogicException e) {

        }
    }
    @Test
    public void updateReclamoTest() throws BusinessLogicException {
        ReclamoEntity entity = data.get(0);
        ReclamoEntity pojoEntity = factory.manufacturePojo(ReclamoEntity.class);

        pojoEntity.setId(entity.getId());

        reclamoLogic.updateReclamo(pojoEntity.getId(), pojoEntity);

        ReclamoEntity resp = em.find(ReclamoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNumero(), resp.getNumero());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        try {
            reclamoLogic.updateReclamo(pojoEntity.getId(), data.get(1));
            //fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNumero(null);
            reclamoLogic.updateReclamo(pojoEntity.getId(), pojoEntity);
            // fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setNumero(10);
            pojoEntity.setMensaje(null);
            reclamoLogic.updateReclamo(pojoEntity.getId(), pojoEntity);
            //fail();
        } catch (BusinessLogicException e) {

        }
    }
    @Test
    public void deleteReclamoTest() {
        ReclamoEntity entity = data.get(0);
        reclamoLogic.deleteReclamo(entity.getId());
        ReclamoEntity deleted = em.find(ReclamoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    @Test
    public void getPSEsTest() {
        List<ReclamoEntity> list = reclamoLogic.getReclamos();
        Assert.assertEquals(data.size(), list.size());
        for (ReclamoEntity entity : list) {
            boolean found = false;
            for (ReclamoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getPSETest() {
        ReclamoEntity entity = data.get(0);
        ReclamoEntity resultEntity = reclamoLogic.getReclamo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNumero(), resultEntity.getNumero());
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }
}
