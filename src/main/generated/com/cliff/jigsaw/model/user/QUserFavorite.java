package com.cliff.jigsaw.model.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserFavorite is a Querydsl query type for UserFavorite
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFavorite extends EntityPathBase<UserFavorite> {

    private static final long serialVersionUID = 781826931L;

    public static final QUserFavorite userFavorite = new QUserFavorite("userFavorite");

    public final NumberPath<Long> userFavoriteNid = createNumber("userFavoriteNid", Long.class);

    public QUserFavorite(String variable) {
        super(UserFavorite.class, forVariable(variable));
    }

    public QUserFavorite(Path<? extends UserFavorite> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserFavorite(PathMetadata metadata) {
        super(UserFavorite.class, metadata);
    }

}

