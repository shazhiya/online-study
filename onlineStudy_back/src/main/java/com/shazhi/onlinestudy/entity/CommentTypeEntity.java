package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "comment_type", schema = "online_study")
@Data
@Accessors(chain = true)
public class CommentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commenttype_id")
    private Integer commentTypeId;
    @Column(name = "commenttype_name")
    private String commentTypeName;

    @OneToMany(mappedBy = "commentType")
    private Collection<CommentEntity> comments;
}
