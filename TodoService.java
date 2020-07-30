package com.myonlinebank.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "Ram", "1000", new Date(),"credit card payment"));
		todos.add(new Todo(2, "Akbar", "400", new Date(), "electricity bill"));
		todos.add(new Todo(3, "Antony", "250", new Date(),"misc"));
		todos.add(new Todo(4, "Antony", "50", new Date(),"travel"));
		todos.add(new Todo(5, "Antony", "150", new Date(),"internet"));
		todos.add(new Todo(6, "Antony", "20", new Date(),"medicines"));
		todos.add(new Todo(7, "Antony", "200", new Date(),"dining"));
		todos.add(new Todo(8, "Antony", "70", new Date(),"snacks"));
		todos.add(new Todo(9, "Akbar", "400", new Date(), "electricity bill"));
		todos.add(new Todo(10, "Akbar", "40", new Date(), "electricity bill"));
		todos.add(new Todo(11, "Akbar", "140", new Date(), "electricity bill"));
		todos.add(new Todo(12, "Akbar", "240", new Date(), "electricity bill"));
		todos.add(new Todo(13, "Akbar", "404", new Date(), "electricity bill"));
		todos.add(new Todo(14, "Ram", "500", new Date(),"credit card payment"));
		todos.add(new Todo(15, "Ram", "100", new Date(),"credit card payment"));
		todos.add(new Todo(16, "Ram", "10", new Date(),"credit card payment"));
		todos.add(new Todo(17, "Ram", "170", new Date(),"credit card payment"));
		todos.add(new Todo(18, "Ram", "190", new Date(),"credit card payment"));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	public void addTodo(String name, String desc, Date targetDate, String purpose) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, purpose));
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			} 
		}
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	
}
