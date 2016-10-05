/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.entity.Lien;
import streaming.entity.Pays;
import streaming.entity.Personne;
import streaming.entity.Saison;

/**
 *
 * @author admin
 */
public interface FilmServiceCRUD extends CrudRepository<Film, Long>{
    public Film findOneByTitre(String titre);
    public List<Film> findAllByAnnee(Integer annee);
    public List<Film> findAllByTitreOrAnnee(String titre, Integer annee);
    public List<Film> findAllByTitreAndAnnee(String titre, Integer annee);
    public List<Film> findAllByGenreId(Long genreId);
    public List<Film> findAllByPaysId(Long paysId);
    public List<Film> findAllByGenreIdAndPaysId(Long genreId, Long paysId);
    public List<Film> findAllByActeursPrenomAndActeursNom(String prenom, String nom);
    public Long countAllByActeurs(Personne acteur);
    public List<Film> findAllByRealisateursOrderByTitreAsc(Personne realisateur);
    public Long countAllByRealisateurs(Personne realisateur); 
    public List<Film> findAllByPaysAndGenreAndRealisateursAndActeurs(Pays pays,Genre genre,Personne Realisateur,Personne Acteur);
    
    
}
