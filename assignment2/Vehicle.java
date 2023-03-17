public class Vehicle{

    private String mk = "";
    private String md = "";
    private int y = 0;
    private String c = "";
    public String plate = "";
    public Driver owner;
    public boolean reportedStolen = false;
    
    public Vehicle(String make, String model, int year, String color, String aPlate){
        mk = make;
        md = model;
        y = year;
        c = color;
        plate = aPlate;
        
    }
    public Vehicle(){
        this("Honda","Civic",1998,"blue","X5T6Y8");
       
    }
    public void setOwner(Driver driver){
        this.owner = driver;
    }
    public void setStolen(){
        this.reportedStolen = true;
    }
    
    public String getMake(){
    return this.mk;
    }
    public String getModel(){
    return this.md;
    }
    public int getYear(){
    return this.y;
    }
    public String getColor(){
    return this.c;
    }
    public String getPlate(){
    return this.plate;
    }
    public Driver getOwner(){
    return this.owner;
    }
    public boolean getReported(){
    return this.reportedStolen;
    }
    public String toString(){
    return "A " + this.getColor()+" "+this.getYear()+" "+this.getMake()+" "+this.getModel()+" with plate "+this.getPlate();
  }

}