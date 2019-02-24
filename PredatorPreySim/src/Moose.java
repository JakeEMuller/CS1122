import java.util.ArrayList;

public class Moose extends Animal {

    public Moose(Simulator simulator){
        super(simulator);
    }

    public void eat(){
        int mooseX = getLocationX();
        int mooseY = getLocationY();
        for (Grass grass: getSimulator().getCurrentGrass()) {
            int grassX = grass.getLocationX();
            int grassY = grass.getLocationY();
            if(grassX == mooseX & grassY == mooseY) {
                grass.getEaten();
                return;
            }
        }

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
        ArrayList<Moose> removeMoose;
        if(getEnergy() <= 0) {
             removeMoose = getSimulator().getCurrentMoose();
             removeMoose.remove(this);
             getSimulator().setCurrentMoose(removeMoose);
         }
        return Boolean.parseBoolean(null);
    }
}
