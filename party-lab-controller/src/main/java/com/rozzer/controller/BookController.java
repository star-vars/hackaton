package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/book")
public class BookController implements Controller<Book> {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAll() {
        return manager(Book.class).getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book create() {
        return manager(Book.class).create();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Book read(@RequestParam(value = "id") String id) {
        return manager(Book.class).getById(new Long(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Book object) {
        manager(Book.class).save(object);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Book object) {
        manager(Book.class).delete(object);
    }

}
