public class Wolf extends Animal {

    public Wolf(Simulator simulator){
        super(simulator);
    }

    public void eat(){
        int [] allX = new int[getSimulator().getCurrentMoose().size()];
        int [] allY = new int[getSimulator().getCurrentMoose().size()];
        int wolfX = getLocationX();
        int wolfY = getLocationY();

        for (Moose moose: getSimulator().getCurrentMoose()) {
            int mooseX = moose.getLocationX();
            int mooseY = moose.getLocationY();
            if(mooseX == wolfX & mooseY == wolfY) {
                moose.die();
                setEnergy(getEnergy() + getSimulator().getEnergyGainFromEatingMoose());
            }
        }
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
