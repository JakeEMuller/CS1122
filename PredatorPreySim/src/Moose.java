
public class Moose extends Animal {

    public Moose(Simulator simulator){
        super(simulator);
    }

    public void eat(){

    }

    public Moose reproduce(){
        if( getEnergy() >= 200){
            setEnergy(getSimulator().getInitialEnergy());
            Moose moose = new Moose(getSimulator());
            return moose;
        }
        return null;
    }

    public boolean die(){
        return Boolean.parseBoolean(null);
    }
}
