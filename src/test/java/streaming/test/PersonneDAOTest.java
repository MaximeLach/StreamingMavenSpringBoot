/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.dao.PersonneDAO;
import streaming.entity.Personne;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class PersonneDAOTest {
    
    @Autowired
    private PersonneDAO dao;
    
    @Test
    public void PersonneDAOTest(){
        Personne p1 = new Personne();
        p1.setNom("X");
        p1.setPrenom("Y"); 
        dao.ajouterPersonne(p1);
        
        Personne p2 = new Personne();
        p2.setNom("A");
        p2.setPrenom("B"); 
        dao.ajouterPersonne(p2);
        
        List<Personne> personnes = dao.listerPersonnes();
        for(Personne p : personnes){
            System.out.println("Personne : " +p.getNom() +" " + p.getPrenom());
        }
    }
}
