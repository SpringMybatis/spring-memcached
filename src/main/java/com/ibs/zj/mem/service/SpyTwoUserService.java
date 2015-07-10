package com.ibs.zj.mem.service;

import com.ibs.zj.mem.model.User;

public interface SpyTwoUserService {
	
	public void saveUser(User user);

	public User getById(String userId);

	public void updateUser(User user);

	public void deleteUser(String userId);
	
}
