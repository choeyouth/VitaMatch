package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QvwOrganRecommend is a Querydsl query type for vwOrganRecommend
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QvwOrganRecommend extends EntityPathBase<vwOrganRecommend> {

    private static final long serialVersionUID = -1807864002L;

    public static final QvwOrganRecommend vwOrganRecommend = new QvwOrganRecommend("vwOrganRecommend");

    public final StringPath functionalContent = createString("functionalContent");

    public final StringPath ingredientName = createString("ingredientName");

    public final NumberPath<Integer> ingredientSeq = createNumber("ingredientSeq", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> organSeq = createNumber("organSeq", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QvwOrganRecommend(String variable) {
        super(vwOrganRecommend.class, forVariable(variable));
    }

    public QvwOrganRecommend(Path<? extends vwOrganRecommend> path) {
        super(path.getType(), path.getMetadata());
    }

    public QvwOrganRecommend(PathMetadata metadata) {
        super(vwOrganRecommend.class, metadata);
    }

}

