import java.util.*;
public class Town implements Comparable<Town> {
	private String name;
	private List<Town> adjacents;
	
	public Town(String name) {
		this.name = name;
		adjacents = new ArrayList<>();
	}
	
	public Town(Town templateTown)
	{
	    this.name = templateTown.name;
	    this.adjacents = new ArrayList<>(templateTown.adjacents);
	}
	
	public Town() {
		this("default");
	}
	
	public String getName() {
		return name;
	}
	
	public List<Town> getAdjacents() {
		return adjacents;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAdjacents(List<Town> adjacents) {
		this.adjacents = adjacents;
	}

	@Override
	public int compareTo(Town other) {
		return this.name.compareTo(other.getName());
	}

	@Override
	public String toString() {
		return "Town [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		return Objects.equals(name, other.name);
	}
}
