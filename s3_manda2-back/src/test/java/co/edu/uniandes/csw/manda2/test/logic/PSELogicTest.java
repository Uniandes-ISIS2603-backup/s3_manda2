/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.PSELogic;
import co.edu.uniandes.csw.manda2.entities.PSEEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.PSEPersistence;
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
public class PSELogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PSELogic PSELogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PSEEntity> data = new ArrayList<PSEEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PSEEntity.class.getPackage())
                .addPackage(PSELogic.class.getPackage())
                .addPackage(PSEPersistence.class.getPackage())
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
        em.createQuery("delete from PSEEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PSEEntity entity = factory.manufacturePojo(PSEEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un PSE
     *
     *
     */
    @Test
    public void createPSETest() throws BusinessLogicException {
        PSEEntity newEntity = factory.manufacturePojo(PSEEntity.class);
        PSEEntity result = PSELogic.createPSE(newEntity);
        Assert.assertNotNull(result);
        PSEEntity entity = em.find(PSEEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombreCliente(), entity.getNombreCliente());
        Assert.assertEquals(newEntity.getLinkPse(), entity.getLinkPse());
        try {
            PSELogic.createPSE(newEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            PSEEntity newEntity2 = factory.manufacturePojo(PSEEntity.class);
            newEntity2.setNombreCliente(null);
            PSELogic.createPSE(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            PSEEntity newEntity3 = factory.manufacturePojo(PSEEntity.class);
            newEntity3.setLinkPse(null);
            PSEEntity result4 = PSELogic.createPSE(newEntity3);
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
    public void updatePSETest() throws BusinessLogicException {
        PSEEntity entity = data.get(0);
        PSEEntity pojoEntity = factory.manufacturePojo(PSEEntity.class);

        pojoEntity.setId(entity.getId());

        PSELogic.updatePSE(pojoEntity.getId(), pojoEntity);

        PSEEntity resp = em.find(PSEEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombreCliente(), resp.getNombreCliente());
        Assert.assertEquals(pojoEntity.getLinkPse(), resp.getLinkPse());
        try {
            PSELogic.updatePSE(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNombreCliente(null);
            PSELogic.updatePSE(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setNombreCliente("Alberto");
            pojoEntity.setLinkPse(null);
            PSELogic.updatePSE(pojoEntity.getId(), pojoEntity);
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
    public void deletePSETest() {
        PSEEntity entity = data.get(0);
        PSELogic.deletePSE(entity.getId());
        PSEEntity deleted = em.find(PSEEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para consultar la lista de Pses
     *
     *
     */
    @Test
    public void getPSEsTest() {
        List<PSEEntity> list = PSELogic.getPSEs();
        Assert.assertEquals(data.size(), list.size());
        for (PSEEntity entity : list) {
            boolean found = false;
            for (PSEEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un PSE
     *
     *
     */
    @Test
    public void getPSETest() {
        PSEEntity entity = data.get(0);
        PSEEntity resultEntity = PSELogic.getPSE(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombreCliente(), resultEntity.getNombreCliente());
        Assert.assertEquals(entity.getLinkPse(), resultEntity.getLinkPse());
    }
}
