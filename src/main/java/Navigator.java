import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Navigator {

    private Labyrinth labyrinth;
    private Coordinate startPosition;

    private final static byte[][] DIRECTIONS = {
            {1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}
    };


    public void findWayOut(Labyrinth labyrinth) {
        if (labyrinth != null) {
            ready(labyrinth);

            List<Coordinate> wayOut = getWayOut();

            int result = wayOut.size() - 1;
            if (result >= 1) {
                System.out.println("Entkommen in " + result + " Minute(n)!");
            } else System.out.println("Gefangen :-(");
        }
    }

    private void ready(Labyrinth labyrinth) {
        setLabyrinth(labyrinth);
        startPosition = labyrinth.getStartPosition();
    }

    private List<Coordinate> getWayOut() {
        LinkedList<Coordinate> queueOfCoordinates = new LinkedList<>();
        if (startPosition != null) {
            queueOfCoordinates.add(startPosition);
        } else {
            System.out.println("The start position was not found.");
            System.out.println("The program cannot be executed.");
            System.exit(0);
        }
        while (!queueOfCoordinates.isEmpty()) {
            Coordinate current = queueOfCoordinates.remove();

            if (labyrinth.isExit(current)) {
                return getTrackToExit(current);
            }

            if (!labyrinth.isAir(current) ||
                    labyrinth.isExploredCoordinate(current)) {
                continue;
            }

            if (labyrinth.isWall(current)) {
                labyrinth.addExploredCoordinates(current);
                continue;
            }

            for (byte[] direction : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(
                        (byte)(current.getX() + direction[0]),
                        (byte)(current.getY() + direction[1]),
                        (byte)(current.getZ() + direction[2]),
                        current
                );

                if (isValidCoordinate(coordinate)) {
                    queueOfCoordinates.add(coordinate);
                    labyrinth.addExploredCoordinates(current);
                }
            }
        }
        return Collections.emptyList();
    }

    private boolean isValidCoordinate(Coordinate coordinate) {
        boolean isX_Valid = coordinate.getX() >= 0 && coordinate.getX() < labyrinth.getWidth();
        boolean isY_Valid = coordinate.getY() >= 0 && coordinate.getY() < labyrinth.getLength();
        boolean isZ_Valid = coordinate.getZ() >= 0 && coordinate.getZ() < labyrinth.getNumberOfLevels();

        return isX_Valid && isY_Valid && isZ_Valid;
    }

    private List<Coordinate> getTrackToExit(Coordinate endCoordinate) {
        List<Coordinate> track = new ArrayList<>();
        Coordinate iteration = endCoordinate;

        while (iteration != null) {
            track.add(iteration);
            iteration = iteration.getParentCoordinate();
        }

        return track;
    }

    private void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }
}
