package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.util.ValidatorUtil;

public class AutorSpecification {

	public static Specification<Autor> filterByNome(String nome){
		return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(nome)){
                predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("nome")), nome.toUpperCase()));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
	}
	
}
