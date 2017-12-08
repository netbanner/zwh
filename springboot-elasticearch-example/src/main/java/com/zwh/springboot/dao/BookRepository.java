package com.zwh.springboot.dao;

import com.zwh.springboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.annotation.Resource;
import java.util.List;


public interface BookRepository extends ElasticsearchRepository<Book,String> {

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

}
