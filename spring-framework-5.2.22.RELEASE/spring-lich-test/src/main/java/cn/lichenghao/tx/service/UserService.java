package cn.lichenghao.tx.service;

import cn.lichenghao.tx.entity.UserInfo;

import java.util.List;

public interface UserService {
	List<UserInfo> listUser();
	int addUser(UserInfo userInfo);
	int addUser2(UserInfo userInfo);
}
