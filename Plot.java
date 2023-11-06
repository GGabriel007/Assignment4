
/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: This class represents a Plot object.
 * Due: 11/05/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/

public class Plot {
	// Attributes 
	
	private int x; 
	private int y; 
	private int depth;
	private int width;
	
	// Constructors 
	
    public Plot(int x, int y, int width, int depth) {
        if (x >= 0 && y >= 0 && width >= 0 && depth >= 0) {
            this.x = x;
            this.y = y;
            this.width = width; 
            this.depth = depth;
        } else {
            // Handle negative values (You can set default values or throw an exception)
            // For example, you can set default values like this:
            this.x = 0;
            this.y = 0;
            this.width = 1; 
            this.depth = 1;
        }
    }
	
	// Getter and Setter methods 
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y; 
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width; 
	}
	
	public int getDepth() {
		return depth; 
	}
	
	public void setDepth(int depth) {
		this.depth = depth; 
	}
	
	// Method to check if two plots overlap 
	
	public boolean overlaps(Plot plot) {
		return !(x + width <= plot.x || plot.x + plot.width <= x || y + depth <= plot.y || plot.y + plot.depth <= y);
	}
	
	// Method to check if a plot encompasses another plot 
	
	public boolean encompasses(Plot plot) {
		return x <= plot.x && y <= plot.y && x + width >= plot.x + plot.width && y + depth >= plot.y + plot.depth;
	}
	
	// toString method to represent a Plot instance 
	@Override
	public String toString() {
		return  x + "," + y + "," + width + "," + depth; 
	}
}
