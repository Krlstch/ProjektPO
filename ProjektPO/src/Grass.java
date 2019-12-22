public class Grass extends Element
{
    Grass(Position position)
    {
        this.position = new Position(position);
    }

    @Override
    public String toString()
    {
        return "G";
    }
}
