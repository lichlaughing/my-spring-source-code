package cn.lichenghao.tx.dao;

import cn.lichenghao.tx.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
	List<UserInfo> listUser();

	int addUser(UserInfo userInfo);
}
