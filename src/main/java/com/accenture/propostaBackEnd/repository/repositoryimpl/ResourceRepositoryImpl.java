package com.accenture.propostaBackEnd.repository.repositoryimpl;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.accenture.propostaBackEnd.repository.ResourceRepository;

import io.jsonwebtoken.lang.Assert;

public class ResourceRepositoryImpl<T, I extends Serializable> extends SimpleMongoRepository<T, I> implements ResourceRepository<T, I> {

    private MongoOperations mongoOperations;
    private MongoEntityInformation entityInformation;

    public ResourceRepositoryImpl(final MongoEntityInformation entityInformation, final MongoOperations mongoOperations) {
        super(entityInformation, mongoOperations);

        this.entityInformation = entityInformation;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Page<T> findAll(final Query query, final Pageable pageable) {
        Assert.notNull(query, "A consulta não pode ser nula!");

        return new PageImpl<T>(
                mongoOperations.find(query.with(pageable), entityInformation.getJavaType(), entityInformation.getCollectionName()),
                pageable,
                mongoOperations.count(query, entityInformation.getJavaType(), entityInformation.getCollectionName())
        );
    }
}