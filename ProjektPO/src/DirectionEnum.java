public enum DirectionEnum
{
    North(0),
    NorthEast(1),
    East(2),
    SouthEast(3),
    South(4),
    SouthWest(5),
    West(6),
    NorthWest(7);
    private final int value;

    private DirectionEnum(int value)
    {
        this.value = value;
    }

    public DirectionEnum rotate(int angle)
    {
        return values()[(ordinal() + angle) % 8];
    }
}
