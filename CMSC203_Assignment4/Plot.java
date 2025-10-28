package mypackage;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: The Plot class represents a rectangular area with methods to check overlapping, or if they encompass each other.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Paul Huaylinos
*/

public class Plot {
	private int depth;
	private int width;
	private int x;
	private int y;
	
	public Plot() {
		this.depth = 1;
		this.width = 1;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	public Plot(Plot otherPlot) {
		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	}
	
	public int getDepth() {
		return this.depth;
	}
	public int getWidth() {
		return this.width;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean overlaps(Plot plot) {
		return !((this.x + this.width) < (plot.x) ||
				(plot.x + plot.width) <= (this.x) ||
				(this.y + this.depth) < (plot.y) ||
				(plot.y + plot.depth) <= (this.y)); 
	}
	public boolean encompasses(Plot plot) {
		return (this.x + this.width) >= (plot.x + plot.width) &&
				(this.y + this.depth) >= (plot.y + plot.depth) &&
				(this.x <= plot.x) && (this.y <= plot.y);
	}
	@Override
	public String toString() {
		return (this.x + "," + this.y + "," + this.width + "," + this.depth);
	}
}
