import java.util.*;
public class PoliceDatabase{
    public Vehicle[] vehicles;
    public int numVehicles = 0;
    public Driver[] drivers;
    public int numDrivers = 0;
    public Infraction[] infractions;
    public int numInfractions = 0;
    static int dCap = 2000;
    static int vCap = 1000;
    static int iCap = 800;

    public PoliceDatabase(){
        vehicles = new Vehicle[vCap];
        drivers = new Driver[dCap];
        infractions = new Infraction[iCap];
    }
     
    public void registerDriver(Driver aDriver){
    if(numDrivers < dCap){
        drivers[numDrivers] = aDriver;
        numDrivers += 1;
    }
   }
   public void registerVehicle(Vehicle aVehicle, String license){
       if(numVehicles < vCap){
           for( int j=0; j < numDrivers; j+=1){
               if (drivers[j].getLicense() == license){
                   aVehicle.setOwner(drivers[j]);
               }
           }
           vehicles[numVehicles] = aVehicle;
           numVehicles += 1;
       }
   }
   public void unregisterVehicle(String plate){
      
        for( int j=0; j < numVehicles; j+=1){
            if (vehicles[j].getPlate() == plate){
                for(int k = j; k <numVehicles-1; k+=1){
                   vehicles[k] = vehicles[k+1]; 
                }
            }
        }
        numVehicles = numVehicles - 1;
       
   }
   public void reportStolen(String plate){
         for( int j=0; j < numVehicles; j+=1){
            if (vehicles[j].getPlate() == plate){
                vehicles[j].setStolen();
            }
        }
   }
   public void changeOwner(String plate, String license){
       for( int j=0; j < numVehicles; j+=1){
            if (vehicles[j].getPlate() == plate){
                for( int k = 0; k <numDrivers; k+=1){
                    if(drivers[k].getLicense() == license){
                        vehicles[j].setOwner(drivers[k]);
                    }
                }
            }
        }
   }
   public Infraction issueInfraction (String license, float amount, String description, Date date){
       if (numInfractions < iCap){
            for (int i=0; i < numDrivers; i+=1){
                if (license == drivers[i].getLicense()){
                    infractions[numInfractions] = new Infraction(amount,description,date);
                    infractions[numInfractions].setDriver(drivers[i]);
                    numInfractions +=1;
                }
       }return infractions[numInfractions-1];
       
        }else{
            return null;
        }
        
   }
       
    public boolean hasOutstandingInfractions (Driver d){
        boolean outStnd = false;
        for (int i=0; i < numInfractions; i+=1){
            if (infractions[i].getDriver() == d){
                if (infractions[i].getOutstanding() == true){
                    outStnd = true;

                }
            }
        }
        return outStnd;
    }
    public boolean shouldStopVehicle(String plate){
        boolean stop = false;
        for (int i=0; i < numVehicles; i+=1){
            if (vehicles[i].getPlate() == plate){
                if (vehicles[i].getReported() == true){
                stop = true;
                }else if(hasOutstandingInfractions(vehicles[i].getOwner())){
                 stop = true;
                }
            }
    }
    return stop;
    }
    public void showInfractionsFor(String license){
        int out = 0;
        for (int i=0; i < numInfractions; i+=1){
            if (license == infractions[i].getDriver().getLicense()){
                System.out.println(infractions[i].toString());
                if (infractions[i].getOutstanding() == true){
                    out +=1;
                }
            }
            
        }
        System.out.println("Total outstanding infractions = "+out);
    }   
    public Driver[] cleanDrivers(){
        boolean clean = true;
        int cleanLen = 0;
        int[] cleanInd = new int[numDrivers]; 
        
        for (int i=0; i < numDrivers; i+=1){
            clean = true;
            for (int j =0; j < numInfractions; j+=1){
                if (drivers[i] == infractions[j].getDriver()){
                    clean = false;
                }

            }
            if (clean == true){
                cleanInd[cleanLen] = i;
                cleanLen +=1;


            }
        
        }
        Driver[] cleanDriver = new Driver[cleanLen];
        for(int i=0; i < cleanLen; i+=1){
            cleanDriver[i] = drivers[cleanInd[i]];
        }
        return cleanDriver;
    }
    public void showInfractionReport(){
        int[] infDrivers= new int[numInfractions];
        int driversInf = 0;
        double driversTot = 0;
         for (int i=0; i < numDrivers; i+=1){
             driversInf = 0;
             driversTot = 0;
             for (int j =0; j < numInfractions;  j+=1){
                 if (drivers[i]== infractions[j].getDriver()){
                    driversInf += 1;
                    if (infractions[j].getOutstanding() == false){
                        driversTot += infractions[j].getAmount();
                    }

                 }
           

            }
            if (driversInf >0){System.out.println(String.format("%20s",drivers[i].getName())+": "+driversInf+" infractions, total paid = $"+String.format("%6.2f", driversTot));
             }
         
    }


    }
   
    public static  PoliceDatabase example() { // Register all drivers and their vehicles
    PoliceDatabase pdb = new PoliceDatabase();

    pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
            "1323 Kenaston St.", "Gloucester", "ON"));
    pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
            "32 Rideau Rd.", "Greely", "ON"));
    pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
            "1355 Louis Lane", "Gloucester", "ON"));
    pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
            "2348 Walkley Rd.", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
            "2338 Carling Ave.", "Nepean", "ON"));
    pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
            "287 Bank St.", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
            "200 St. Laurant Blvd.", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
            "1654 Stonehenge Cres.", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
            "98 Oak Blvd.", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
            "3 Third St.", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
            "434 Gatineau Way", "Hull", "QC"));
    pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
            "123 Thurston Drive", "Kanata", "ON"));
    pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
            "22 Colonel By Drive", "Ottawa", "ON"));
    pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
            "17 Murray St.", "Nepean", "ON"));
    pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
            "3445 Bronson Ave.", "Ottawa", "ON"));
    pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
            "L0453-65433-87655");
    pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
            "L0453-65433-87655");
    pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
            "L2333-45645-54354");
    pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
            "L1234-35489-99837");
    pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
            "L2325-45789-35647");
    pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
            "L2325-45789-35647");
    pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
            "L2325-45789-35647");
    pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
            "L1948-87265-34782");
    pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
            "L0678-67825-83940");
    pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
            "L0122-43643-73286");
    pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
            "L6987-34532-43334");
    pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
            "L3345-32390-23789");
    pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
            "L3545-45396-88983");
    pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
            "L3545-45396-88983");
    pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
            "L5487-16576-38426");

    return pdb;
}
}