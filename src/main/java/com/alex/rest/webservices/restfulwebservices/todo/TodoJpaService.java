package com.alex.rest.webservices.restfulwebservices.todo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alex.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

@Service
public class TodoJpaService {

	private TodoRepository todoRepository;

	public TodoJpaService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> findByUsername(String username){
		return todoRepository.findByUsername(username);
	}

	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo();
		todo.setUsername(username);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
		todo.setDone(done);
		return todoRepository.save(todo);
	}

	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}

	public Todo findById(int id) {
		Todo todo = null;
		Optional<Todo> findFirst = todoRepository.findById(id);
		if (!findFirst.isEmpty()) {
			todo = findFirst.get();
		}
		return todo;
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todoRepository.save(todo);
	}
}