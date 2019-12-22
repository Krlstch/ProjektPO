public class Position
{
    public int x;
    public int y;

    Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    Position(Position position)
    {
        this.x = position.x;
        this.y = position.y;
    }

    public boolean equals(Object other)
    {
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return (this.x == that.x && this.y == that.y);
    }

    public Position add(Position other, Position mapUpperRight)
    {
        return new Position(mod(this.x + other.x, mapUpperRight.x + 1), mod(this.y + other.y, mapUpperRight.y + 1));
    }

    @Override
    public int hashCode()
    {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

    boolean precedes(Position other)
    {
        return this.x <= other.x && this.y <= other.y;
    }

    boolean follows(Position other)
    {
        return this.x >= other.x && this.y >= other.y;
    }

    @Override
    public String toString()
    {
        return ( '(' + Integer.toString(x) + ',' + Integer.toString(y) + ')');
    }

    private int mod(int x, int y)
    {
        if(x > 0)
            return x % y;
        else
            return (x % y + y) % y;
    }
}
