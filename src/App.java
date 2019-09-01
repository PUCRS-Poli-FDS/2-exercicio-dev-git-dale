public class App {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(1, 2, 'N');
        rover1.changeOrientation('L');
        rover1.move();
        rover1.changeOrientation('L');
        rover1.move();
        rover1.changeOrientation('L');
        rover1.move();
        rover1.changeOrientation('L');
        rover1.move();
        rover1.move();

        Rover rover2 = new Rover(3, 3, 'E');
        rover2.move();
        rover2.move();
        rover2.changeOrientation('R');
        rover2.move();
        rover2.move();
        rover2.changeOrientation('R');
        rover2.move();
        rover2.changeOrientation('R');
        rover2.changeOrientation('R');
        rover2.move();

        plateau.getRovers().add(rover1);
        plateau.getRovers().add(rover2);

        for (int i = 0; i < plateau.getRovers().size(); i++) {
            System.out.println(plateau.getRovers().get(i));
        }

    }
}