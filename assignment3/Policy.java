/**
*The Policy class represents a policy, with its amount and its policy number
*there are 3 versions of the policy object, the policy, expiring policy and 
*depreciating policy
* @author Yuheng Cheng
* @version 1.0
*/
public class Policy {
    private static int NEXT_POLICY_NUMBER = 1;
    /**  attributes */ 
    private     int     policyNumber;
    protected   float   amount;
    /**
    *creates a new policy object with the given float as the amount of the policy
    *and sets the policy number according to the counter
    *@param amt is a float representing the policy value
     */
    public Policy(float amt) {
        amount = amt;
        policyNumber = NEXT_POLICY_NUMBER++;
    }
    /**gets the policy number of the policy
    *@return the policy number
     */
    public int getPolicyNumber() { return policyNumber; }
    /**gets the value of the policy
    *@return the amount
     */
    public float getAmount() { return amount; }
    /**converts the attributes into a readable format
    *@return the readable format
     */
    public String toString() {
        return String.format("Policy: %04d amount: $%1.2f", policyNumber, amount);
    }
    /**method made for double dispatching
    *@return the amount
     */
    public float handleClaim(){
        return amount;
    }
    /**returns if the policy is expired or not
    *@return false
     */
    public boolean isExpired() {
        return false;
    }
}
