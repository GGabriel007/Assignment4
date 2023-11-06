/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents a Property object.
 * Due: 11/05/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/


public class Property {

	// Attributes 
	private String propertyName; 
	private String city; 
	private double rentAmount; 
	private String owner;
	private Plot plot; 
	
	// Constructors 
    public Property(String propertyName, String city, double rentAmount, String owner, Plot plot) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount; 
        this.owner = owner;

        if (plot != null) {
            this.plot = plot;
        } else {
            this.plot = new Plot(0, 0, 1, 1); // Default values for the plot
        }
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        
        this.plot = new Plot(x, y, width, depth);
    }
	
//	public Property( String propertyName, String city, double rentAmount, String owner, Plot plot) {
//	
//	this.propertyName = propertyName;
//	this.city = city;
//	this.rentAmount = rentAmount; 
//	this.owner = owner;
//	this.plot = plot;
//	
//	}
//	
//    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
//        this.propertyName = propertyName;
//        this.city = city;
//        this.rentAmount = rentAmount;
//        this.owner = owner;
//        this.plot = new Plot(x, y, width, depth);
//    }
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount; 
		this.owner = owner;
		if (plot == null) {
		    this.plot = new Plot(0, 0, 1, 1);
		} else {
		    this.plot = plot;
		}

	}
	

    
	// Getter and Setter methods
	


	public String getPropertyName() {
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city; 
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	// toString method to represent a Property instance 
	@Override
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
	
}
