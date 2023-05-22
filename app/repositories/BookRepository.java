package repositories;

import io.ebean.DB;
import models.db.Book;
import models.requests.CreateRequest;
import models.requests.UpdateRequest;

import java.util.List;

public class BookRepository {
    public Book create(CreateRequest request) {
        Book book = new Book(request);
        DB.save(book);
        return book;
    }

    public List<Book> list() {
        return DB.find(Book.class).findList();
    }

    public Book get(Long id) {
        return DB.find(Book.class).where().eq("id", id).findOne();
    }

    public Book update(Long id, UpdateRequest request) {
        Book book = get(id);

        book.setName(request.getName());
        book.setAuthor(request.getAuthor());

        DB.update(book);
        return book;
    }

    public void delete(Long id) {
        Book book = get(id);

        DB.delete(book);
    }
}
