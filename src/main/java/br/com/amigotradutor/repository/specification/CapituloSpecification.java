package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.model.Capitulo;

/**
 *
 * @author taeko
 */
public class CapituloSpecification{

    public static Specification<Capitulo> filterByArtidoVolumeNumeroTituloPublicacao(Long artigo, Long volume, 
    		String numero, String titulo, Date publicacao){
    	
        return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(artigo)){
                predicates.add(criteriaBuilder.equal(root.get("artigo"), artigo));
            }
            
            if (ValidatorUtil.isNotEmpty(volume)){
                predicates.add(criteriaBuilder.equal(root.get("volume"), volume));
            }
            
            if (ValidatorUtil.isNotEmpty(numero)){
                predicates.add(criteriaBuilder.equal(root.get("numero"), numero));
            }
            
            if (ValidatorUtil.isNotEmpty(titulo)){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("tituloOriginal")), "%"+titulo.toUpperCase()+"%"));
            }
            
            if (ValidatorUtil.isNotEmpty(publicacao)){
                predicates.add(criteriaBuilder.equal(root.get("publicacao"), publicacao));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    
    }
    
}
