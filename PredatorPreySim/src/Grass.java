import java.util.ArrayList;

public class Grass {
    private Simulator simulator;
    private int locationX;
    private int locationY;
    private double CurrentGrowth;

    // ---------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------
    public Grass(Simulator simulator) {
        this.simulator = simulator;
        CurrentGrowth = simulator.getGrassGrowthRate();
    }

    // ---------------------------------------
    // METHODS
    // ---------------------------------------
    public void grow() {
        double current = getCurrentGrowth();
        current += simulator.getGrassGrowthRate();
        setCurrentGrowth(current);
    }

    public void spread() {
        if (getCurrentGrowth() >= 10) {
            for (int i = 0; i < 9; i++) {
                Grass newGrass = new Grass(simulator);
                setCurrentGrowth(10);
                //Choose a space for the Grass to spread too
                int xCord = getLocationX(); // x location of original grass
                int yCord = getLocationY(); // y location of original grass
                if (xCord == 0) {
                    newGrass.setLocationX(xCord + 1);
                } else if (xCord == simulator.getMaxX()) {
                    setLocationX(xCord - 1);
                } else {
                    int rando = (int) (Math.random() * 3) - 1;
                    newGrass.setLocationX(xCord + rando);
                }
                if (yCord == 0) {
                    newGrass.setLocationY(yCord + 1);
                } else if (yCord == simulator.getMaxY()) {
                    newGrass.setLocationY(yCord - 1);
                } else {
                    int rando = (int) (Math.random() * 3) - 1;
                    newGrass.setLocationY(yCord + rando);
                }
                int newGrassX = newGrass.getLocationX();
                int newGrassY = newGrass.getLocationY();

                //determines if there is already grass in the space its moving too
                for (Grass grass : simulator.getCurrentGrass()) {
                    int isThereX = grass.getLocationX();
                    int isThereY = grass.getLocationY();
                    if (newGrassX != isThereX & newGrassY != isThereY) {
                        ArrayList<Grass> temp = new ArrayList<>();
                        temp = simulator.getCurrentGrass();
                        temp.add(newGrass);
                        simulator.setCurrentGrass(temp); //adds grass to the world
                    }
                }

            }
        }

    }

    public void getEaten() {
        if (getCurrentGrowth() <= 0) {
            ArrayList<Grass> temp;
            temp = simulator.getCurrentGrass();
            temp.remove(this);
            simulator.setCurrentGrass(temp);
        } else {
            double timeToGetFucked = getCurrentGrowth();
            timeToGetFucked -= simulator.getEnergyGainFromEatingGrass();
            setCurrentGrowth(timeToGetFucked);
        }
    }


    // ---------------------------------------
    // GETTERS AND SETERS
    // ---------------------------------------
    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public double getCurrentGrowth() {
        return CurrentGrowth;
    }

    public void setCurrentGrowth(double currentGrowth) {
        this.CurrentGrowth = currentGrowth;
    }


}

