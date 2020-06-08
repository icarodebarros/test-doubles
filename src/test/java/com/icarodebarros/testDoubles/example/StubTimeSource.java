package com.icarodebarros.testDoubles.example;

import java.time.LocalDateTime;

public class StubTimeSource implements TimeSource {

	@Override
	public LocalDateTime currentTime() {
		return LocalDateTime.of(2020, 1, 1, 0, 0, 0);
	}

}
