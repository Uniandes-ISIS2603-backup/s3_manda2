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
 * @author na.caceres
 */
@RunWith(Arquillian.class)
public class ElementoBusquedaReservaLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ElementoBusquedaReservaLogic elementosBusquedaLogic;
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
     * Prueba para crear un elementosBusqueda
     *
     *
     */
    @Test
    public void createElementoBusquedaReservaTest() throws BusinessLogicException {
        ElementoBusquedaReservaEntity newEntity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
        ElementoBusquedaReservaEntity result = elementosBusquedaLogic.createElementoBusquedaReserva(newEntity);
        Assert.assertNotNull(result);
        ElementoBusquedaReservaEntity entity = em.find(ElementoBusquedaReservaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
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

        elementosBusquedaLogic.updateElementoBusquedaReserva(pojoEntity.getId(), pojoEntity);

        ElementoBusquedaReservaEntity resp = em.find(ElementoBusquedaReservaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        try {
            elementosBusquedaLogic.updateElementoBusquedaReserva(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
      
    }

    /**
     * Prueba para eliminar un elementosBusqueda
     *
     *
     */
    @Test
    public void deleteElementoBusquedaReservaTest() {
        ElementoBusquedaReservaEntity entity = data.get(0);
        elementosBusquedaLogic.deleteElementoBusquedaReserva(entity.getId());
        ElementoBusquedaReservaEntity deleted = em.find(ElementoBusquedaReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para consultar la lista de elementosBusquedas
     *
     *
     */
    @Test
    public void getElementoBusquedaReservasTest() {
        List<ElementoBusquedaReservaEntity> list = elementosBusquedaLogic.getElementosBusquedasReservas();
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
     * Prueba para consultar un elementosBusqueda
     *
     *
     */
    @Test
    public void getElementoBusquedaReservaTest() {
        ElementoBusquedaReservaEntity entity = data.get(0);
        ElementoBusquedaReservaEntity resultEntity = elementosBusquedaLogic.getElementoBusquedaReserva(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
    }
}
