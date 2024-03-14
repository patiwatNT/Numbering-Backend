package com.billng.numbering.controller;

import com.billng.numbering.dto.NewsDto;
import com.billng.numbering.service.NewsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/news")
@RestController
@Slf4j
@Api("news")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/main")
    public List<NewsDto> init(){
        log.info("Initial Api Start----------------------------");
        return newsService.init();
    }

    @GetMapping("findById/{id}")
    public NewsDto findByIdCustom(@PathVariable("id") String id){
        return newsService.findByIdCustom(id);
    }


    @PostMapping("/saveNews")
    public ResponseEntity<String> save(@RequestBody NewsDto newsDto) {
        newsService.saveNews(newsDto);
        return ResponseEntity.status(HttpStatus.OK).body("Save Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> findById(@PathVariable("id") Integer id) {
        NewsDto news = newsService.findById(id);
        return ResponseEntity.ok(news);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(newsService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        newsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<NewsDto>> pageQuery(NewsDto newsDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NewsDto> newsPage = newsService.findByCondition(newsDto, pageable);
        return ResponseEntity.ok(newsPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated NewsDto newsDto, @PathVariable("id") Integer id) {
        newsService.update(newsDto, id);
        return ResponseEntity.ok().build();
    }
}
