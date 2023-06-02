package cn.lichenghao.entity.s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name;
	@Autowired
	private Teacher teacher;

	// 构造器注入引起循环依赖
	/*public Student(Teacher teacher) {
		this.teacher = teacher;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
