import java.util.ArrayList;

public class Moose extends Animal {

    public Moose(Simulator simulator) {
        super(simulator);
    }

    public void eat() {
        int mooseX = getLocationX();
        int mooseY = getLocationY();
        //gos through every grass object and checks to see if there is one in the vacinity for the moose to eat
        for (int i = 0; i < getSimulator().getCurrentGrass().size(); i++) {
            Grass grass = getSimulator().getCurrentGrass().get(i);
            int grassX = grass.getLocationX();
            int grassY = grass.getLocationY();
            //if the moose finds grass then it eats it and its energy gos up
            if (grassX == mooseX & grassY == mooseY) {
                grass.getEaten();
                setEnergy(getEnergy() + getSimulator().getEnergyGainFromEatingGrass());
            }
        }


    }
    //if the moose has a high enough energy level then it will reproduce
    public Moose reproduce() {
        if (getEnergy() >= 200) {
            setEnergy(getSimulator().getInitialEnergy());
            Moose moose = new Moose(getSimulator());
            return moose;
        }
        return null;
    }

    //if the moose has a low enough energy level it will die
    public boolean die() {
        ArrayList<Moose> removeMoose;
        if (getEnergy() <= 0) {
            removeMoose = getSimulator().getCurrentMoose();
            removeMoose.remove(this);
            getSimulator().setCurrentMoose(removeMoose);
        }
        return Boolean.parseBoolean(null);
    }
}
