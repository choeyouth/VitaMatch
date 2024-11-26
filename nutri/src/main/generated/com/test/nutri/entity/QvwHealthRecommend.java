package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QvwHealthRecommend is a Querydsl query type for vwHealthRecommend
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QvwHealthRecommend extends EntityPathBase<vwHealthRecommend> {

    private static final long serialVersionUID = -1764689267L;

    public static final QvwHealthRecommend vwHealthRecommend = new QvwHealthRecommend("vwHealthRecommend");

    public final StringPath functionalContent = createString("functionalContent");

    public final NumberPath<Integer> healthSeq = createNumber("healthSeq", Integer.class);

    public final StringPath ingredientName = createString("ingredientName");

    public final NumberPath<Integer> ingredientSeq = createNumber("ingredientSeq", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QvwHealthRecommend(String variable) {
        super(vwHealthRecommend.class, forVariable(variable));
    }

    public QvwHealthRecommend(Path<? extends vwHealthRecommend> path) {
        super(path.getType(), path.getMetadata());
    }

    public QvwHealthRecommend(PathMetadata metadata) {
        super(vwHealthRecommend.class, metadata);
    }

}

