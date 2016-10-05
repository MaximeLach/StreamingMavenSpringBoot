/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    
//    @Before
//    public void Config(){
//        crud.deleteAll();
//        Personne p1 = new Personne();
//        p1.setNom("X1");
//        p1.setPrenom("Y1"); 
//        crud.save(p1);
//        
//        Personne p2 = new Personne();
//        p2.setNom("A1");
//        p2.setPrenom("B1"); 
//        crud.save(p2);
//    }
    
    //@Test
    public void PersonneCRUDTest(){
        List<Personne> personnes = crud.findAll();
        for(Personne p : personnes){
            System.out.println("Personne : " +p.getNom() +" " + p.getPrenom());
        }
        
    }
    
    @Test
    public void PersonneCRUDTestFindOneBy(){
        Assert.assertNotNull(crud.findOneByPrenomAndNom("Roman", "Polanski"));
    }
    
}
