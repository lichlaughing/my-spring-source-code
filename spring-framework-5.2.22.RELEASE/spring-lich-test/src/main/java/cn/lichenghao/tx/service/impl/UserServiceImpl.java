package cn.lichenghao.tx.service.impl;

import cn.lichenghao.tx.dao.UserDao;
import cn.lichenghao.tx.entity.UserInfo;
import cn.lichenghao.tx.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public List<UserInfo> listUser() {
		return userDao.listUser();
	}

	@Override
	public int addUser(UserInfo userInfo) {
		int added = userDao.addUser(userInfo);
//		if (added > 0) {
//			throw new RuntimeException("测试回滚！");
//		}
		return added;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int addUser2(UserInfo userInfo) {
		return 0;
	}
}
