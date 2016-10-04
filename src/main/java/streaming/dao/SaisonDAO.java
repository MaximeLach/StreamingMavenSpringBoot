/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import org.springframework.data.repository.CrudRepository;
import streaming.entity.Saison;

/**
 *
 * @author ETY
 */
public interface SaisonDAO extends CrudRepository<Saison, Long>{
    
}
