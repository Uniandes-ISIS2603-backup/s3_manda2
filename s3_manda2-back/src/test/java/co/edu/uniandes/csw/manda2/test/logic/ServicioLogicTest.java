/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.ServicioLogic;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ServicioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
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
 * @author da.ramos
 */
@RunWith(Arquillian.class)
public class ServicioLogicTest {

    private final PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ServicioLogic servicioLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private final List<ServicioEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ServicioEntity.class.getPackage())
                .addPackage(ServicioLogic.class.getPackage())
                .addPackage(ServicioPersistence.class.getPackage())
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

    private void clearData() {
        em.createQuery("delete from ServicioEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ServicioEntity entity = factory.manufacturePojo(ServicioEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createServicioTest() {
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);
        newEntity.setEstado(ServicioEntity.EN_ESPERA);

        try {
            ServicioEntity result = servicioLogic.createServicio(newEntity);
            Assert.assertNotNull(result);

            ServicioEntity entity = em.find(ServicioEntity.class, result.getId());

            Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
            Assert.assertEquals(newEntity.getCosto(), entity.getCosto());
            Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
            Assert.assertEquals(newEntity.getPuntoDeEncuentro(), entity.getPuntoDeEncuentro());
            Assert.assertEquals(newEntity.getPuntoDeRealizacion(), entity.getPuntoDeRealizacion());
            Assert.assertEquals(newEntity.getEstado(), entity.getEstado());
            Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
            Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }

        //Prueba que el servicio no pueda ser agregado más de una vez.
        try {
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el nombre del servicio sea válido.
        try {
            newEntity.setNombre("");
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setNombre(null);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que la descripción del servicio sea válida.
        try {
            newEntity.setDescripcion("");
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setDescripcion(null);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el punto de encuentro del servicio sea válido.
        try {
            newEntity.setPuntoDeEncuentro("");
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setPuntoDeEncuentro(null);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el punto de realización del servicio sea válido.
        try {
            newEntity.setPuntoDeRealizacion("");
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setPuntoDeRealizacion(null);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el costo del servicio sea válido.
        try {
            newEntity.setCosto(null);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setCosto(0D);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el estado del servicio sea válido.
        try {
            newEntity.setEstado("A");
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setEstado(null);
            servicioLogic.createServicio(newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
                try{
            newEntity.setCalificacion(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        }catch(BusinessLogicException e){
        }
        try{
            newEntity.setCalificacion(-5D);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        }catch(BusinessLogicException e){
        }
    }

    @Test
    public void getServiciosTest() {
        List<ServicioEntity> list = servicioLogic.getServicios();
        Assert.assertEquals(data.size(), list.size());
        for (ServicioEntity entity : list) {
            boolean found = false;
            for (ServicioEntity entity2 : data) {
                if (entity.getId().equals(entity2.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getServiciotest() {
        ServicioEntity entity = data.get(0);
        ServicioEntity newEntity = servicioLogic.getServicio(entity.getId());

        Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
        Assert.assertEquals(newEntity.getCosto(), entity.getCosto());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getPuntoDeEncuentro(), entity.getPuntoDeEncuentro());
        Assert.assertEquals(newEntity.getPuntoDeRealizacion(), entity.getPuntoDeRealizacion());
        Assert.assertEquals(newEntity.getEstado(), entity.getEstado());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    @Test
    public void deleteServicioTest() {
        ServicioEntity entity = data.get(0);
        servicioLogic.deleteServicio(entity.getId());
        ServicioEntity deleted = em.find(ServicioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateServicioTest() {
        ServicioEntity entity = data.get(0);
        
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);
        newEntity.setEstado(ServicioEntity.EN_DESARROLLO);
        newEntity.setId(entity.getId());

        try {
            servicioLogic.updateServicio(newEntity.getId(), newEntity);

            ServicioEntity resp = em.find(ServicioEntity.class, entity.getId());

            Assert.assertEquals(newEntity.getCalificacion(), resp.getCalificacion());
            Assert.assertEquals(newEntity.getCosto(), resp.getCosto());
            Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
            Assert.assertEquals(newEntity.getPuntoDeEncuentro(), resp.getPuntoDeEncuentro());
            Assert.assertEquals(newEntity.getPuntoDeRealizacion(), resp.getPuntoDeRealizacion());
            Assert.assertEquals(newEntity.getEstado(), resp.getEstado());
            Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
            Assert.assertEquals(newEntity.getCalificacion(), resp.getCalificacion());

        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        //Prueba que el nombre del servicio sea válido.
        try {
            newEntity.setNombre("");
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setNombre(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que la descripción del servicio sea válida.
        try {
            newEntity.setDescripcion("");
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setDescripcion(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el punto de encuentro del servicio sea válido.
        try {
            newEntity.setPuntoDeEncuentro("");
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setPuntoDeEncuentro(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el punto de realización del servicio sea válido.
        try {
            newEntity.setPuntoDeRealizacion("");
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setPuntoDeRealizacion(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el costo del servicio sea válido.
        try {
            newEntity.setCosto(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setCosto(0D);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        //Prueba que el estado del servicio sea válido.
        try {
            newEntity.setEstado("A");
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try {
            newEntity.setEstado(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        } catch (BusinessLogicException e) {
        }
        try{
            newEntity.setCalificacion(null);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        }catch(BusinessLogicException e){
        }
        try{
            newEntity.setCalificacion(-5D);
            servicioLogic.updateServicio(newEntity.getId(), newEntity);
            Assert.fail();
        }catch(BusinessLogicException e){
        }
    }
}
