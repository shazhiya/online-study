create table if not exists batch
(
    batch_id        int auto_increment
        primary key,
    batch_name      varchar(64) null,
    batch_startTime datetime    null,
    batch_endTime   datetime    null
);

create table if not exists comment_type
(
    commentType_id   int auto_increment
        primary key,
    commentType_name varchar(32) not null
)
    comment 'question,answer or common.';

create table if not exists filetype
(
    filetype_id          int auto_increment
        primary key,
    filetype_name        varchar(64)  null,
    filetype_description varchar(128) null
);

create table if not exists role
(
    role_id   int auto_increment
        primary key,
    role_name varchar(32) null
);

create table if not exists security
(
    security_id   int auto_increment
        primary key,
    security_name varchar(32) null
);

create table if not exists role_security
(
    role_id     int not null,
    security_id int not null,
    primary key (role_id, security_id),
    constraint role_security_role_role_id_fk
        foreign key (role_id) references role (role_id)
            on delete cascade,
    constraint role_security_security_security_id_fk
        foreign key (security_id) references security (security_id)
            on delete cascade
);

create table if not exists user
(
    user_id           int auto_increment
        primary key,
    password          varchar(32)                               not null,
    user_name         varchar(32)                               null,
    user_email        varchar(32)                               null,
    user_registerDate datetime                                  null,
    user_intro        varchar(64)                               null,
    user_telephone    varchar(32)                               null,
    user_enable       tinyint(1)  default 1                     null,
    user_headico      varchar(64) default 'headIco/default.jpg' null,
    constraint user_user_name_uindex
        unique (user_name)
);

create table if not exists curriculum
(
    curriculum_id          int auto_increment
        primary key,
    curriculum_name        varchar(64)  null,
    user_id                int          null comment 'teacher
',
    curriculum_description varchar(255) null,
    constraint curriculum_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on delete set null
);

create table if not exists chapter
(
    chapter_id          int auto_increment
        primary key,
    chapter_name        varchar(64)  null,
    chapter_code        varchar(32)  null,
    chapter_description varchar(128) null,
    curriculum_id       int          null,
    constraint chapter_curriculum_curriculum_id_fk
        foreign key (curriculum_id) references curriculum (curriculum_id)
            on delete cascade
);

create table if not exists clazz
(
    clazz_id          int auto_increment
        primary key,
    clazz_name        varchar(255) null,
    batch_id          int          null,
    curriculum_id     int          null,
    clazz_description int          null,
    constraint clazz_batch_batch_id_fk
        foreign key (batch_id) references batch (batch_id)
            on delete cascade,
    constraint clazz_curriculum_curriculum_id_fk
        foreign key (curriculum_id) references curriculum (curriculum_id)
            on delete cascade
)
    comment 'batch_curriculum';

create table if not exists clazz_user
(
    clazz_id int not null,
    user_id  int not null,
    primary key (clazz_id, user_id),
    constraint clazz_user_clazz_clazz_id_fk
        foreign key (clazz_id) references clazz (clazz_id)
            on delete cascade,
    constraint clazz_user_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on delete cascade
)
    comment 'class_student';

create table if not exists courseware
(
    courseware_id          int auto_increment
        primary key,
    courseware_description int         null,
    chapter_id             int         null,
    title                  varchar(64) null,
    filetype_id            int         null,
    constraint courseware_chapter_chapter_id_fk
        foreign key (chapter_id) references chapter (chapter_id)
            on delete cascade,
    constraint courseware_filetype_filetype_id_fk
        foreign key (filetype_id) references filetype (filetype_id)
            on delete cascade
);

create table if not exists bulletscreen
(
    bulletScreen_id         int auto_increment
        primary key,
    user_id                 int          null,
    courseware_id           int          null,
    bulletScreen_detail     json         not null,
    bulletScreen_launchTime datetime     not null,
    bulletScreen_content    varchar(255) not null,
    constraint bulletScreen_courseware_courseware_id_fk
        foreign key (courseware_id) references courseware (courseware_id)
            on delete cascade,
    constraint bulletScreen_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on delete cascade
);

create table if not exists comment
(
    comment_id      int auto_increment
        primary key,
    user_id         int          null,
    courseware_id   int          null,
    parent_id       int          null,
    comment_content varchar(255) not null,
    comment_detail  json         null,
    commentType_id  int          null,
    constraint comment_comment_comment_id_fk
        foreign key (parent_id) references comment (comment_id)
            on delete cascade,
    constraint comment_comment_type_commentType_id_fk
        foreign key (commentType_id) references comment_type (commentType_id)
            on delete cascade,
    constraint comment_courseware_courseware_id_fk
        foreign key (courseware_id) references courseware (courseware_id)
            on delete cascade,
    constraint comment_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on delete cascade
);

create table if not exists message
(
    message_id       int auto_increment
        primary key,
    target_id        int          not null comment 'user_id',
    send_id          int          null comment 'user_id',
    message_content  varchar(255) null,
    message_sendTime datetime     null,
    message_readTime datetime     null,
    constraint message_user_user_id_fk
        foreign key (target_id) references user (user_id)
            on delete cascade,
    constraint message_user_user_id_fk_2
        foreign key (send_id) references user (user_id)
);

create table if not exists note
(
    note_id          int auto_increment
        primary key,
    user_id          int          null,
    curriculum_id    int          null,
    note_content     varchar(255) null,
    note_writtenTime datetime     null,
    note_description json         null,
    constraint note_curriculum_curriculum_id_fk
        foreign key (curriculum_id) references curriculum (curriculum_id)
            on delete cascade,
    constraint note_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on delete cascade
);

create table if not exists progress
(
    clazz_id          int        not null,
    user_id           int        not null,
    courseware_id     int        not null,
    progress_finished tinyint(1) null,
    primary key (clazz_id, user_id, courseware_id),
    constraint progress_clazz_user_clazz_id_user_id_fk
        foreign key (clazz_id, user_id) references clazz_user (clazz_id, user_id)
            on delete cascade,
    constraint progress_courseware_courseware_id_fk
        foreign key (courseware_id) references courseware (courseware_id)
            on delete cascade
);

create table if not exists user_role
(
    user_id int not null,
    role_id int not null,
    constraint user_role_role_role_id_fk
        foreign key (role_id) references role (role_id)
            on delete cascade,
    constraint user_role_user_user_id_fk
        foreign key (user_id) references user (user_id)
            on delete cascade
);


