/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.EmpleadoPersistence;
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
public class EmpleadoLogicTest {
      private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private EmpleadoLogic logic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EmpleadoEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EmpleadoEntity.class.getPackage())
                .addPackage(EmpleadoLogic.class.getPackage())
                .addPackage(EmpleadoPersistence.class.getPackage())
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
            EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    @Test
    public void createReclamoTest() throws BusinessLogicException {
        EmpleadoEntity newEntity = factory.manufacturePojo(EmpleadoEntity.class);
        System.out.println("AAAA");
        EmpleadoEntity result = logic.createEmpleado(newEntity);
        System.out.println("BBBB");
        Assert.assertNotNull(result);
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        try {
           logic.createEmpleado(newEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            EmpleadoEntity newEntity2 = factory.manufacturePojo(EmpleadoEntity.class);
            newEntity2.setNombre(null);
            logic.createEmpleado(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            EmpleadoEntity newEntity3 = factory.manufacturePojo(EmpleadoEntity.class);
            newEntity3.setCedula(null);
            EmpleadoEntity result4 = logic.createEmpleado(newEntity3);
            fail();
        } catch (BusinessLogicException e) {

        }
    }
    @Test
    public void updateEmpleadoTest() throws BusinessLogicException {
        EmpleadoEntity entity = data.get(0);
        EmpleadoEntity pojoEntity = factory.manufacturePojo(EmpleadoEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateEmpleado(pojoEntity.getId(), pojoEntity);

        EmpleadoEntity resp = em.find(EmpleadoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        try {
            logic.updateEmpleado(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNombre(null);
            logic.updateEmpleado(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setNombre("Alberto");
            pojoEntity.setCedula(null);
            logic.updateEmpleado(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
    }
    @Test
    public void deleteReclamoTest() {
        EmpleadoEntity entity = data.get(0);
        logic.deleteEmpleado(entity.getId());
        EmpleadoEntity deleted = em.find(EmpleadoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    @Test
    public void getEmpleadosTest() {
        List<EmpleadoEntity> list = logic.getEmpleados();
        Assert.assertEquals(data.size(), list.size());
        for (EmpleadoEntity entity : list) {
            boolean found = false;
            for (EmpleadoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getEmpleadoTest() {
        EmpleadoEntity entity = data.get(0);
        EmpleadoEntity resultEntity = logic.getEmpleado(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }
}
