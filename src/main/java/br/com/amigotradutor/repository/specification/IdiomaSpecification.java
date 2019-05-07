package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.model.Idioma;

public class IdiomaSpecification {

	public static Specification<Idioma> filterByNomeAndSigla(String nome, String sigla){
		return (root, criteriaQuery, criteriaBuilder) ->{
			List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(nome)){
                predicates.add(criteriaBuilder.equal(root.get("nome"), nome));
            }
            
            if (ValidatorUtil.isNotEmpty(sigla)){
                predicates.add(criteriaBuilder.equal(root.get("sigla"), sigla));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}
	
}
