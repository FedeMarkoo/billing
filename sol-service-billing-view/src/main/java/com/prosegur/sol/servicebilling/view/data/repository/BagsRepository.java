package com.prosegur.sol.servicebilling.view.data.repository;

import com.prosegur.data.repository.SimpleRepository;
import com.prosegur.sol.servicebilling.view.data.model.Bags;
import com.prosegur.sol.servicebilling.view.data.model.QBags;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BagsRepository extends SimpleRepository<Bags>, QuerydslPredicateExecutor<Bags> {

    default long countBags(final String documentId) {
        final QBags bags = QBags.bags;
        final BooleanExpression expression = bags.documentId.eq(documentId)
                .and(
                        bags.seal.isNotNull().or(bags.pouch.isNotNull())
                );
        return this.count(expression);
    }

}
