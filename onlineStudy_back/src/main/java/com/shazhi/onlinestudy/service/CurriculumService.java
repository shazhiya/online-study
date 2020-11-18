package com.shazhi.onlinestudy.service;

import com.shazhi.onlinestudy.entity.CurriculumEntity;

import java.util.List;

public interface CurriculumService {
    Boolean createCurriculum(CurriculumEntity curriculum);

    List<CurriculumEntity> getAll();

}
