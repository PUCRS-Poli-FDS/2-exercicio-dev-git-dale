import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {

    @BeforeAll
    public static void setup() {
        Plateau.getInstance(5, 5);
    }

    @Test
    void moveFirstRoverTest() {
        Rover rover = new Rover(1, 2, 'N');
        rover.move("LMLMLMLMM".toCharArray());
        assertEquals("1 3 N", rover.toString());
    }

    @Test
    void moveSecondRoverTest() {
        Rover rover = new Rover(3, 3, 'E');
        rover.move("MMRMMRMRRM".toCharArray());
        assertEquals("5 1 E", rover.toString());
    }

    @Test
    void moveSecondOutofBoundsShouldThrowsExceptionTest() {
        Rover rover = new Rover(3, 3, 'E');
        assertThrows(RuntimeException.class, () -> rover.move("MMRMMRMRRMMMMMMMMMMM".toCharArray()));
    }

    @Test
    void moveSecondWithWrongDirectionShouldThrowsExceptionTest() {
        Rover rover = new Rover(3, 3, 'E');
        assertThrows(RuntimeException.class, () -> rover.move("MMRMMRMRRXMMMMMMMMMMM".toCharArray()));
    }
}