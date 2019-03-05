import java.util.ArrayList;

public class Moose extends Animal {

    public Moose(Simulator simulator) {
        super(simulator);
    }
    /**
     * Increases the animal's energy by consuming a food source.
     * Moose consumes grass if present in the same location. Decreasing the grass
     * by grassGrowthRate.
     */
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
    /**
     * If the animal's energy > 200.0, the spawn a new animal.
     * Both animals get half the total energy.
     *
     * @return the new animal
     */
    public Moose reproduce() {
        if (getEnergy() >= 150) {
            setEnergy(getSimulator().getInitialEnergy());
            Moose moose = new Moose(getSimulator());
            return moose;
        }
        return null;
    }

    /**
     * Animals with energy < 0.0 die and are removed from the game.
     *
     * @return the dead animal or null if animal survives.
     */
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
