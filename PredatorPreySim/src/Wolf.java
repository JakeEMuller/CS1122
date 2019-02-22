public class Wolf extends Animal {

    public Wolf(Simulator simulator){
        super(simulator);
    }

    public void eat(){

    }

    public Wolf reproduce(){
        if( getEnergy() >= 200){
            setEnergy(getSimulator().getInitialEnergy());
            Wolf wolf = new Wolf(getSimulator());
            return wolf;
        }
        return null;
    }

    public boolean die(){
        if(getEnergy() <= 0){
        }
        return Boolean.parseBoolean(null);
    }


}
