/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import streaming.spring.SpringConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author ETY
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class FilmDAOTest {
    
    @Autowired
    private FilmDAO dao;
    
    @Before
    @Transactional
    public void avant (){
        //supprime tout les films
        dao.deleteAll();
        
        //ajoute 2 film
        dao.save(new Film(1L, "La communauté de l'anneau", "Bilbon prend sa retraite, Frodon doit partir ...", 2008, 210));
        dao.save(new Film(2L, "Les deux tours", "Frodon par avec Sam, la communauté est séparée ...", 2009, 180));
        dao.save(new Film(3L, "Le retour du roi", "Les terres du milieux ce réveillent, Sauron est en mauvaise posture ...", 2010, 270));
    }
    
    @Test
    public void testTroisFilms(){
        Film one = dao.findOne(1L);
        Film two = dao.findOne(2L);
        Film three = dao.findOne(3L);
        
        Assert.assertEquals("La communauté de l'anneau", one.getTitre());
        Assert.assertEquals("Les deux tours", two.getTitre());
        Assert.assertEquals("Le retour du roi", three.getTitre());
    }
    
}
