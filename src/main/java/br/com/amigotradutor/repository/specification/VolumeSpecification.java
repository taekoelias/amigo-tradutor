package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.model.Volume;

/**
 *
 * @author taeko
 */
public class VolumeSpecification{

    public static Specification<Volume> filterByArtidoVolumeNumeroTituloPublicacao(String numero, String titulo, Long artigo){
    	
        return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(artigo)){
                predicates.add(criteriaBuilder.equal(root.get("artigo"), artigo));
            }
            
            if (ValidatorUtil.isNotEmpty(numero)){
                predicates.add(criteriaBuilder.equal(root.get("numero"), numero));
            }
            
            if (ValidatorUtil.isNotEmpty(titulo)){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("titulo")), "%"+titulo.toUpperCase()+"%"));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    
    }
    
}
