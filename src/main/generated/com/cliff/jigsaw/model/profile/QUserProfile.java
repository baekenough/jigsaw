package com.cliff.jigsaw.model.profile;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserProfile is a Querydsl query type for UserProfile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserProfile extends EntityPathBase<UserProfile> {

    private static final long serialVersionUID = 1696835522L;

    public static final QUserProfile userProfile = new QUserProfile("userProfile");

    public final StringPath introduce = createString("introduce");

    public final StringPath job = createString("job");

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath profileImage = createString("profileImage");

    public final StringPath projectField = createString("projectField");

    public final StringPath projectType = createString("projectType");

    public final StringPath skill = createString("skill");

    public final NumberPath<Long> userNid = createNumber("userNid", Long.class);

    public final NumberPath<Long> userProfileNid = createNumber("userProfileNid", Long.class);

    public QUserProfile(String variable) {
        super(UserProfile.class, forVariable(variable));
    }

    public QUserProfile(Path<? extends UserProfile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserProfile(PathMetadata metadata) {
        super(UserProfile.class, metadata);
    }

}

