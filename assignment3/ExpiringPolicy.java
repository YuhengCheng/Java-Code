/**
*The ExpiringPolicy is a subclass represents a policy which expires at a certain date
* @author Yuheng Cheng
* @version 1.0
*/
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

class ExpiringPolicy extends Policy{
     /**attributes */
 private Date expiryDate;
    /**
    *creates a new expiring policy object with the given float as the amount of the policy
    *and sets the expiry date as a year from now
    *@param amt is a float representing the policy value
     */
    public ExpiringPolicy(float amt){
        super(amt);
        GregorianCalendar aCalendar = new GregorianCalendar();
        aCalendar.add(Calendar.YEAR,1);
        expiryDate = aCalendar.getTime();

    }
    /**
    *creates a new expiring policy object with the given float as the amount of the policy
    *and sets the expiry date as the given date
    *@param amt is a float representing the policy value
    *@param date is a date that represents the expiry date of the policy
     */
    public ExpiringPolicy(float amt,Date date){
        super(amt);
        expiryDate = date;

    }
     /**returns if the policy is expired or not
    *@return \true or false
     */
    @Override
    public boolean isExpired(){
        Date current = new Date();
        GregorianCalendar aCalendar = new GregorianCalendar();
        return (expiryDate.before(current)||expiryDate.equals(current));
    }
    /**converts the attributes into a readable format
    *@return the readable format
     */
    @Override
    public String toString() {
        
        if (this.isExpired()){
            return "Expiring"+super.toString()+" expired on: "+ new SimpleDateFormat ("MMMM dd, yyyy (hh:mm a)").format(expiryDate);
        }else{
            return "Expiring"+super.toString()+" expires on: "+ new SimpleDateFormat ("MMMM dd, yyyy (hh:mm a)").format(expiryDate);
        }
    }
    /**method made for double dispatching
    *@return the amount after checking if it is depreciated
     */
    @Override
    public float handleClaim(){
        float returnAmt = amount;
        if(this.isExpired()){
            returnAmt = 0;

        }
        return returnAmt;

    }
}