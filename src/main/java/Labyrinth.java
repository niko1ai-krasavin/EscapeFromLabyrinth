import java.util.*;


public class Labyrinth {

    private final static char START_POSITION = 'S';
    private final static char EXIT = 'E';
    private final static char AIR = '.';
    private final static char WALL = '#';

    private byte numberOfLevels;
    private byte length;
    private byte width;
    private char[][][] mapOfLabyrinth;
    private HashSet<Coordinate> exploredCoordinates;

    //for coordinates from 'private void setXYZ(Coordinate coordinate)'
    private byte x;
    private byte y;
    private byte z;

    public Labyrinth(byte numberOfLabyrinthLevels, byte lengthOfLabyrinth, byte widthOfLabyrinth) {
        numberOfLevels = numberOfLabyrinthLevels;
        length = lengthOfLabyrinth;
        width = widthOfLabyrinth;
        mapOfLabyrinth = new char[numberOfLabyrinthLevels][lengthOfLabyrinth][widthOfLabyrinth];
        exploredCoordinates = new HashSet<>();
    }

    public boolean isWall(Coordinate coordinate) {
        setXYZ(coordinate);
        return mapOfLabyrinth[z][y][x] == WALL;
    }

    public boolean isAir(Coordinate coordinate) {
        setXYZ(coordinate);
        return mapOfLabyrinth[z][y][x] == AIR ||
                mapOfLabyrinth[z][y][x] == START_POSITION;
    }

    public boolean isExit(Coordinate coordinate) {
        setXYZ(coordinate);
        return mapOfLabyrinth[z][y][x] == EXIT;
    }

    public boolean isExploredCoordinate(Coordinate coordinate) {
        return exploredCoordinates.contains(coordinate);
    }

    public void addExploredCoordinates(Coordinate coordinate) {
        exploredCoordinates.add(coordinate);
    }

    public Coordinate getStartPosition() {
        Coordinate coordinate = null;

        for (byte i = 0; i < mapOfLabyrinth.length; i++) {
            for (byte j = 0; j < mapOfLabyrinth[i].length; j++) {
                for (byte k = 0; k < mapOfLabyrinth[i][j].length; k++) {
                    if (mapOfLabyrinth[i][j][k] == START_POSITION) {
                        coordinate = new Coordinate(k, j, i);
                    }
                }
            }
        }
        return coordinate;
    }

    public byte getLength() { return length; }

    public byte getWidth() { return width; }

    public byte getNumberOfLevels() { return numberOfLevels; }

    public char[][][] getMapOfLabyrinth() { return mapOfLabyrinth; }

    public void setMapOfLabyrinth(char[][][] mapOfLabyrinth) {
        this.mapOfLabyrinth = mapOfLabyrinth;
    }

    @Override
    public String toString() {
        return "Labyrinth{" +
                "numberOfLevels=" + numberOfLevels +
                ", length=" + length +
                ", width=" + width +
                ", mapOfLabyrinth=" + mapOfLabyrinth +
                '}';
    }

    private void setXYZ(Coordinate coordinate) {
        if (coordinate != null) {
            x = coordinate.getX();
            y = coordinate.getY();
            z = coordinate.getZ();
        }
    }
}
