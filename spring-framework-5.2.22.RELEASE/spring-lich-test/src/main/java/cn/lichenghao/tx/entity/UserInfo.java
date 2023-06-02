package cn.lichenghao.tx.entity;

public class UserInfo {
	private Integer id;
	private String name;
	private String desc;

	public UserInfo() {
	}

	public UserInfo(Integer id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}
}
