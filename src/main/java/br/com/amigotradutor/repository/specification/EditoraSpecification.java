package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.model.Editora;
import br.com.amigotradutor.util.ValidatorUtil;

public class EditoraSpecification {

	public static Specification<Editora> filterByNome(String nome){
		return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(nome)){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%"+nome.toUpperCase()+"%"));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
	}
	
}
