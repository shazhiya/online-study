package com.shazhi.onlinestudy.entity;

import com.shazhi.onlinestudy.converter.JpaConverterJson;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "note", schema = "online_study")
@Data
@Accessors(chain = true)
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteId;
    private String noteContent;

    @Column(name = "note_writtentime")
    private Timestamp noteWrittenTime;

    @Convert(converter = JpaConverterJson.class)
    private Object noteDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private CurriculumEntity curriculum;
}
