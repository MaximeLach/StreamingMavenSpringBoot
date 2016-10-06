/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Episode;
import streaming.entity.Saison;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public interface EpisodeServiceCRUD extends CrudRepository<Episode, Long>{
    public List<Episode> findAllBySaisonNumSaisonAndSaisonSerieIdOrderByNumEpisode(Integer numSaison, Long serieId);
}
