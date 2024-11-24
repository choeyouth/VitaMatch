package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodCombination is a Querydsl query type for GoodCombination
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodCombination extends EntityPathBase<GoodCombination> {

    private static final long serialVersionUID = -1007942912L;

    public static final QGoodCombination goodCombination = new QGoodCombination("goodCombination");

    public final StringPath good = createString("good");

    public final StringPath ingredient_seq = createString("ingredient_seq");

    public final StringPath link = createString("link");

    public final StringPath reason = createString("reason");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QGoodCombination(String variable) {
        super(GoodCombination.class, forVariable(variable));
    }

    public QGoodCombination(Path<? extends GoodCombination> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodCombination(PathMetadata metadata) {
        super(GoodCombination.class, metadata);
    }

}

