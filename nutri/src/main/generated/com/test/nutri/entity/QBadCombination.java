package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBadCombination is a Querydsl query type for BadCombination
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBadCombination extends EntityPathBase<BadCombination> {

    private static final long serialVersionUID = 487766684L;

    public static final QBadCombination badCombination = new QBadCombination("badCombination");

    public final StringPath bad = createString("bad");

    public final StringPath ingredient_seq = createString("ingredient_seq");

    public final StringPath link = createString("link");

    public final StringPath reason = createString("reason");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QBadCombination(String variable) {
        super(BadCombination.class, forVariable(variable));
    }

    public QBadCombination(Path<? extends BadCombination> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBadCombination(PathMetadata metadata) {
        super(BadCombination.class, metadata);
    }

}

