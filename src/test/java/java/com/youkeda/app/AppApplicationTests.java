package com.youkeda.app;

import com.youkeda.app.control.UserController;
import com.youkeda.app.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
		User user = new User();
		user.setMobile("12345678910");
		user.setNickname("测试昵称");
		Assertions.assertThat(userController.addUser(user).getData()).isEqualTo(1);
	}

}
