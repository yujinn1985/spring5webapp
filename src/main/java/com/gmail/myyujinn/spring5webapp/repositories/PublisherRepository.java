package com.gmail.myyujinn.spring5webapp.repositories;

import com.gmail.myyujinn.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
