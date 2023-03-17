class CompanyClient extends Client{
    public CompanyClient(String Name){
            super(Name);
        }
     @Override
    public float makeClaim(int polNum){
        float returnAmt = 0;
        if (this.getPolicy(polNum) != null){
        returnAmt= this.getPolicy(polNum).handleClaim();
        }
        return returnAmt;
    }

}