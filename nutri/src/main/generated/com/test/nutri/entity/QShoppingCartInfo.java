package com.test.nutri.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QShoppingCartInfo is a Querydsl query type for ShoppingCartInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShoppingCartInfo extends EntityPathBase<ShoppingCartInfo> {

    private static final long serialVersionUID = -1109209592L;

    public static final QShoppingCartInfo shoppingCartInfo = new QShoppingCartInfo("shoppingCartInfo");

    public final StringPath CompanyName = createString("CompanyName");

    public final StringPath price = createString("price");

    public final StringPath productImage = createString("productImage");

    public final StringPath productName = createString("productName");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QShoppingCartInfo(String variable) {
        super(ShoppingCartInfo.class, forVariable(variable));
    }

    public QShoppingCartInfo(Path<? extends ShoppingCartInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShoppingCartInfo(PathMetadata metadata) {
        super(ShoppingCartInfo.class, metadata);
    }

}

