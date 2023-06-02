package cn.lichenghao.entity.s;

import org.springframework.stereotype.Component;

@Component
public class Director {
	private String name;

	private Teacher teacher;

	public Director() {
	}

	public Director(String name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
}
