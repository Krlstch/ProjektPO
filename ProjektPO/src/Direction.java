public class Direction
{
    private DirectionEnum direction;

    Direction(DirectionEnum direction)
    {
        this.direction = direction;
    }

    Direction(int n)
    {
        switch(n)
        {
            case 0:
                direction = DirectionEnum.North;
                break;
            case 1:
                direction = DirectionEnum.NorthEast;
                break;
            case 2:
                direction = DirectionEnum.East;
                break;
            case 3:
                direction = DirectionEnum.SouthEast;
                break;
            case 4:
                direction = DirectionEnum.South;
                break;
            case 5:
                direction = DirectionEnum.SouthWest;
                break;
            case 6:
                direction = DirectionEnum.West;
                break;
            case 7:
                direction = DirectionEnum.NorthWest;
                break;
        }
    }

    public Position toPosition()
    {
        switch(direction)
        {
            case North:
                return new Position(0, 1);
            case NorthEast:
                return new Position(1, 1);
            case East:
                return new Position(1, 0);
            case SouthEast:
                return new Position(1, -1);
            case South:
                return new Position(0, -1);
            case SouthWest:
                return new Position(-1, -1);
            case West:
                return new Position(-1, 0);
            case NorthWest:
                return new Position(-1, 1);
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public DirectionEnum getDirection()
    {
        return direction;
    }

    public void rotate(int angle)
    {
        direction = direction.rotate(angle);
    }

    @Override
    public String toString()
    {
        return direction.toString();
    }
}
