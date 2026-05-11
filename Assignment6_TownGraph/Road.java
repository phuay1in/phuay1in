
public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int distance;
	private String name;
	
	public Road(Town source, Town destination, int distance, String name) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.name = name;
	}
	
	public Town getSource()
	{
	    return source;
	}

	public Town getDestination()
	{
	    return destination;
	}

	public int getDistance()
	{
	    return distance;
	}

	public String getName()
	{
	    return name;
	}

	public void setSource(Town source) {
		this.source = source;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean contains(Town town)
	{
	    return source.equals(town) || destination.equals(town);
	}
	
	@Override
	public int compareTo(Road other)
	{
	    return this.name.compareTo(other.name);
	}
	
	@Override
	public String toString() {
		return  "Name=" + name;
	}

	@Override
	public int hashCode() {
		 return source.hashCode() + destination.hashCode(); // Direction doesn't matter, A-B is the same as B-A	
	}

	@Override
	public boolean equals(Object obj)
	{
	    if(this == obj)
	        return true;

	    if(obj == null || getClass() != obj.getClass())
	        return false;

	    Road other = (Road) obj;

	    return (source.equals(other.source) && destination.equals(other.destination)) || 
	    	   (source.equals(other.destination) && destination.equals(other.source)); // A-B equals B-A
	}
	
	
}
