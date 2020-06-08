package com.icarodebarros.testDoubles.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUserServiceWithSingleUser {
	private UserService userService;
	private MockAuditLog mockAuditLog;
	private FakeUserStore fakeUserStore;
	private StubTimeSource stubTimeSource;
	
	@BeforeEach
	public void createUserService() {
		mockAuditLog = new MockAuditLog();
		fakeUserStore = new FakeUserStore();
		stubTimeSource = new StubTimeSource();
		userService = new SimpleUserService(mockAuditLog,fakeUserStore,stubTimeSource);
		userService.register("bob");
		mockAuditLog.enable();
	}
	
	@Test
	public void testFindingUserByName() {
		User user = userService.find("bob");
		assertNotNull(user);
		assertEquals("bob",user.getUsername());
	}
	
	@Test
	public void testRegisteringDuplicateUser() {
		mockAuditLog.expect("user","duplicateregister","bob");
		
		userService.register("bob");
		
		List<User> users = userService.users();
		
		assertEquals(1,users.size());
		assertEquals("bob",users.get(0).getUsername());
		assertEquals(stubTimeSource.currentTime(), users.get(0).getCreationTime());
		mockAuditLog.verify();
	}
	
	@Test
	public void testRegisteringSecondUser() {
		mockAuditLog.expect("user","register","alice");
		
		userService.register("alice");
		
		assertEquals(2,userService.users().size());
		User user = userService.find("alice");
		
		assertNotNull(user);
		assertEquals("alice",user.getUsername());
		assertEquals(stubTimeSource.currentTime(), user.getCreationTime());
		mockAuditLog.verify();
	}
}
