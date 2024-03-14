package com.billng.numbering.service;

import com.billng.numbering.dto.NewsDto;
import com.billng.numbering.entities.News;
import com.billng.numbering.mapper.NewsMapper;
import com.billng.numbering.repository.NewsRepository;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class NewsService {
    @Value("${external.resources.path}")
    private String imgPath;
    @Value("${external.resources.dir}")
    private String folder;
    private final NewsRepository repository;
    private final NewsMapper newsMapper;

    public NewsService(NewsRepository repository, NewsMapper newsMapper) {
        this.repository = repository;
        this.newsMapper = newsMapper;
    }

    public NewsDto findByIdCustom(String id){
        return repository.findByIdCustom(id);
    }

    public List<NewsDto> init() {
        return repository.findAllCustom();
    }

    public String saveNews(NewsDto newsDto) {
        log.info("News Id : {}",newsDto.getId());
        if(newsDto.getId()!=null&&!newsDto.getId().isEmpty()){
            NewsDto obj = findByIdCustom(newsDto.getId());
            obj.setNewsTitle(newsDto.getNewsTitle());
            obj.setNewsDetail(newsDto.getNewsDetail());
            obj.setUpdateBy("admin");
            obj.setUpdateDate(new Date());
            save(obj);
        }else{
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateString = dateFormat.format(currentDate);
            String genId = "NEWS" + dateString;
            newsDto.setId(genId);
            newsDto.setCreateDate(currentDate);
            log.info("News ID : {}", genId);
            String newsDetail = newsDto.getNewsDetail();
            if(newsDetail.contains("src")){
                String replaceNewsDetail = saveImage(newsDetail);
                newsDto.setNewsDetail(replaceNewsDetail);
            }
            save(newsDto);
        }
        return "";
    }

    public NewsDto save(NewsDto newsDto) {
        News entity = newsMapper.toEntity(newsDto);
        return newsMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public NewsDto findById(Integer id) {
        return newsMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<NewsDto> findByCondition(NewsDto newsDto, Pageable pageable) {
        Page<News> entityPage = repository.findAll(pageable);
        List<News> entities = entityPage.getContent();
        return new PageImpl<>(newsMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NewsDto update(NewsDto newsDto, Integer id) {
        NewsDto data = findById(id);
        News entity = newsMapper.toEntity(newsDto);
        //BeanUtil.copyProperties(data, entity);
        return save(newsMapper.toDto(entity));
    }

    public String saveImage(String newsDetail) {
        String path = "";
        String imgSrc = newsDetail.substring(newsDetail.indexOf("src=\""), newsDetail.lastIndexOf("\" width"));
        String replaceSrc = imgSrc.replace("src=\"", "");
        log.info("data : {}", replaceSrc);
        String base64Image[] = replaceSrc.split(",");
        String extension;
        switch (base64Image[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image[1]);
        String uniqueID = UUID.randomUUID().toString();
        long timestamp = System.currentTimeMillis();
        String imageName = "image_" + timestamp + "_" + uniqueID + "." + extension;
        String imagePath = imgPath + imageName;
        File file = new File(imagePath);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(imageBytes);
            log.info("Save Image Success");
            path = "http://10.0.53.192:9090/" + folder+"/"+imageName;
            log.info("Image Path : {}", path);
            newsDetail = newsDetail.replace(replaceSrc, path);
            log.info("Final Detail : {}", newsDetail);
        } catch (IOException e) {
            e.printStackTrace();
            newsDetail = "";
        }
        return newsDetail;
    }
}
