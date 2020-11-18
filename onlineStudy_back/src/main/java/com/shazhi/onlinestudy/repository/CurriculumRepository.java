package com.shazhi.onlinestudy.repository;

import com.shazhi.onlinestudy.entity.CurriculumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<CurriculumEntity,Integer>,JpaSpecificationExecutor<CurriculumEntity> {
}
