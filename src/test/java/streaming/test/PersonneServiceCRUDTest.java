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
import java.util.List;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;
import streaming.entity.Personne;
import streaming.service.PersonneServiceCRUD;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class PersonneServiceCRUDTest {
    
    @Autowired
    private PersonneServiceCRUD crud;
    
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
    
    //@Test
    public void PersonneCRUDTest(){
        List<Personne> personnes = crud.findAll();
        for(Personne p : personnes){
            System.out.println("Personne : " +p.getNom() +" " + p.getPrenom());
        }
        
    }
    //@Test
    public void PersonneCRUDTestFindOneBy(){
        Assert.assertNotNull(crud.findOneByPrenomAndNom("Roman", "Polanski"));
    }
    
}
