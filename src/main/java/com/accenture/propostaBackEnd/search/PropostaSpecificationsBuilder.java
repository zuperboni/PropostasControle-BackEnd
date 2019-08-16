package com.accenture.propostaBackEnd.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.accenture.propostaBackEnd.dominio.Proposta;
import com.accenture.propostaBackEnd.utils.SearchCriteria;
import com.accenture.propostaBackEnd.utils.SearchOperation;


public class PropostaSpecificationsBuilder {
 
    private List<SpecSearchCriteria> params;
 
    public PropostaSpecificationsBuilder() {
        params = new ArrayList<>();
    }
    
    public PropostaSpecificationsBuilder with(
      String key, String operation, Object value, String prefix, String suffix) {
     
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) {
                boolean startWithAsterisk = prefix.contains("*");
                boolean endWithAsterisk = suffix.contains("*");
 
                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SpecSearchCriteria(key, op, value));
        }
        return this;
    }
 
    public Specification<Proposta> build() {
        if (params.size() == 0) {
            return null;
        }
 
        Specification result = new PropostaSpecification(params.get(0));
      
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
              ? Specification.where(result).or(new PropostaSpecification(params.get(i))) 
              : Specification.where(result).and(new PropostaSpecification(params.get(i)));
        }
 
        return result;
    }
}