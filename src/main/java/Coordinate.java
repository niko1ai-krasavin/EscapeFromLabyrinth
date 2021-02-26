public final class Coordinate {

    private byte x; //width
    private byte y; //length
    private byte z; //level
    private Coordinate parentCoordinate;

    public Coordinate(byte x, byte y, byte z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate(byte x, byte y, byte z, Coordinate parentCoordinate) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.parentCoordinate = parentCoordinate;
    }

    public byte getX() { return x; }

    public byte getY() { return y; }

    public byte getZ() { return z; }

    public Coordinate getParentCoordinate() { return parentCoordinate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (getX() != that.getX()) return false;
        if (getY() != that.getY()) return false;
        return getZ() == that.getZ();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        result = 31 * result + getZ();
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", parentCoordinate=" + parentCoordinate +
                '}';
    }
}
