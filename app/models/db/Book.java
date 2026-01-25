package models.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.requests.CreateRequest;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;

    public Book(CreateRequest request) {
        this.name = request.getName();
        this.author = request.getAuthor();
    }
}
