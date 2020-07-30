package com.myonlinebank.todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myonlinebank.dao.TodoDao;
import com.myonlinebank.exception.ExceptionController;




@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService service;
	
	@Autowired
	TodoDao dao;
	
	private Log logger = LogFactory.getLog(ExceptionController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		model.addAttribute("name", retrieveLoggedInUser());
		List<Todo> list = dao.getTodos();
		model.addAttribute("todos", list);
		return "list-todos";
	}

	
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
			logger.error("Request: " + request.getRequestURL() + " threw an exception",ex);
			return "error-specified";
	}
	
	private String retrieveLoggedInUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();
		
		return principal.toString();
		
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodos(ModelMap model) {
		
//		throw new RuntimeException("stimulated exception");
		
		model.addAttribute("todo", new Todo(0, retrieveLoggedInUser(), "", new Date(), ""));
		return "todo";
		
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String showTodosAgain(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		service.addTodo(retrieveLoggedInUser(), todo.getDesc(), new Date(), todo.getPurpose());
		model.clear();
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model,@RequestParam int id) {
		Todo todo = service.retrieveTodo(id);
//		service.deleteTodo(id);
		model.addAttribute("todo", todo);
		// delete the todo here
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(retrieveLoggedInUser());
		service.updateTodo(todo);
		// update the todo here
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodos(ModelMap model,@RequestParam int id) {
		
		service.deleteTodo(id);
		model.clear();
		// delete the todo here
		return "redirect:list-todos";
	}
	
	
	
}
