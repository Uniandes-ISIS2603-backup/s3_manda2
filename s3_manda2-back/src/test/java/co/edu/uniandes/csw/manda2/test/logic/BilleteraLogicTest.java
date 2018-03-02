/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.BilleteraLogic;
import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
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
import static org.junit.Assert.fail;
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
public class BilleteraLogicTest {
    
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private BilleteraLogic BilleteraLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<BilleteraEntity> data = new ArrayList<BilleteraEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BilleteraEntity.class.getPackage())
                .addPackage(BilleteraLogic.class.getPackage())
                .addPackage(BilleteraPersistence.class.getPackage())
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
        em.createQuery("delete from BilleteraEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            BilleteraEntity entity = factory.manufacturePojo(BilleteraEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Billetera
     *
     *
     */
    @Test
    public void createBilleteraTest() throws BusinessLogicException {
        BilleteraEntity newEntity = factory.manufacturePojo(BilleteraEntity.class);
        BilleteraEntity result = BilleteraLogic.createBilletera(newEntity);
        Assert.assertNotNull(result);
        BilleteraEntity entity = em.find(BilleteraEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCliente().getCedula(), entity.getCliente().getCedula());
        Assert.assertEquals(newEntity.getSaldo(), entity.getSaldo());
        try {
            BilleteraLogic.createBilletera(newEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            BilleteraEntity newEntity2 = factory.manufacturePojo(BilleteraEntity.class);
            newEntity2.getCliente().setCedula(null);
            BilleteraLogic.createBilletera(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            BilleteraEntity newEntity3 = factory.manufacturePojo(BilleteraEntity.class);
            newEntity3.setSaldo(0);
            BilleteraEntity result4 = BilleteraLogic.createBilletera(newEntity3);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para actualizar un Billetera
     *
     *
     */
    @Test
    public void updateBilleteraTest() throws BusinessLogicException {
        BilleteraEntity entity = data.get(0);
        BilleteraEntity pojoEntity = factory.manufacturePojo(BilleteraEntity.class);

        pojoEntity.setId(entity.getId());

        BilleteraLogic.updateBilletera(pojoEntity.getId(), pojoEntity);

        BilleteraEntity resp = em.find(BilleteraEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getCliente().getCedula(), resp.getCliente().getCedula());
        Assert.assertEquals(pojoEntity.getSaldo(), resp.getSaldo());
        try {
            BilleteraLogic.updateBilletera(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.getCliente().setCedula(null);
            BilleteraLogic.updateBilletera(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.getCliente().setCedula("111111");
            pojoEntity.setSaldo(0);
            BilleteraLogic.updateBilletera(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para eliminar un Billetera
     *
     *
     */
    @Test
    public void deleteBilleteraTest() {
        BilleteraEntity entity = data.get(0);
        BilleteraLogic.deleteBilletera(entity.getId());
        BilleteraEntity deleted = em.find(BilleteraEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para consultar la lista de Billeteras
     *
     *
     */
    @Test
    public void getBilleterasTest() {
        List<BilleteraEntity> list = BilleteraLogic.getBilleteras();
        Assert.assertEquals(data.size(), list.size());
        for (BilleteraEntity entity : list) {
            boolean found = false;
            for (BilleteraEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Billetera
     *
     *
     */
    @Test
    public void getBilleteraTest() {
        BilleteraEntity entity = data.get(0);
        BilleteraEntity resultEntity = BilleteraLogic.getBilletera(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getCliente().getCedula(), resultEntity.getCliente().getCedula());
        Assert.assertEquals(entity.getSaldo(), resultEntity.getSaldo());
    }
}
