package br.com.todo.todotest.controllers;

import br.com.todo.todotest.model.ToDo;
import br.com.todo.todotest.repositorys.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository repository;

    @GetMapping
    public List<ToDo> lista(String nomeTarefa) {
//        if (nomeTarefa == null) {
//            List<ToDo> todo = repository.findAll();
//            return repository.findAll();
//        } else {
//            List<ToDo> todo = repository.findByTarefa(nomeTarefa);
//            return repository.findAll();
//        }

        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody ToDo todo) {

        repository.save(todo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
//        return repository.findById(id)
//                .map(record -> {
//                    repository.deleteById(id);
//                    return ResponseEntity.ok().build();
//                }).orElse(ResponseEntity.notFound().build());
        Optional<ToDo> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid ToDo todo) {
//        element.setId(id);
//        repository.save(element);
//        Optional<ToDo> optional = repository.findById(id);
//        if (optional.isPresent()) {
//            ToDo updated = repository.save(todo);
//            return ResponseEntity.ok().body(updated);
//        }
//
//        return ResponseEntity.notFound().build();


        return repository.findById(id)
                .map(record -> {
                    record.setTarefa(todo.getTarefa());
                    record.setDescricao(todo.getDescricao());
                    record.setStatus(todo.getStatus());
                    ToDo updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());


    }
}
