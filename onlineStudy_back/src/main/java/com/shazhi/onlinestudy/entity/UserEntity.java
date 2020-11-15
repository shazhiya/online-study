package com.shazhi.onlinestudy.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user", schema = "online_study")
@Data
@Accessors(chain = true)
@SelectBeforeUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String userName;
    String password;
    String userEmail;
    @Column(columnDefinition = "123")
    String userHeadico;
    @CreationTimestamp
    Date userRegisterdate;
    String userIntro;
    String userTelephone;
    @ColumnDefault("true")
    Boolean userEnable;

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
    private List<RoleEntity> roles;

    public static UserEntity ignoreAttr(UserEntity user){
        return new UserEntity()
                .setUserId(user.getUserId())
                .setUserName(user.getUserName())
                .setPassword(user.getPassword())
                .setUserEnable(user.getUserEnable())
                .setUserEmail(user.getUserEmail())
                .setUserIntro(user.getUserIntro())
                .setUserRegisterdate(user.getUserRegisterdate())
                .setUserTelephone(user.getUserTelephone())
                .setUserHeadico(user.getUserHeadico())
                .setRoles(user.getRoles()
                        .stream().map(role->new RoleEntity().setRoleId(role.getRoleId()).setRoleName(role.getRoleName())).collect(Collectors.toList()));
    }
}
