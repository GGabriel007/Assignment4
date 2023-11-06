
/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents Management Company Object
 * Due: 11/05/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/

public class ManagementCompany {

	// Constants
	
	private static final int MAX_PROPERTY = 5; 
	private static final int MGMT_WIDTH = 10;
	private static final int MGMT_DEPTH = 10; 
	
	// Attributes
	
	private String name;
	private String taxID; 
	private double mgmtFeePer;
	private Property[] properties;
	private Plot plot; 
	private int numberOfProperties;
	
	// Constructors 
	
	
	
	public ManagementCompany(String name, String taxID, double mgmtFeePer) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmtFeePer = mgmtFeePer;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH); 
		this.numberOfProperties = 0;
		
	}	
	
	// Getter and Setter methods 
	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	
	public double getMgFeePer() {
		return mgmtFeePer;
	}
	
    public void setMgmFeePer(double mgmtFeePer) {
        this.mgmtFeePer = mgmtFeePer;
    }
	
	public Property[] getProperties() {
		return properties;
	}
	
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	public int getNumberOfProperties() {
		return numberOfProperties; 
	}
	
	//Additional Methods 
	
	public int addProperty(String name, String city, double rent, String owner) {
	    // Check if the array is full
	    if (numberOfProperties >= MAX_PROPERTY) {
	        return -1;
	    }

	    // Create a new Property object
	    Property newProperty = new Property(name, city, rent, owner);

	    // Check if the Property object is null
	    if (newProperty == null) {
	        return -2;
	    }

	    // Check if the property plot is encompassed by the management company plot
	    if (!plot.encompasses(newProperty.getPlot())) {
	        return -3;
	    }

	    // Check if the property plot overlaps with any existing property plots
	    for (int i = 0; i < numberOfProperties; i++) {
	        if (properties[i].getPlot().overlaps(newProperty.getPlot())) {
	            return -4;
	        }
	    }

	    // Add the property to the array and return the index
	    properties[numberOfProperties] = newProperty;
	    numberOfProperties++;
	    return numberOfProperties - 1;
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
	    // Check if the array is full
	    if (numberOfProperties >= MAX_PROPERTY) {
	        return -1;
	    }

	    // Create a new Plot object with the provided coordinates
	    Plot propertyPlot = new Plot(x, y, width, depth);

	    // Create a new Property object
	    Property newProperty = new Property(name, city, rent, owner, propertyPlot);

	    // Check if the Property object is null
	    if (newProperty == null) {
	        return -2;
	    }

	    // Check if the property plot is encompassed by the management company plot
	    if (!plot.encompasses(propertyPlot)) {
	        return -3;
	    }

	    // Check if the property plot overlaps with any existing property plots
	    for (int i = 0; i < numberOfProperties; i++) {
	        if (properties[i].getPlot().overlaps(propertyPlot)) {
	            return -4;
	        }
	    }

	    // Add the property to the array and return the index
	    properties[numberOfProperties] = newProperty;
	    numberOfProperties++;
	    return numberOfProperties - 1;
	}

	public int addProperty(Property property) {
	    // Check if the array is full
	    if (numberOfProperties >= MAX_PROPERTY) {
	        return -1;
	    }

	    // Check if the Property object is null
	    if (property == null) {
	        return -2;
	    }

	    // Check if the property plot is encompassed by the management company plot
	    if (!plot.encompasses(property.getPlot())) {
	        return -3;
	    }

	    // Check if the property plot overlaps with any existing property plots
	    for (int i = 0; i < numberOfProperties; i++) {
	        if (properties[i].getPlot().overlaps(property.getPlot())) {
	            return -4;
	        }
	    }

	    // Add the property to the array and return the index
	    properties[numberOfProperties] = property;
	    numberOfProperties++;
	    return numberOfProperties - 1;
	}

	
	public double getTotalRent() {
		double totalRent = 0.0;
		for (int i = 0; i < numberOfProperties; i++) {
			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
		}
	
	public Property getHighestRentPropperty() {
	    if (numberOfProperties == 0) {
	        return null; // No properties available
	    }

	    Property highestRentProperty = properties[0];

	    for (int i = 1; i < numberOfProperties; i++) {
	        if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
	            highestRentProperty = properties[i];
	        }
	    }

	    return highestRentProperty;
	}

	public void removeLastProperty() {
	    if (numberOfProperties > 0) {
	        properties[numberOfProperties - 1] = null;
	        numberOfProperties--;
	    }
	}

	public boolean isPropertiesFull() {
	    return numberOfProperties >= MAX_PROPERTY;
	}

	public int getPropertiesCount() {
	    return numberOfProperties;
	}

	public boolean isMangementFeeValid() {
	    return mgmtFeePer >= 0 && mgmtFeePer <= 100;
	}

	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
	    result.append("______________________________________________________\n");
	    
	    for (int i = 0; i < numberOfProperties; i++) {
	        Property property = properties[i];
	        result.append(property.getPropertyName()).append(",").append(property.getCity())
	              .append(",").append(property.getOwner()).append(",").append(property.getRentAmount()).append("\n");
	    }
	    
	    result.append("______________________________________________________\n");
	    result.append("\n total management Fee: ").append(getTotalRent() * (mgmtFeePer / 100.0));
	    
	    return result.toString();
	}



	
}
