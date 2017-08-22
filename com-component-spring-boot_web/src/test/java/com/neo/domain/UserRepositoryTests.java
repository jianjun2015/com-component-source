package com.neo.domain;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neo.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("aa4", "aa@126.com-4", "aa", "aa123456-4",formattedDate));
		userRepository.save(new User("bb5", "bb@126.com-5", "bb", "bb123456-5",formattedDate));
		userRepository.save(new User("cc6", "cc@126.com-6", "cc", "cc123456-6",formattedDate));

		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa1"));
	}

}