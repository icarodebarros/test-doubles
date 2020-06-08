package com.icarodebarros.testDoubles.example;

import java.time.LocalDateTime;

public interface TimeSource {
	LocalDateTime currentTime();
}
