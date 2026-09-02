package org.opread.infrastructure.persistence.adapter;

import org.opread.domain.model.Book;
import org.opread.domain.repository.IBookRepository;
import org.opread.infrastructure.persistence.mapper.BookMapper;
import org.opread.infrastructure.persistence.repository.ISpringDataBookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookRepositoryImpl implements IBookRepository {
    private final ISpringDataBookRepository springDataBookRepository;
    public BookRepositoryImpl(ISpringDataBookRepository springDataBookRepository) {
        this.springDataBookRepository = springDataBookRepository;
    }

    @Override
    public Book save(Book book) {
        var bookToSave = BookMapper.toEntity(book);
        var savedBook = springDataBookRepository.save(bookToSave);
        return BookMapper.toDomain(savedBook);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return springDataBookRepository.findById(id).map(BookMapper::toDomain);
    }

    @Override
    public Optional<Book> findByGoogleBooksId(String googleBooksId) {
        return springDataBookRepository.findByGoogleBooksId(googleBooksId).map(BookMapper::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return springDataBookRepository.findAll().stream().map(BookMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        springDataBookRepository.deleteById(id);
    }
}
