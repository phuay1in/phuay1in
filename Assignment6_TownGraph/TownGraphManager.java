import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface
{
    private Graph graph;

    public TownGraphManager()
    {
        graph = new Graph();
    }

    private Town findTown(String name)
    {
        for(Town town : graph.vertexSet())
        {
            if(town.getName().equals(name))
            {
                return town;
            }
        }

        return null;
    }

    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName)
    {
        Town source = findTown(town1);
        Town destination = findTown(town2);

        if(source == null || destination == null)
        {
            return false;
        }

        return graph.addEdge(source, destination, weight, roadName) != null;
    }

    @Override
    public String getRoad(String town1, String town2)
    {
        Town source = findTown(town1);
        Town destination = findTown(town2);
        Road road = graph.getEdge(source, destination);

        if(road == null)
        {
            return null;
        }

        return road.getName();
    }

    @Override
    public boolean addTown(String v)
    {
        return graph.addVertex(new Town(v));
    }

    @Override
    public boolean containsTown(String v)
    {
        return graph.containsVertex(new Town(v));
    }

    @Override
    public boolean containsRoadConnection(String town1, String town2)
    {
        Town source = findTown(town1);
        Town destination = findTown(town2);
        return graph.containsEdge(source, destination);
    }

    @Override
    public ArrayList<String> allRoads()
    {
        ArrayList<String> roads = new ArrayList<>();

        for(Road road : graph.edgeSet())
        {
            roads.add(road.getName());
        }

        Collections.sort(roads);
        return roads;
    }

    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
    	
        Town source = findTown(town1);
        Town destination = findTown(town2);
        return graph.removeEdge(source, destination, 0, road) != null;
    }

    @Override
    public boolean deleteTown(String v) {
    	
        return graph.removeVertex(new Town(v));
    }

    @Override
    public ArrayList<String> allTowns() {
    	
        ArrayList<String> towns = new ArrayList<>();

        for(Town town : graph.vertexSet())
        {
            towns.add(town.getName());
        }

        Collections.sort(towns);

        return towns;
    }

    @Override
    public ArrayList<String> getPath(String town1, String town2) {
    	
        Town source = findTown(town1);
        Town destination = findTown(town2);
        return graph.shortestPath(source, destination);
    }

    public Town getTown(String name) {
    	
    	for (Town town : graph.vertexSet()) {
    		if (town.getName().equals(name)) {
    			return town;
    		}
    	}
    	return null;
    }
    
    public void populateTownGraph(File file) throws FileNotFoundException, IOException {
    	
    	if (!file.exists()) {
    		throw new FileNotFoundException();
    	}
    	
    	if (!file.canRead()) {
    		throw new IOException();
    	}
    	
        Scanner inputFile = new Scanner(file);
       
        while(inputFile.hasNextLine())
        {
            String line = inputFile.nextLine();
            String[] parts = line.split(";");
            String[] roadInfo = parts[0].split(",");
            String roadName = roadInfo[0];
            int distance = Integer.parseInt(roadInfo[1]);
            String town1 = parts[1];
            String town2 = parts[2];
            addTown(town1);
            addTown(town2);
            addRoad(town1, town2,distance, roadName);
        }

        inputFile.close();
    }
}