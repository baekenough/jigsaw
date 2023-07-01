package com.cliff.jigsaw.model.profile;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfileComment is a Querydsl query type for ProfileComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfileComment extends EntityPathBase<ProfileComment> {

    private static final long serialVersionUID = -868534894L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfileComment profileComment = new QProfileComment("profileComment");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createDtm = createDateTime("createDtm", java.time.LocalDateTime.class);

    public final NumberPath<Long> profileCommentNid = createNumber("profileCommentNid", Long.class);

    public final NumberPath<Long> profileNid = createNumber("profileNid", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateDtm = createDateTime("updateDtm", java.time.LocalDateTime.class);

    public final QUserProfile userProfileNid;

    public QProfileComment(String variable) {
        this(ProfileComment.class, forVariable(variable), INITS);
    }

    public QProfileComment(Path<? extends ProfileComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfileComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfileComment(PathMetadata metadata, PathInits inits) {
        this(ProfileComment.class, metadata, inits);
    }

    public QProfileComment(Class<? extends ProfileComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userProfileNid = inits.isInitialized("userProfileNid") ? new QUserProfile(forProperty("userProfileNid")) : null;
    }

}

