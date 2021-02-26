public final class Coordinate {

    private int x; //width
    private int y; //length
    private int z; //level
    private Coordinate parentCoordinate;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate(int x, int y, int z, Coordinate parentCoordinate) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.parentCoordinate = parentCoordinate;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Coordinate getParentCoordinate() {
        return parentCoordinate;
    }

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
