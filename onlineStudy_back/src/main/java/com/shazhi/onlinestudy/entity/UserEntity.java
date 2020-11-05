package com.shazhi.onlinestudy.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "online_study")
@Data
@Accessors(chain = true)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String userName;
    String password;

    @OneToMany(mappedBy = "user")
    private Collection<BulletScreenEntity> bulletScreens;

    @OneToMany(mappedBy = "user")
    private Collection<ClazzUserEntity> enrollClazzies;

    @OneToMany(mappedBy = "commenter")
    private Collection<CommentEntity> comments;

    @OneToMany(mappedBy = "user")
    private Collection<CurriculumEntity> curriculums;

    @OneToMany(mappedBy = "sendUser")
    private Collection<MessageEntity> sendMessages;

    @OneToMany(mappedBy = "targetUser")
    private Collection<MessageEntity> acceptMessages;

    @OneToMany(mappedBy = "user")
    private Collection<NoteEntity> notes;

    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<RoleEntity> roles;
}
