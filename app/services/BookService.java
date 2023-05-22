package services;

import models.db.Book;
import models.requests.CreateRequest;
import models.requests.UpdateRequest;

import java.util.List;

public interface BookService
{
    Book create(CreateRequest request);
    List<Book> list();
    Book get(Long id);
    Book update(Long id, UpdateRequest request);
    void delete(Long id);
}
