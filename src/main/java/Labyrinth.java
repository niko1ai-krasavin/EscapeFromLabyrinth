import java.util.*;


public class Labyrinth {

    private int numberOfLevels;
    private int length;
    private int width;
    private char[][][] mapOfLabyrinth;
    private HashSet<Coordinate> exploredCoordinates;

    //for coordinates from 'void setXYZ(Coordinate coordinate)'
    private int x;
    private int y;
    private int z;

    public boolean isWall(Coordinate coordinate) {
        setXYZ(coordinate);
        return mapOfLabyrinth[z][y][x] == '#';
    }

    public boolean isAir(Coordinate coordinate) {
        setXYZ(coordinate);
        return mapOfLabyrinth[z][y][x] == '.' ||
                mapOfLabyrinth[z][y][x] == 'S';
    }

    public boolean isExit(Coordinate coordinate) {
        setXYZ(coordinate);
        return mapOfLabyrinth[z][y][x] == 'E';
    }

    public boolean isExploredCoordinate(Coordinate coordinate) {
        return exploredCoordinates.contains(coordinate);
    }

    public void addExploredCoordinates(Coordinate coordinate) {
        exploredCoordinates.add(coordinate);
    }

    public Coordinate getStartPosition() {
        Coordinate coordinate = null;

        for (int i = 0; i < mapOfLabyrinth.length; i++) {
            for (int j = 0; j < mapOfLabyrinth[i].length; j++) {
                for (int k = 0; k < mapOfLabyrinth[i][j].length; k++) {
                    if (mapOfLabyrinth[i][j][k] == 'S') {
                        coordinate = new Coordinate(k, j, i);
                    }
                }
            }
        }
        return coordinate;
    }

    public Labyrinth(int numberOfLabyrinthLevels, int lengthOfLabyrinth, int widthOfLabyrinth) {
        numberOfLevels = numberOfLabyrinthLevels;
        length = lengthOfLabyrinth;
        width = widthOfLabyrinth;
        mapOfLabyrinth = new char[numberOfLabyrinthLevels][lengthOfLabyrinth][widthOfLabyrinth];
        exploredCoordinates = new HashSet<>();
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    public char[][][] getMapOfLabyrinth() {
        return mapOfLabyrinth;
    }

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
