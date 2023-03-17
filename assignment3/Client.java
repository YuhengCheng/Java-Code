import java.util.Date;
import java.lang.*;
public abstract class Client {
    private static final int MAX_POLICIES_PER_CLIENT = 10;

    private static int NEXT_CLIENT_ID = 1;

    private   String        name;
    private   int           id;
    protected Policy[]      policies;
    protected int           numPolicies;

    public Client(String n) {
        name = n;
        id = NEXT_CLIENT_ID++;
        policies = new Policy[MAX_POLICIES_PER_CLIENT];
        numPolicies = 0;
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
    public Policy[] getPolicies() { return policies; }
    public int getNumPolicies() { return numPolicies; }

    public String toString() {
        return ""+this.getClass().getClass()+String.format(" Client: %06d amount: %s", id, name);
    }

    public float totalCoverage(){
        float totalAmount=0;
        for(int i=0;i <getNumPolicies(); i++){
            totalAmount +=getPolicies()[i].getAmount();
        }
        return totalAmount;
    }

    public Policy addPolicy(Policy P){
        if(getNumPolicies() < MAX_POLICIES_PER_CLIENT){
            policies[numPolicies] = P;
            numPolicies+=1;
            return P;
        }else{
            return null;
        }
        
    }
    public Policy openPolicyFor(float amt){
        return addPolicy(new Policy(amt));
    }

    public Policy openPolicyFor(float amt, float rate ){
        return addPolicy(new DepreciatingPolicy(amt,rate));
    }

    public Policy openPolicyFor(float amt, Date expire ){
        return addPolicy(new ExpiringPolicy(amt, expire));
    }

    public Policy getPolicy(int polNum){
        Policy found = null;
        if (this.getNumPolicies() != 0){
        for (int i = 0; i < numPolicies-1;i++){
            if(policies[i]!= null){
                if(polNum == policies[i].getPolicyNumber()){
                    found = policies[i];
                    break;
                }
            }

        }
        }
        return found;
    }

    public boolean cancelPolicy(int polNum){
        boolean canceled = false;
        for (int j = 0; j < numPolicies-1;j++){
            if(policies[j]!= null){
                if(polNum == getPolicies()[j].getPolicyNumber()){
                    policies[j] = policies[numPolicies-1];
                    policies[numPolicies-1] = null;
                    canceled = true;
                    numPolicies -=1;
                    break;
                }
            }
        }
        return canceled;

    }


        abstract float makeClaim(int polNum);

}
