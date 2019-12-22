public class Simulation
{
    WorldMap map;
    Simulation(WorldMap map)
    {
        this.map = map;
    }

    public void simulateDay()
    {
        map.simulateDay();
    }

    public void simulate()
    {
        while(true)
            map.simulateDay();
    }
}
