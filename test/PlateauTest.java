import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlateauTest {

    private Plateau plateau;

    PlateauTest() {
        this.plateau = Plateau.getInstance(5, 5);
    }

    @Test
    void getRoversTest() {
        assertEquals(0, plateau.getRovers().size());
    }

    @Test
    void plateauWithLargeCoordsCantMoveTest() {
        assertFalse(plateau.canMove(0, 10));
    }

    @Test
    void plateauWithShortCoordsCanMoveTest() {
        assertTrue(plateau.canMove(4, 2));
    }

    @Test
    void plateauWithNegativeCoordsCantMoveTest() {
        assertFalse(plateau.canMove(-1, 2));
    }
}