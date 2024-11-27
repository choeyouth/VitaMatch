package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QvwDailyRecommend is a Querydsl query type for vwDailyRecommend
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QvwDailyRecommend extends EntityPathBase<vwDailyRecommend> {

    private static final long serialVersionUID = -43914186L;

    public static final QvwDailyRecommend vwDailyRecommend = new QvwDailyRecommend("vwDailyRecommend");

    public final NumberPath<Integer> dailySeq = createNumber("dailySeq", Integer.class);

    public final StringPath functionalContent = createString("functionalContent");

    public final StringPath ingredientName = createString("ingredientName");

    public final NumberPath<Integer> ingredientSeq = createNumber("ingredientSeq", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QvwDailyRecommend(String variable) {
        super(vwDailyRecommend.class, forVariable(variable));
    }

    public QvwDailyRecommend(Path<? extends vwDailyRecommend> path) {
        super(path.getType(), path.getMetadata());
    }

    public QvwDailyRecommend(PathMetadata metadata) {
        super(vwDailyRecommend.class, metadata);
    }

}

