/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.EntregasDeDocumentosLogic;
import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.persistence.EntregasDeDocumentosPersistence;
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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author dv.gonzalez10
 */
@RunWith(Arquillian.class)
public class EntregasDeDocumentosLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private EntregasDeDocumentosLogic entregasDeDocumentosLogic;
     
    @PersistenceContext
    private EntityManager em;
     
    @Inject
    private UserTransaction utx;
     
    private List<EntregasDeDocumentosEntity> data = new ArrayList<EntregasDeDocumentosEntity>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntregasDeDocumentosEntity.class.getPackage())
                .addPackage(EntregasDeDocumentosLogic.class.getPackage())
                .addPackage(EntregasDeDocumentosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
}
