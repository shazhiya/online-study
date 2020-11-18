package com.shazhi.onlinestudy.service.imply;

import com.shazhi.onlinestudy.entity.CurriculumEntity;
import com.shazhi.onlinestudy.repository.CurriculumRepository;
import com.shazhi.onlinestudy.service.CurriculumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService {
    final
    CurriculumRepository curriculumRepository;

    public CurriculumServiceImpl(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    @Override
    public Boolean createCurriculum(CurriculumEntity curriculum) {
        curriculum.getChapters().forEach(chapter->{
            chapter.setCurriculum(curriculum).getCoursewares().forEach(ware->{
                ware.setChapter(chapter);
            });
        });
        return curriculumRepository.save(curriculum).getCurriculumId()>-1;
    }

    @Override
    public List<CurriculumEntity> getAll() {
        return curriculumRepository.findAll();
    }
}
