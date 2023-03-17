/**
 * A Temperature object represents temperature (with a value and scale)
 * Assignment 2
 */

public class Temperature{
  
    private double cTemp = 0;
    private Scale sc = Scale.CELSIUS;
    

  

/** Initializes a temperature object with given value in Celcius
 *
 *  If the initial temperature is less than -273.15C then the temperature
 *  object will be initialized with -273.15C.
 *
 * @param temp is the initial temperature in Celsius.
 */
  public Temperature(double temp){
      if (temp < -273.5){
          setTemp(-273.15,sc);

      }else{
          setTemp(temp,sc);
      }
  }


/** Initializes a temperature object with given value using the specified scale
 * <par>
 * If the temperature is lower than absolute zero, in the given scale,
 * then set the temperature to absolute zero (in that scale).
 * <par>
 * Example: new Temperature(12.3, Scale.KELVIN)
 *
 * @param temp is the initial temperature
 * @param scale is the scale of initial temperature and must a constant
 *        defined in the Scale enum type.
 */
  public Temperature(double temp, Scale scale){
    switch(scale){
      case CELSIUS:
       if (temp < -273.15){
          this.cTemp = -273.15; 

      }else{
          this.cTemp = temp;
      }
      sc = scale;
      break;
      
      case KELVIN:
       if (temp < 0){
          this.cTemp = 0; 

      }else{
          this.cTemp = temp;
      }
      sc = scale;
      break;
    
    case FAHRENHEIT:
       if (temp < -459.67){
          this.cTemp = -459.67; 

      }else{
          this.cTemp = temp;
      }
      sc = scale;
      break;
  }
  }


/** Initializes a temperature object with given value using the specified scale
 * <par>
 * If the temperature is lower than absolute zero, in the given scale,
 * then set the temperature to absolute zero (in that scale).
 * <par>
 * Example: each of the following will create the same temerature 12.3K
 *          new Temperature(12.3, "Kelvin")
 *          new Temperature(12.3, "k")
 *          new Temperature(12.3, "kel"
 *
 * @param temp is the initial temperature
 * @param scale is a the scale of initial temperature. As long as the input stringw 
 *        can uniquely identify one of the three scales it is acceptable.
 *        Case is not important. Abbreviations are allowed.
 */
  public Temperature(double temp, String scale){
    char firstchar_s = scale.charAt(0);
    switch(firstchar_s){
      case 70:
      if (temp < -459.67){
          this.cTemp = -459.67; 

      }else{
          this.cTemp = temp;
      }
      sc = Scale.FAHRENHEIT;
      break;
      case 102:
      if (temp < -459.67){
          this.cTemp = -459.67; 

      }else{
          this.cTemp = temp;
      }
      sc = Scale.FAHRENHEIT;
      break;
      case 67:
      if (temp < -273.15){
          this.cTemp = -273.15; 

      }else{
          this.cTemp = temp;
      }
      sc = Scale.CELSIUS;
      case 99:
      if (temp < -273.15){
          this.cTemp = -273.15; 

      }else{
          this.cTemp = temp;
      }
      sc = Scale.CELSIUS;
      case 75:
      if (temp < 0){
          this.cTemp = 0; 

      }else{
          this.cTemp = temp;
      }
      sc = Scale.KELVIN;
      case 107:
      if (temp < 0){
          this.cTemp = 0; 

      }else{
          this.cTemp = temp;
      }
      sc = Scale.KELVIN;
    }
  }



 
/** getter for the scale. The output will always be one of the enum objects from Scale.
 *
 * @return the current scale of this object. 
 */
  public Scale getScale(){
    return this.sc;
  }

 /** getter for the temperature
  *
  * @return the temperature of the object using the current scale
  */
  public double getTemp(){
    return cTemp;
  }

 

  /** setter for scale
  *
  * @param scale is the new scale of the temperature and must be
  *        a constant from the Scale enum type.
  */
  public void setScale(Scale scale){
    
    switch(scale){
      case CELSIUS:
      setTemp(cTemp, scale);
      this.sc = Scale.CELSIUS;
      break;
      case KELVIN:
      setTemp(cTemp, scale);
      this.sc = Scale.KELVIN;
      break;
      case FAHRENHEIT:
      setTemp(cTemp, scale);
      this.sc = Scale.FAHRENHEIT;
      break;
    }
    
  }
  



  /** setter for temperature
  *  <par>
  * If the temperature is lower than absolute zero, in the given scale,
  * then sets the temperature to absolute zero (in that scale).
  *
  * @param temp is the new temperature
  * @param scale is the scale of the new temperature. It must be
  *        a constant from the Scale enum type.
  */
  public void setTemp(double temp, Scale scale){
    double calT = 0;
    switch(scale){
      case CELSIUS:
        switch(this.sc){
          case FAHRENHEIT:
            cTemp  = ((temp -32)*5)/9;
            break;
          case KELVIN:
            cTemp  = temp-273.15;
            break;
          default:
            cTemp  = temp;

        } 
        break;
      case KELVIN:
        switch(this.sc){
          case FAHRENHEIT:
            cTemp   = ((temp -32) * 5)/9+273.15;
            break;
          case CELSIUS:
            cTemp   = temp+273.15;
            break;
          default:
            cTemp = temp;

        }
      break;
       case FAHRENHEIT:
        switch(this.sc){
          case KELVIN:
            cTemp   = ((temp -273.15)  * 9)/5+32;
            break;
          case CELSIUS:
            cTemp  = ((temp  * 9)/5)+32;
            break;
          default:
            cTemp  = temp;

        }
        break;
    }

  }










/* ------------------------------------------------- */
/* ------------------------------------------------- */
/* do not change anything below this                 */
/* ------------------------------------------------- */
/* ------------------------------------------------- */



  /** String representation of a temperature object    */
  @Override
  public String toString(){
    return "" + this.getTemp() + this.getScale().name().charAt(0);
  }
   public static void main(String[] args){
        
        Scale s = Scale.CELSIUS;       // a variable of an enum type
        Temperature t1 = new Temperature(33.1, s);
        Temperature t2 = new Temperature(87.2, Scale.FAHRENHEIT);
        boolean b = Scale.CELSIUS == s;   // will be true! can compare with ==

        System.out.println("Make a Temperature object");
        System.out.println("> Temperature t = new Temperature(10.1)");
        Temperature t = new Temperature(10.1);
        System.out.println(">> t.getScale() -> " + t.getScale());    // outputs Scale.CELSIUS.toString()
        System.out.println(">> t.toString() -> " + t);               // outputs 10.1C
        System.out.println("> t.setScale(Scale.FAHRENHEIT)");
        
        t.setScale(Scale.FAHRENHEIT);                                // change scale
        System.out.println(">> t.toString() -> " + t);               // outputs 50.18F
        System.out.println(">> t.getScale() -> " + t.getScale());    // outputs Scale.FAHREHEIT.toString()

        System.out.println("> t = new Temperature(12.25, \"Kel\")");
        t = new Temperature(12.25, "Kel");              // must recognize short form
        System.out.println(">> t.toString() -> " + t);  // outputs 12.25K


}

}