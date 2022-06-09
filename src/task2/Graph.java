package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Reading the data file.
We go through all the lines of the file and process it.
We must take into account that the graph has edges and work out the shortest path.
 */

public class Graph {
    private static final int NUMBER_OF_CITIES = 10000;

    public void graph(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String readLine = bufferedReader.readLine();
        int source = Integer.parseInt(readLine);

        for (int i = 0; i < source; i++) {
            String[] citiesIndex = new String[NUMBER_OF_CITIES];
            readLine = bufferedReader.readLine();
            int countCities = Integer.parseInt(readLine);
            int matrixSize = countCities + 1;
            Matrix matrix = new Matrix(matrixSize);

            for (int j = 0; j < countCities; j++) {
                readLine = bufferedReader.readLine();
                String cityName = readLine;
                citiesIndex[j] = cityName;
                readLine = bufferedReader.readLine();
                int p = Integer.parseInt(readLine);

                for (int k = 0; k < p; k++) {
                    readLine = bufferedReader.readLine();
                    String[] brokenLine = readLine.split(" ");
                    int cityToConnect = Integer.parseInt(brokenLine[0]);
                    int weightOfConnection = Integer.parseInt(brokenLine[1]);
                    matrix.setEdge(j, cityToConnect, weightOfConnection);
                }
            }
            readLine = bufferedReader.readLine();
            int routesToFind = Integer.parseInt(readLine);
            for (int q = 0; q < routesToFind; q++) {
                readLine = bufferedReader.readLine();
                String[] cityNames = readLine.split(" ");
                String start = cityNames[0];
                String destination = cityNames[1];
                List<String> list = new ArrayList<>();

                for (String s : citiesIndex) {
                    if (s != null) {
                        list.add(s);
                    }
                }

                citiesIndex = list.toArray(new String[0]);
                int startIndex = 0;
                int destinationIndex = 0;
                for (int m = 0; m < citiesIndex.length; m++)
                    if (start.equals(citiesIndex[m])) {
                        startIndex = m;
                        break;
                    }
                for (int m = 0; m < citiesIndex.length; m++) {
                    if (destination.equals(citiesIndex[m])) {
                        destinationIndex = m;
                        break;
                    }
                }
                Integer[] distancesFromSource = matrix.waysOfMinimumCostBetweenPairsOfCities(startIndex);
                int destinationDistance = distancesFromSource[destinationIndex];
                System.out.println(destinationDistance);
            }
        }
        bufferedReader.close();
    }
}
