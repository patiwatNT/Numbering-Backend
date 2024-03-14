package com.billng.numbering.repository;

import com.billng.numbering.entities.News;
import com.billng.numbering.repositoryCustom.NewsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>, JpaSpecificationExecutor<News> , NewsRepositoryCustom {
}