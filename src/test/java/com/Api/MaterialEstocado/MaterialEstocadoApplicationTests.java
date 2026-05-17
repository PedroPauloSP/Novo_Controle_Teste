package com.Api.MaterialEstocado;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MaterialEstocadoApplicationTests {

	@Test
	void contextLoads() {
	}
  @Test
    void main() {

        assertDoesNotThrow(() -> {
            MaterialEstocadoApplication.main(new String[]{});
        });
}
}