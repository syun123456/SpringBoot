package com.syun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.syun.pojo.User;

// 表示這個interface是mapper類
@Mapper
@Repository
public interface UserMapper {
	List<User> queryUserList();
	
	User queryUserById(int id);
	
	int addUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(int id);
}
