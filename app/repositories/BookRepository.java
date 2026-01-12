package repositories;

import com.google.inject.Inject;
import jakarta.persistence.NoResultException;
import models.db.Book;
import models.requests.CreateRequest;
import models.requests.UpdateRequest;
import play.db.jpa.JPAApi;

import java.util.List;

public class BookRepository {
    private final JPAApi jpaApi;

    @Inject
    public BookRepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public Book create(CreateRequest request) {
        Book book = new Book(request);

        return jpaApi.withTransaction(em -> {
            em.persist(book);
            return book;
        });
    }

    public List<Book> list() {
        return jpaApi.withTransaction(em -> {
            return em.createQuery("select p from Book p", Book.class).getResultList();
        });
    }

    public Book get(Long id) {
        return jpaApi.withTransaction(em -> {
            try {
                return em.createQuery("SELECT b FROM Book b WHERE b.id = :id", Book.class)
                    .setParameter("id", id)
                    .getSingleResult();
            } catch (NoResultException ex) {
                return null;
            }
        });
    }

    public Book update(Long id, UpdateRequest request) {
        Book book = get(id);

        book.setName(request.getName());
        book.setAuthor(request.getAuthor());

        jpaApi.withTransaction(em -> {
            em.merge(book);
        });
        return book;
    }

    public void delete(Long id) {
        jpaApi.withTransaction(em -> {
            Book book = em.find(Book.class, id);

            em.remove(book);
        });
    }
}
