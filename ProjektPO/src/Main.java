import java.awt.*;
import java.util.Random;

public class Main
{
    public static final int directionCount = 8;

    public static void main(String[] args)
    {

        Random random = new Random();
        WorldMap map = new WorldMap(40, 40, 100, 5, 50, 0.5);
        Animal animal1 = new Animal(new Position(20, 20), 100);
        Animal animal2 = new Animal(new Position(21, 21), 100);
        Animal animal3 = new Animal(new Position(19, 19), 100);
        Animal animal4 = new Animal(new Position(20, 19), 100);
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);
        for(int i = 0; i < 200; i++)
            map.newGrass();

        Simulation simulation = new Simulation(map);
        simulation.simulate();

    }
}
