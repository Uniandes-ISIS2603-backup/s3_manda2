/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.manda2.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.TarjetaCreditoPersistence;
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
public class TarjetaCreditoLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private TarjetaCreditoLogic tarjetaCreditoLogic;
    
     @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<TarjetaCreditoEntity> data = new ArrayList<TarjetaCreditoEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoLogic.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
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
        em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity entity = factory.manufacturePojo(TarjetaCreditoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear una tarjeta de credito
     *
     *
     */
    @Test
    public void createTarejtaCreditoTest() throws BusinessLogicException {
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
        TarjetaCreditoEntity result = tarjetaCreditoLogic.createTarjetaCredito(newEntity);
        Assert.assertNotNull(result);
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombreCliente(), entity.getNombreCliente());
        Assert.assertEquals(newEntity.getNumeroTarjeta(), entity.getNumeroTarjeta());
        try {
            tarjetaCreditoLogic.createTarjetaCredito(newEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            TarjetaCreditoEntity newEntity2 = factory.manufacturePojo(TarjetaCreditoEntity.class);
            newEntity2.setNombreCliente(null);
            tarjetaCreditoLogic.createTarjetaCredito(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            TarjetaCreditoEntity newEntity3 = factory.manufacturePojo(TarjetaCreditoEntity.class);
            newEntity3.setNumeroTarjeta( "123456789101112131415161718");
            TarjetaCreditoEntity result4 = tarjetaCreditoLogic.createTarjetaCredito(newEntity3);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para actualizar una tarjeta de credito
     *
     *
     */
    @Test
    public void updateTarjetaCreditoTest() throws BusinessLogicException {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity pojoEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

        pojoEntity.setId(entity.getId());

        tarjetaCreditoLogic.updateTarjetaCredito(pojoEntity.getId(), pojoEntity);

        TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombreCliente(), resp.getNombreCliente());
        Assert.assertEquals(pojoEntity.getNumeroTarjeta(), resp.getNumeroTarjeta());
        try {
            tarjetaCreditoLogic.updateTarjetaCredito(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNombreCliente(null);
            tarjetaCreditoLogic.updateTarjetaCredito(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setNombreCliente("Alberto");
            pojoEntity.setNumeroTarjeta("01234567890123456789");
            tarjetaCreditoLogic.updateTarjetaCredito(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para eliminar una tarjeta de credito
     *
     *
     */
    @Test
    public void deleteTarjetaCreditoTest() {
        TarjetaCreditoEntity entity = data.get(0);
        tarjetaCreditoLogic.deleteTarjetaCredito(entity.getId());
        TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para consultar la lista de tarjetas de credito
     *
     *
     */
    @Test
    public void getTarjetasCreditosTest() {
        List<TarjetaCreditoEntity> list = tarjetaCreditoLogic.getTarjetasCreditos();
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaCreditoEntity entity : list) {
            boolean found = false;
            for (TarjetaCreditoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una tarjeta de credito
     *
     *
     */
    @Test
    public void getTarjetaCreditoTest() {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity resultEntity = tarjetaCreditoLogic.getTarjetaCredito(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombreCliente(), resultEntity.getNombreCliente());
        Assert.assertEquals(entity.getNumeroTarjeta(), resultEntity.getNumeroTarjeta());
    }
}
