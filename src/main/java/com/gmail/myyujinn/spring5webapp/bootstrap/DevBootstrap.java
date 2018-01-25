package com.gmail.myyujinn.spring5webapp.bootstrap;

import com.gmail.myyujinn.spring5webapp.model.Author;
import com.gmail.myyujinn.spring5webapp.model.Book;
import com.gmail.myyujinn.spring5webapp.model.Publisher;
import com.gmail.myyujinn.spring5webapp.repositories.AuthorRepository;
import com.gmail.myyujinn.spring5webapp.repositories.BookRepository;
import com.gmail.myyujinn.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Publisher publisher = new Publisher("John", "Wall Street");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Rod
        Publisher publisherTwo = new Publisher("Jack","Baker Street");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisherTwo);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(publisherTwo);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
