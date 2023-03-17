import java.lang.*;
class IndividualClient extends Client{
    public IndividualClient(String Name){
        super(Name);
    }
    @Override
    public float makeClaim(int polNum){
        float returnAmt =0;
        if(getPolicy(polNum) != null){
            if(this.getPolicy(polNum) instanceof DepreciatingPolicy && this.getPolicy(polNum).isExpired() != true){
                ((DepreciatingPolicy) getPolicy(polNum)).depreciate();
                returnAmt = getPolicy(polNum).getAmount();
            }else if(this.getPolicy(polNum) instanceof ExpiringPolicy && this.getPolicy(polNum).isExpired() != true){
                if(getPolicy(polNum).isExpired())
                returnAmt= this.getPolicy(polNum).getAmount();
            }else if(this.getPolicy(polNum) instanceof Policy && this.getPolicy(polNum).isExpired() != true){
                returnAmt= getPolicy(polNum).getAmount();
                this.cancelPolicy(polNum);
            }
        }
        return returnAmt;
    }

}