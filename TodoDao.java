package com.myonlinebank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.myonlinebank.todo.Todo;

public class TodoDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Todo p){  
	    String sql="insert into todo(todo_amount,todo_date,todo_purpose,todo_customer_name) values('"+p.getDesc()+"',"+p.getTargetDate()+",'"+p.getPurpose()+",'"+p.getUser()+"')";  
	    return template.update(sql);  
	}  
	  
	public Todo getTodoById(int id){  
	    String sql="select * from todo where todo_customer_name=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Todo>(Todo.class));  
	}  
	public List<Todo> getTodos(){  
	    return template.query("select * from todo",new RowMapper<Todo>(){  
	        public Todo mapRow(ResultSet rs, int row) throws SQLException {  
	            Todo e=new Todo();  
	            e.setId(rs.getInt(1));  
	            e.setDesc(rs.getString(2));  
	            e.setTargetDate(rs.getDate(3));  
	            e.setPurpose(rs.getString(4));
	            e.setUser(rs.getNString(5));
	            return e;  
	        }  
	    });  
	} 
	
}
