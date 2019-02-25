import java.util.ArrayList;

public class Wolf extends Animal {

    public Wolf(Simulator simulator) {
        super(simulator);
    }

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

    public Wolf reproduce() {
        if (getEnergy() >= 200) {
            setEnergy(getSimulator().getInitialEnergy());
            Wolf wolf = new Wolf(getSimulator());
            return wolf;
        }
        return null;
    }

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
