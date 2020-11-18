package com.shazhi.onlinestudy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "curriculum", schema = "online_study")
@Data
@Accessors(chain = true)
public class CurriculumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curriculumId;
    private String curriculumName;
    private String curriculumDescription;
    private String curriculumCover;

    @OneToMany(mappedBy = "curriculum",cascade = CascadeType.ALL)
    private Collection<ChapterEntity> chapters;

    @OneToMany(mappedBy = "curriculum")
    private Collection<ClazzEntity> clazzes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "curriculum")
    private Collection<NoteEntity> notes;

}
