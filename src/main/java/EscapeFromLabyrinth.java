import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class EscapeFromLabyrinth {

    private static List<Labyrinth> getLabyrinthsFromFile(File file) {

        List<Labyrinth> labyrinthList = new ArrayList<>();
        Labyrinth currentLabyrinth = null;
        char[][][] mapOfLabyrinth = null;

        int currentLevel = 0;
        int currentLength = 0;


        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null && !(line.matches("0 0 0"))) {

                if (line.matches("\\d\\s\\d\\s\\d")) {
                    currentLevel = 0;
                    currentLength = 0;

                    String[] strArray = line.split("\\s");

                    int levelOfLabyrinth = Integer.parseInt(strArray[0]);
                    int lengthOfLabyrinth = Integer.parseInt(strArray[1]);
                    int widthOfLabyrinth = Integer.parseInt(strArray[2]);

                    currentLabyrinth = new Labyrinth(levelOfLabyrinth, lengthOfLabyrinth, widthOfLabyrinth);
                    labyrinthList.add(currentLabyrinth);

                    mapOfLabyrinth = currentLabyrinth.getMapOfLabyrinth();
                }

                if (line.matches("")) {
                    currentLevel++;
                    currentLength = 0;
                }

                if (labyrinthList.size() > 0) {

                    currentLabyrinth = labyrinthList.get(labyrinthList.size() - 1);

                    int width = currentLabyrinth.getWidth();

                    if (line.matches("\\S{" + width + "}")) {
                        mapOfLabyrinth[currentLevel][currentLength] = line.toCharArray();
                        currentLength++;
                    }
                }

                if ((currentLevel == currentLabyrinth.getNumberOfLevels()) &&
                        (currentLength == currentLabyrinth.getLength())) {
                    currentLabyrinth.setMapOfLabyrinth(mapOfLabyrinth);
                    labyrinthList.set(labyrinthList.size()-1, currentLabyrinth);
                }

                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return labyrinthList;
    }

    public static void main(String[] args) {

        File file = new File("input.txt");

        List<Labyrinth> labyrinthList = getLabyrinthsFromFile(file);

        for (Labyrinth labyrinth : labyrinthList) {
            new Navigator().findWayOut(labyrinth);
        }
    }
}
