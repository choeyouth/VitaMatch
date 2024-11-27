package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QvwGenderAgeRecommend is a Querydsl query type for vwGenderAgeRecommend
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QvwGenderAgeRecommend extends EntityPathBase<vwGenderAgeRecommend> {

    private static final long serialVersionUID = 603938801L;

    public static final QvwGenderAgeRecommend vwGenderAgeRecommend = new QvwGenderAgeRecommend("vwGenderAgeRecommend");

    public final StringPath age = createString("age");

    public final StringPath functionalContent = createString("functionalContent");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> genderAgeSeq = createNumber("genderAgeSeq", Integer.class);

    public final StringPath ingredientName = createString("ingredientName");

    public final NumberPath<Integer> ingredientSeq = createNumber("ingredientSeq", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QvwGenderAgeRecommend(String variable) {
        super(vwGenderAgeRecommend.class, forVariable(variable));
    }

    public QvwGenderAgeRecommend(Path<? extends vwGenderAgeRecommend> path) {
        super(path.getType(), path.getMetadata());
    }

    public QvwGenderAgeRecommend(PathMetadata metadata) {
        super(vwGenderAgeRecommend.class, metadata);
    }

}

