package com.gmail.myyujinn.spring5webapp.repositories;

import com.gmail.myyujinn.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>{
}
