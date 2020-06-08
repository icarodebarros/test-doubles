package com.icarodebarros.testDoubles.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmptyUserService {
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
		mockAuditLog.enable();
	}
	
	@Test
	public void testDefaultUserServiceHasNoUsers() {
		assertEquals(0,userService.users().size());
	}
	
	@Test
	public void testFindingNonExistentUser() {
		assertNull(userService.find("bob"));
	}
	
	@Test
	public void testRegisteringSingleUser() {
		mockAuditLog.expect("user","register","bob");
		
		userService.register("bob");
		List<User> users = userService.users();
		
		assertEquals(1,users.size());
		assertEquals("bob",users.get(0).getUsername());
		assertEquals(stubTimeSource.currentTime(), users.get(0).getCreationTime());
		mockAuditLog.verify();
	}
}