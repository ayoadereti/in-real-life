public class Driver implements Comparable<Driver> {
    
    protected String name;
    protected double area;
   // int static comparisonVal;
    
    
    // Default constructor: creates empty Driver object 
    public Driver() {
        
        name = " "; // initialize name with empty string 
        area = 0.0; // set area to zero 
        
    }
    
    // Overloaded constructor: passes in driver name
    public Driver(String name, double area) {
        
        this.name = name;
        this.area = area;
    }
    
    // Accessor for driver names 
    public String getDriverName() {
        return name;
    }
    
     // Accessor for driver areas 
    public double getDriverArea() {
        return area;
    }
    
    // Mutator for driver names 
    public void setDriverName(String name) {
        this.name = name;
    }
    
    // Mutator for driver areas 
    public void setDriverArea(double area) {
        this.area = area;
    }
    
    // Returns result of String compareTo() method between driver names
    @Override
    public int compareTo(Driver obj) {
        return this.name.compareTo(obj.getDriverName());
        
      /* if (this.name < dr.name) {
           return -1;
       }
       if (this.name > dr.name) {
           return 1;
       }
       if (this.name == dr.name)
	    return 0;*/
    }
    
    // Returns formatted string containing name and data 
    @Override
    public String toString() {
        String formattedStr = String.format("%s\t%.2f\n", name, area);
        return formattedStr;
    }
}
