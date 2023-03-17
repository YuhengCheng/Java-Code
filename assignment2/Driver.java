public class Driver{

    private String l = "";
    private String n = "";
    private String s = "";
    private String c = "";
    private String p = "";
    
    public Driver(String license, String name, String street, String city, String province){
        l = license;
        n = name;
        s = street;
        c = city;
        p = province;
    }
    public Driver(){
        this("L0678-67825-83940","John Doe","12 Elm St.","Ottawa","ON");
       
    }
    public String getLicense(){
    return this.l;
    }
    public String getName(){
    return this.n;
    }
    public String getStreet(){
    return this.s;
    }
    public String getCity(){
    return this.c;
    }
    public String getProv(){
    return this.p;
    }
    public String toString(){
    return "#" + this.getLicense()+" "+this.getName()+" living at "+this.getStreet()+", "+this.getCity()+", "+this.getProv();
  }
   
}