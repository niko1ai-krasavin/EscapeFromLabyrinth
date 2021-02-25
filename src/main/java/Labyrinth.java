public class Labyrinth {

    private int numberOfLevels;
    private int length;
    private int width;
    private char[][][] mapOfLabyrinth;

    public Labyrinth(int numberOfLabyrinthLevels, int lengthOfLabyrinth, int widthOfLabyrinth) {
        numberOfLevels = numberOfLabyrinthLevels;
        length = lengthOfLabyrinth;
        width = widthOfLabyrinth;
        mapOfLabyrinth = new char[numberOfLabyrinthLevels][lengthOfLabyrinth][widthOfLabyrinth];
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

        //getInfoAboutMapOfLabyrinth();

        return "Labyrinth{" +
                "numberOfLevels=" + numberOfLevels +
                ", length=" + length +
                ", width=" + width +
                ", mapOfLabyrinth=" + mapOfLabyrinth +
                '}';
    }


    /**
    public void getInfoAboutMapOfLabyrinth() {

        for (int i = 0; i < mapOfLabyrinth.length; i++) {
            for (int j = 0; j < mapOfLabyrinth[i].length; j++) {
                for (int k = 0; k < mapOfLabyrinth[i][j].length; k++) {
                    System.out.println(mapOfLabyrinth[i][j][k]);
                }
            }
        }
    }
     **/

}
