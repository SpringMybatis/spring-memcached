package com.ibs.zj.mem.service.impl;

import org.springframework.stereotype.Service;

import com.ibs.zj.mem.model.User;
import com.ibs.zj.mem.service.UserService;
import com.whalin.MemCached.MemCachedClient;
@Service
public class UserServiceImpl implements UserService {

	private MemCachedClient cacheProvider;

	public void saveUser(User user) {
		cacheProvider.add(user.getUserId(), user);
	}

	public User getById(String userId) {
		return (User) cacheProvider.get(userId);
	}

	public void updateUser(User user) {
		cacheProvider.delete(user.getUserId());
		cacheProvider.add(user.getUserId(), user);
	}

	public void deleteUser(String userId) {
		cacheProvider.delete(userId);
	}

	public MemCachedClient getCacheProvider() {
		return cacheProvider;
	}

	public void setCacheProvider(MemCachedClient cacheProvider) {
		this.cacheProvider = cacheProvider;
	}

}
