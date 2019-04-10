package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.util.ValidatorUtil;

public class ArtigoSpecification {
	 
	public static Specification<Artigo> filterByTituloAutorRevistaGeneros(String titulo, Long autor, Long revista, List<Long> generos){
        return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(titulo)){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("titulo")), titulo.toUpperCase()));
            }
            
            if (ValidatorUtil.isNotEmpty(autor)){
                predicates.add(criteriaBuilder.equal(root.get("autor"), autor));
            }
            
            if (ValidatorUtil.isNotEmpty(revista)){
                predicates.add(criteriaBuilder.equal(root.get("revista"), revista));
            }
            
            if (ValidatorUtil.isNotEmpty(generos)){
                predicates.add(root.join("generos").in(generos));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    
    }
	
}
