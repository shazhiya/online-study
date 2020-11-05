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
    private String curriculumName;
    private String curriculumDescription;

    @OneToMany
    private Collection<ChapterEntity> chaptersByCurriculumId;

    @OneToMany
    private Collection<ClazzEntity> clazzesByCurriculumId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "curriculum")
    private Collection<NoteEntity> notesByCurriculumId;
}
