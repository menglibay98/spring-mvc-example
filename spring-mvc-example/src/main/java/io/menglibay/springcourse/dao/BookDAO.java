package io.menglibay.springcourse.dao;

import io.menglibay.springcourse.models.Book;
import io.menglibay.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book",new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title,author,year) VALUES (?,?,?)",book.getTitle(),
                book.getAuthor(),book.getYear());
    }

    public void update(int id,Book updatedBook){
        jdbcTemplate.update("UPDATE Book SET title=?,author=?,year=? WHERE id=?",updatedBook.getTitle(),
                updatedBook.getAuthor(),updatedBook.getYear(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?",id);
    }

    // Join'им таблицы Book и Person и получаем человека,которому принадлежит книга с указанным id
    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT People.* FROM Book JOIN People ON Book.person_id = People.id " +
                "Where Book.id=?", new Object[]{id},new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    //Освобождает книгу(этот метод вызывается, когда человек возвращает книгу в библиотеках)
    public void release(int id){
        jdbcTemplate.update("UPDATE Book SET person_id = NULL WHERE id=?",id);
    }

    //Назначает книгу человеку (этот метод вызывается,когда человек возвращает книгу из библиотеки)
    public void assign(int id, Person selectedPeople){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?",selectedPeople.getId(),id);
    }

}
