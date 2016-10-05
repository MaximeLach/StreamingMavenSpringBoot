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
import streaming.entity.Lien;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public interface LienServiceCRUD extends CrudRepository<Lien, Long>{
    public List<Lien> findAllByFilm(Film film);
    public List<Lien> findAllByEpisodeNumEpisodeAndSaisonNumSaisonAndSerie(Integer numEpisode, Integer NumSaison, Serie serie);
}
