import java.util.*;

public class Graph implements GraphInterface<Town, Road>
{
    private HashSet<Town> towns;
    private HashSet<Road> roads;
    private HashMap<Town, ArrayList<Road>> adjacencyList;

    private HashMap<Town, Integer> distances;
    private HashMap<Town, Town> previousTown;

    public Graph()
    {
        towns = new HashSet<>();
        roads = new HashSet<>();
        adjacencyList = new HashMap<>();
    }

    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex)
    {
        if(sourceVertex == null || destinationVertex == null)
        {
            return null;
        }

        for(Road road : roads)
        {
            if(road.contains(sourceVertex) && road.contains(destinationVertex))
            {
                return road;
            }
        }

        return null;
    }

    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
    {
        if(sourceVertex == null || destinationVertex == null)
        {
            throw new NullPointerException();
        }

        if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
        {
            throw new IllegalArgumentException();
        }

        Road road = new Road(sourceVertex, destinationVertex, weight, description);

        roads.add(road);
        adjacencyList.get(sourceVertex).add(road);
        adjacencyList.get(destinationVertex).add(road);
        return road;
    }

    @Override
    public boolean addVertex(Town v)
    {
        if(v == null)
        {
            throw new NullPointerException();
        }

        if(towns.contains(v))
        {
            return false;
        }

        towns.add(v);
        adjacencyList.put(v, new ArrayList<>());
        return true;
    }

    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex)
    {
        return getEdge(sourceVertex, destinationVertex) != null;
    }

    @Override
    public boolean containsVertex(Town v)
    {
        return towns.contains(v);
    }

    @Override
    public Set<Road> edgeSet()
    {
        return roads;
    }

    @Override
    public Set<Road> edgesOf(Town vertex)
    {
        if(vertex == null)
        {
            throw new NullPointerException();
        }

        if(!containsVertex(vertex))
        {
            throw new IllegalArgumentException();
        }

        return new HashSet<>(adjacencyList.get(vertex));
    }

    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
    {
        Road road = new Road(sourceVertex, destinationVertex, weight, description);

        if(roads.remove(road))
        {
            adjacencyList.get(sourceVertex).remove(road);
            adjacencyList.get(destinationVertex).remove(road);
            return road;
        }

        return null;
    }

    @Override
    public boolean removeVertex(Town v)
    {
        if(v == null)
        {
            return false;
        }

        if(!towns.contains(v))
        {
            return false;
        }

        ArrayList<Road> connectedRoads = new ArrayList<>(adjacencyList.get(v));

        for(Road road : connectedRoads)
        {
            Town other;

            if(road.getSource().equals(v))
            {
                other = road.getDestination();
            }
            else
            {
                other = road.getSource();
            }

            adjacencyList.get(other).remove(road);
            roads.remove(road);
        }

        adjacencyList.remove(v);
        towns.remove(v);
        return true;
    }

    @Override
    public Set<Town> vertexSet()
    {
        return towns;
    }

    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
    {
        dijkstraShortestPath(sourceVertex);
        ArrayList<String> path = new ArrayList<>();

        if(previousTown.get(destinationVertex) == null && !sourceVertex.equals(destinationVertex))
        {
            return path;
        }

        ArrayList<Town> townPath = new ArrayList<>();
        Town current = destinationVertex;

        while(current != null)
        {
            townPath.add(current);
            current = previousTown.get(current);
        }

        Collections.reverse(townPath);

        for(int i = 0; i < townPath.size() - 1; i++)
        {
            Town currentTown = townPath.get(i);
            Town nextTown = townPath.get(i + 1);
            Road road = getEdge(currentTown, nextTown);
            path.add(currentTown.getName() + " by " + road.getName() + " to " + nextTown.getName() + " "
            + road.getDistance() + " miles");
        }

        return path;
    }

    @Override
    public void dijkstraShortestPath(Town sourceVertex)
    {
        distances = new HashMap<>();
        previousTown = new HashMap<>();
        HashSet<Town> visited = new HashSet<>();

        for(Town town : towns)
        {
            distances.put(town, Integer.MAX_VALUE);
            previousTown.put(town, null);
        }

        distances.put(sourceVertex, 0);

        while(visited.size() < towns.size())
        {
            Town current = getClosestUnvisitedTown(visited);

            if(current == null)
            {
                break;
            }

            visited.add(current);

            for(Road road : adjacencyList.get(current))
            {
                Town neighbor;

                if(road.getSource().equals(current))
                {
                    neighbor = road.getDestination();
                }
                else
                {
                    neighbor = road.getSource();
                }

                if(visited.contains(neighbor))
                {
                    continue;
                }

                int newDistance = distances.get(current) + road.getDistance();

                if(newDistance < distances.get(neighbor))
                {
                    distances.put(neighbor, newDistance);
                    previousTown.put(neighbor, current);
                }
            }
        }
    }

    private Town getClosestUnvisitedTown(HashSet<Town> visited)
    {
        Town closestTown = null;

        int shortestDistance = Integer.MAX_VALUE;

        for(Town town : towns)
        {
            if(!visited.contains(town) && distances.get(town) < shortestDistance)
            {
                shortestDistance = distances.get(town);
                closestTown = town;
            }
        }

        return closestTown;
    }
}