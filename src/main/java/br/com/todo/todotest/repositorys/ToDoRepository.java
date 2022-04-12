package br.com.todo.todotest.repositorys;

import br.com.todo.todotest.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository <ToDo, Long> {

    List<ToDo> findByTarefa(String nomeTarefa);
}
