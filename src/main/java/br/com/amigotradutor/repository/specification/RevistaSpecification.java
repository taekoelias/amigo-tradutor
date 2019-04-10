package br.com.amigotradutor.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.util.ValidatorUtil;

public class RevistaSpecification {

	public static Specification<Revista> filterByNomeEditoraPeriodicidadePublicos(String nome, Long editora, Long periodicidade, List<Long> publicos){
        return (root, criteriaQuery, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (ValidatorUtil.isNotEmpty(nome)){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), nome.toUpperCase()));
            }
            
            if (ValidatorUtil.isNotEmpty(editora)){
                predicates.add(criteriaBuilder.equal(root.get("editora"), editora));
            }
            
            if (ValidatorUtil.isNotEmpty(periodicidade)){
                predicates.add(criteriaBuilder.equal(root.get("periodicidade"), periodicidade));
            }
            
            if (ValidatorUtil.isNotEmpty(publicos)){
                predicates.add(root.join("publicos").in(publicos));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    
    }
	
}
