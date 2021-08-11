package com.cts.sdrad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class ToDo {

	@Id
	@GeneratedValue
	private Long todoId;
	private String task;
	private String status;

	public ToDo() {
	}

	public ToDo(Long todoId, String task, String status) {
		super();
		this.todoId = todoId;
		this.task = task;
		this.status = status;
	}

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
