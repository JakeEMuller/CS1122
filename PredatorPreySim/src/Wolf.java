import java.util.ArrayList;

public class Wolf extends Animal {

    public Wolf(Simulator simulator) {
        super(simulator);
    }
    /**
     * Increases the animal's energy by consuming a food source.
     * Wolf consumes moose if in the same location. Killing the moose.
     */
    public void eat() {
        int wolfX = getLocationX();
        int wolfY = getLocationY();

        // Determine if there is a Moose on the same square as the wolf
        for (int i = 0; i < getSimulator().getCurrentMoose().size(); i++) {
            Moose moose = getSimulator().getCurrentMoose().get(i);
            int mooseX = moose.getLocationX();
            int mooseY = moose.getLocationY();
            if (mooseX == wolfX & mooseY == wolfY) {
                moose.setEnergy(0);
                moose.die();
                setEnergy(getEnergy() + getSimulator().getEnergyGainFromEatingMoose());
                return;
            }
        }

    }
    /**
     * If the animal's energy > 200.0, the spawn a new animal.
     * Both animals get half the total energy.
     *
     * @return the new animal
     */
    public Wolf reproduce() {
        if (getEnergy() >= 600) {
            setEnergy(getSimulator().getInitialEnergy());
            Wolf wolf = new Wolf(getSimulator());
            return wolf;
        }
        return null;
    }
    /**
     * Animals with energy < 0.0 die and are removed from the game.
     *
     * @return the dead animal or null if animal survives.
     */
    public boolean die() {
        ArrayList<Wolf> removeWolf;
        if (getEnergy() <= 0) {
            removeWolf = getSimulator().getCurrentWolfs();
            removeWolf.remove(this);
            getSimulator().setCurrentWolfs(removeWolf);
        }
        return Boolean.parseBoolean(null);
    }


}
