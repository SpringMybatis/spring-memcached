package com.ibs.zj.mem.service.impl;

import net.spy.memcached.MemcachedClient;

import org.springframework.stereotype.Service;

import com.ibs.zj.mem.model.User;
import com.ibs.zj.mem.service.SpyUserService;
import com.sun.istack.internal.NotNull;

@Service
public class SpyUserServiceImpl implements SpyUserService {

	@NotNull
	private MemcachedClient mcmcacheClient;

	public void saveUser(User user) {
		mcmcacheClient.add(user.getUserId(), 3600, user);
	}

	public User getById(String userId) {
		return (User) mcmcacheClient.get(userId);
	}

	public void updateUser(User user) {
		mcmcacheClient.replace(user.getUserId(), 3600, user);
	}

	public void deleteUser(String userId) {
		mcmcacheClient.delete(userId);
	}

	public MemcachedClient getMcmcacheClient() {
		return mcmcacheClient;
	}

	public void setMcmcacheClient(MemcachedClient mcmcacheClient) {
		this.mcmcacheClient = mcmcacheClient;
	}

}
