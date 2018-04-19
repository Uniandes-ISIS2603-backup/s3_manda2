/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.ElementoBusquedaReservaLogic;
import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ElementoBusquedaReservaPersistence;
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
 * @author cv.trujillo
 */
@RunWith(Arquillian.class)
public class ElementoBusquedaReservaLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ElementoBusquedaReservaLogic ElementoBusquedaReservaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ElementoBusquedaReservaEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ElementoBusquedaReservaEntity.class.getPackage())
                .addPackage(ElementoBusquedaReservaLogic.class.getPackage())
                .addPackage(ElementoBusquedaReservaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
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
        em.createQuery("delete from ElementoBusquedaReservaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ElementoBusquedaReservaEntity entity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un ElementoBusquedaReserva
     *
     *
     */
    @Test
    public void createElementoBusquedaReservaTest() throws BusinessLogicException {
        ElementoBusquedaReservaEntity newEntity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
        ElementoBusquedaReservaEntity result = ElementoBusquedaReservaLogic.createElementoBusquedaReserva(newEntity);
        Assert.assertNotNull(result);
        ElementoBusquedaReservaEntity entity = em.find(ElementoBusquedaReservaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombreElementoBusquedaReserva(), entity.getNombreElementoBusquedaReserva());
        try {
            ElementoBusquedaReservaLogic.createElementoBusquedaReserva(newEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            ElementoBusquedaReservaEntity newEntity2 = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
            newEntity2.setNombreBusquedaReserva(null);
            ElementoBusquedaReservaLogic.createElementoBusquedaReserva(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
       
    }

    /**
     * Prueba para actualizar un Pse
     *
     *
     */
    @Test
    public void updateElementoBusquedaReservaTest() throws BusinessLogicException {
        ElementoBusquedaReservaEntity entity = data.get(0);
        ElementoBusquedaReservaEntity pojoEntity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);

        pojoEntity.setId(entity.getId());

        ElementoBusquedaReservaLogic.updateElementoBusquedaReserva(pojoEntity.getId(), pojoEntity);

        ElementoBusquedaReservaEntity resp = em.find(ElementoBusquedaReservaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombreElementoBusquedaReserva(), resp.getNombreElementoBusquedaReserva());
        try {
            ElementoBusquedaReservaLogic.updateElementoBusquedaReserva(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNombreBusquedaReserva(null);
            ElementoBusquedaReservaLogic.updateElementoBusquedaReserva(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
      
    }

    /**
     * Prueba para eliminar un Pse
     *
     *
     */
    @Test
    public void deleteElementoBusquedaReservaTest() {
        ElementoBusquedaReservaEntity entity = data.get(0);
        ElementoBusquedaReservaLogic.deleteElementoBusquedaReserva(entity.getId());
        ElementoBusquedaReservaEntity deleted = em.find(ElementoBusquedaReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para consultar la lista de Pses
     *
     *
     */
    @Test
    public void getElementoBusquedaReservasTest() {
        List<ElementoBusquedaReservaEntity> list = ElementoBusquedaReservaLogic.getElementoBusquedaReservas();
        Assert.assertEquals(data.size(), list.size());
        for (ElementoBusquedaReservaEntity entity : list) {
            boolean found = false;
            for (ElementoBusquedaReservaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un ElementoBusquedaReserva
     *
     *
     */
    @Test
    public void getElementoBusquedaReservaTest() {
        ElementoBusquedaReservaEntity entity = data.get(0);
        ElementoBusquedaReservaEntity resultEntity = ElementoBusquedaReservaLogic.getElementoBusquedaReserva(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombreElementoBusquedaReserva(), resultEntity.getNombreElementoBusquedaReserva());
    }
}
