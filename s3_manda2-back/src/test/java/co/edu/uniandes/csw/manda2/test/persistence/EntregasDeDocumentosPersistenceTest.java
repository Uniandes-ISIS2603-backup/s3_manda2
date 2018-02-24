/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.persistence.EntregasDeDocumentosPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

/**
 *
 * @author dv.gonzalez10
 */
@RunWith(Arquillian.class)
public class EntregasDeDocumentosPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment (){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntregasDeDocumentosEntity.class.getPackage())
                .addPackage(EntregasDeDocumentosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Inject
    private EntregasDeDocumentosPersistence entregasDeDocumentosPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
}
