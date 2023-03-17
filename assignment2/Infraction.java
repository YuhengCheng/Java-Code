import java.util.*;
public class Infraction{

    private double amt = 0;
    private String desc = "";
    private Date di ;
    private boolean out = true;
    private Driver d;
    
    public Infraction(double amount, String description, Date date){
        amt = amount;
        desc = description;
        di = date;
       
    }
    public Infraction(){
        
        this(100,"",new Date());
       
    }
    public void setDriver(Driver driver){
        this.d = driver;
    }

    public double getAmount(){
    return this.amt;
    }
    public String getDescription(){
    return this.desc;
    }
    public Date getDate(){
    return this.di;
    }
    public boolean getOutstanding(){
    return this.out;
    }
    public Driver getDriver(){
    return this.d;
    }
     public String toString(){
         if (out == false){
            return "$" + String.format("%.2f", getAmount())+" Infraction on "+String.format("%tc",getDate())+" [PAID IN FULL]";

        }else{
            return "$" + String.format("%.2f", getAmount())+" Infraction on "+String.format("%tc",getDate())+" [OUTSTANDING]";

        }
   
  }
  public void pay(){
       this.out = false;
   }
}