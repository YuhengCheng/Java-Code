/**
*The DepreciatingPolicy is a subclass represents a policy with a rate that depreciates with each claim
*depreciating policy
* @author Yuheng Cheng
* @version 1.0
*/
class DepreciatingPolicy extends Policy{
    /**attributes */
    private float rate;
    /**
    *creates a new depreciating policy object with the given float as the amount of the policy
    *and the rate as the float given
    *@param amt is a float representing the policy value
    *@param rt is a float representing the rate at which the value of of the claim deperectiates 
     */
    public DepreciatingPolicy(float amt, float rt){
        super(amt);
        this.rate = rt;
        
    }   
    /**gets the rate of the policy
    *@return the rate
     */
    public float getRate(){
        return rate;
    }
    /**depreciates the value of the policy by the rate
     */
    public void depreciate(){
        amount = amount*(1-rate);
    }
     /**converts the attributes into a readable format
    *@return the readable format
     */
    @Override
    public String toString() {
        float stringRate = rate*100;
        
        return "Depreciating"+super.toString()+String.format(" rate: %1.1f ",stringRate)+"%";
    }
    /**returns if the policy is expired or not
    *@return \true or false
     */
    @Override
    public boolean isExpired() {
        return (rate == 0);
    }
    /**method made for double dispatching
    *@return the amount after depreciating it
     */
    @Override
    public float handleClaim(){
        float preAmt = amount;
        this.depreciate();
        return preAmt;


    }
}