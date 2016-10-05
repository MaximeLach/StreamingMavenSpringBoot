/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;
import streaming.spring.SpringConfig;
import streaming.service.FilmServiceCRUD;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class FilmServiceCRUDTest {
    
    @Autowired
    private FilmServiceCRUD crud;
    
    @Before
    public void Config() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException{
        // Connexion DB
        Class driverClass = Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample", "app", "app");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        
        // Import
        FlatXmlDataSet dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream("donnees.xml"))));
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }
    
//    @Test
//    public void testSupprimerTout(){
//        dao.deleteAll();
//    }
    
    //1. Le film pour un titre donné
    //@Test
    public void Exercice1(){
        Assert.assertNotNull(crud.findOneByTitre("Fargo"));
    }
    
    //2. Les films pour une année donnée
    @Test
    public void Exercice2(){
        
    }
}
