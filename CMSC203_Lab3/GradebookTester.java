import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	private GradeBook g1;
	private GradeBook g2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(88.5);
		g1.addScore(92.0);
		g1.addScore(76.5);
		
		g2.addScore(100.0);
		g2.addScore(85.5);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("88.5 92.0 76.5 "));
        assertTrue(g2.toString().equals("100.0 85.5 "));

        assertEquals(3, g1.getScoreSize(), 0.001);
        assertEquals(2, g2.getScoreSize(), 0.001);
	}
	
	@Test
	void testSum() {
		assertEquals(257.0, g1.sum(), 0.001);
		assertEquals(185.5, g2.sum(), 0.001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(76.5, g1.minimum(), 0.001);
        assertEquals(85.5, g2.minimum(), 0.001);
	}

	@Test
    void testFinalScore() {
        assertEquals(180.5, g1.finalScore(), 0.001);
        assertEquals(100.0, g2.finalScore(), 0.001);
    }
}
