package com.ibs.zj.mem.dao;

import com.ibs.common.core.mybatis.dao.BaseDAO;
import com.ibs.zj.mem.model.User;

public interface UserDAO extends BaseDAO {

	public void saveUser(User user);

	public User getById(String userId);

	public void updateUser(User user);

	public void deleteUser(String userId);

}
