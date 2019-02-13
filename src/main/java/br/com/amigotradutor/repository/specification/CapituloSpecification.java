/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.amigotradutor.repository.specification;

import br.com.amigotradutor.model.Capitulo;
import br.com.amigotradutor.util.ValidatorUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author taeko
 */
public class CapituloSpecification{

    public static Specification<Capitulo> filterByArtidoAndVolume(long artigo, long volume){
        return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(artigo)){
                predicates.add(criteriaBuilder.equal(root.get("artigo"), artigo));
            }
            
            if (ValidatorUtil.isNotEmpty(volume)){
                predicates.add(criteriaBuilder.equal(root.get("volume"), volume));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    
    }
    
}
