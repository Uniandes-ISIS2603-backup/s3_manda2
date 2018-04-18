/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.ClienteLogic;
import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ClientePersistence;
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
public class ClienteLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ClienteLogic clienteLogic;
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ClienteEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un cliente
     *
     *
     */
    @Test
    public void createClienteTest() throws BusinessLogicException {
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        ClienteEntity result = clienteLogic.createCliente(newEntity);
        Assert.assertNotNull(result);
        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        try {
            clienteLogic.createCliente(newEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            ClienteEntity newEntity2 = factory.manufacturePojo(ClienteEntity.class);
            newEntity2.setNombre(null);
            clienteLogic.createCliente(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            ClienteEntity newEntity3 = factory.manufacturePojo(ClienteEntity.class);
            newEntity3.setCedula(null);
            ClienteEntity result4 = clienteLogic.createCliente(newEntity3);
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
    public void updateClienteTest() throws BusinessLogicException {
        ClienteEntity entity = data.get(0);
        ClienteEntity pojoEntity = factory.manufacturePojo(ClienteEntity.class);

        pojoEntity.setId(entity.getId());

        clienteLogic.updateCliente(pojoEntity.getId(), pojoEntity);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
        try {
            clienteLogic.updateCliente(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNombre(null);
            clienteLogic.updateCliente(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setNombre("Alberto");
            pojoEntity.setCedula(null);
            clienteLogic.updateCliente(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            ClienteEntity pojoEntity2 = factory.manufacturePojo(ClienteEntity.class);
            pojoEntity2.setCedula(data.get(2).getCedula());
            clienteLogic.updateCliente(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para eliminar un cliente
     *
     *
     */
    @Test
    public void deleteClienteTest() {
        ClienteEntity entity = data.get(0);
        clienteLogic.deleteCliente(entity.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para consultar la lista de clientes
     *
     *
     */
    @Test
    public void getClientesTest() {
        List<ClienteEntity> list = clienteLogic.getClientes();
        Assert.assertEquals(data.size(), list.size());
        for (ClienteEntity entity : list) {
            boolean found = false;
            for (ClienteEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un cliente
     *
     *
     */
    @Test
    public void getClienteTest() {
        ClienteEntity entity = data.get(0);
        ClienteEntity resultEntity = clienteLogic.getCliente(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
        Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
    }
}
