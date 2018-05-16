/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.PagoLogic;
import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.PagoPersistence;
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
public class PagoLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PagoLogic PagoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PagoEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PagoEntity.class.getPackage())
                .addPackage(PagoLogic.class.getPackage())
                .addPackage(PagoPersistence.class.getPackage())
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
        em.createQuery("delete from PagoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PagoEntity entity = factory.manufacturePojo(PagoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Pago
     *
     *
     */
    @Test
    public void createPagoTest() throws BusinessLogicException {
        PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
        PayPalEntity newPayPal = factory.manufacturePojo(PayPalEntity.class);
        //EntregasDeDocumentosEntity vuelta = factory.manufacturePojo(EntregasDeDocumentosEntity.class);
        newEntity.setPayPal(newPayPal);
        //newEntity.setEntregaDeDocumentos(vuelta);
        try {
            PagoEntity result = PagoLogic.createPago(newEntity);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getPayPal());
            PagoEntity entity = em.find(PagoEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getEstadoTransaccion(), entity.getEstadoTransaccion());
            Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            PagoEntity newEntity3 = factory.manufacturePojo(PagoEntity.class);
            newEntity3.setEstadoTransaccion(null);
            PagoEntity result4 = PagoLogic.createPago(newEntity3);
            fail();
        } catch (BusinessLogicException e) {

        }

        try {
            PagoEntity newEntity3 = factory.manufacturePojo(PagoEntity.class);
            newEntity3.setFecha(null);
            PagoEntity result4 = PagoLogic.createPago(newEntity3);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para actualizar un Pago
     *
     *
     */
    @Test
    public void updatePagoTest() throws BusinessLogicException {
        PagoEntity entity = data.get(0);

        PagoEntity pojoEntity = factory.manufacturePojo(PagoEntity.class);
        PayPalEntity paypalEntity = factory.manufacturePojo(PayPalEntity.class);
        VueltasConDemoraEnOficinaEntity vuelta = factory.manufacturePojo(VueltasConDemoraEnOficinaEntity.class);
        pojoEntity.setPayPal(paypalEntity);
        pojoEntity.setId(entity.getId());
        pojoEntity.setVueltaConDemoraEnOficina(vuelta);

        try {
            PagoLogic.updatePago(pojoEntity.getId(), pojoEntity);

            PagoEntity resp = em.find(PagoEntity.class, entity.getId());
            
            Assert.assertNotNull(resp.getPayPal());
            Assert.assertEquals(pojoEntity.getId(), resp.getId());
            Assert.assertEquals(pojoEntity.getEstadoTransaccion(), resp.getEstadoTransaccion());
        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
            fail();
        }
        try {
            PagoLogic.updatePago(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setEstadoTransaccion(null);
            pojoEntity.setFecha(null);
            PagoLogic.updatePago(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para eliminar un Pago
     *
     *
     */
    @Test
    public void deletePagoTest() {
        PagoEntity entity = data.get(0);
        PagoLogic.deletePago(entity.getId());
        PagoEntity deleted = em.find(PagoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para consultar la lista de Pagos
     *
     *
     */
    @Test
    public void getPagosTest() {
        List<PagoEntity> list = PagoLogic.getPagos();
        Assert.assertEquals(data.size(), list.size());
        for (PagoEntity entity : list) {
            boolean found = false;
            for (PagoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Pago
     *
     *
     */
    @Test
    public void getPagoTest() {
        PagoEntity entity = data.get(0);
        PagoEntity resultEntity = PagoLogic.getPago(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getEstadoTransaccion(), resultEntity.getEstadoTransaccion());
        Assert.assertEquals(entity.getFecha(), resultEntity.getFecha());
    }

}
