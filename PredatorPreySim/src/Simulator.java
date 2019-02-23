import java.util.ArrayList;

/**
 * This class defines initial values and basic actions that happen each
 * iteration of the simulation.
 */
public abstract class Simulator {
    // -----------------------------------------------------------------------
    // INITIAL SETTINGS - These need to be adjusted to get simulation to work
    // The goal is to find settings for a sustainable wolf and moose population.
    // -----------------------------------------------------------------------
    // Size of Isle Royale
    private final int maxX = 30;
    private final int maxY = 30;

    // Initial populations
    private int initialMoose = 500;
    private int initialWolves = 5;

    // Current populations
    private ArrayList<Wolf> currentWolfs = new ArrayList<>();
    private ArrayList<Moose> currentMoose = new ArrayList<>();
    private ArrayList<Grass> currentGrass = new ArrayList<>();

    // Initial energy level in all animals
    private double initialEnergy = 100;

    // Energy cost of movement
    private double movementCost = 1.0;

    // Amount grass grows every tick
    private double grassGrowthRate = 2.0;

    // Energy gain from eating grass.
    // Also amount by which grass is decreased when eaten.
    private double energyGainFromEatingGrass = 1.0;

    // Energy gain from eating moose.
    // Moose dies when eaten
    private double energyGainFromEatingMoose = 3.0;


    // -----------------------------------------------------------------------
    // ABSTRACT METHODS
    // -----------------------------------------------------------------------

    /**
     * All animals move to an adjacent area each turn.
     * This subtract movementCost from their energy.
     */
    public abstract void animalsMove();

    /**
     * If an animal has energy < 0.0, the animal is removed from the simulation.
     */
    public abstract void animalsDie();

    /**
     * There must be food in the animal's location for it to eat.
     * <p>
     * When moose eat, they get energyGainFromEatingGrass and the grass is
     * depleted by the same amount.
     * <p>
     * When a wolf eats, it gets energyGainFromEatingMoose and the moose dies.
     */
    public abstract void animalsEat();

    /**
     * Animals whose energy > 200, reproduce.
     * The animal and its offspring each get half the energy.
     */
    public abstract void animalsReproduce();

    /**
     * Consider grass ranges from 0.0 to 10.0.
     * 0.0 means no grass.
     * 10.0 is long grass.
     * <p>
     * Every tick, every patch of grass > 0.0 grows by the grassGrowthRate.
     * Grass maxes out at 10.0.
     * If grass >= 10.0, then it seeds the areas around it where grass == 0.0.
     * A patch of grass that is seeded will increase from 0.0 to grassGrowthRate.
     */
    public abstract void grassGrows();

    /**
     * Main program loop.
     * Calls tick() each iteration.
     */
    public abstract void run();

    // -----------------------------------------------------------------------
    // CONCRETE METHODS
    // -----------------------------------------------------------------------
    protected int randomInt(int max) {
        return (int) (Math.random() * (max + 1));
    }

    // Each iteration of the simulation is a tick
    public void tick() {
        animalsMove();
        animalsDie();
        animalsEat();
        animalsReproduce();
        grassGrows();
    }

    // -----------------------------------------------------------------------
    // GETTERS & SETTERS
    // -----------------------------------------------------------------------
    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getInitialMoose() {
        return initialMoose;
    }

    public void setInitialMoose(int initialMoose) {
        this.initialMoose = initialMoose;
    }

    public int getInitialWolves() {
        return initialWolves;
    }

    public void setInitialWolves(int initialWolves) {
        this.initialWolves = initialWolves;
    }

    public ArrayList<Wolf> getCurrentWolfs() {
        return currentWolfs;
    }

    public void setCurrentWolfs(ArrayList<Wolf> currentWolfs) {
        this.currentWolfs = currentWolfs;
    }

    public ArrayList<Moose> getCurrentMoose() {
        return currentMoose;
    }

    public void setCurrentMoose(ArrayList<Moose> currentMoose) {
        this.currentMoose = currentMoose;
    }

    public ArrayList<Grass> getCurrentGrass() {
        return currentGrass;
    }

    public void setCurrentGrass(ArrayList<Grass> currentGrass) {
        this.currentGrass = currentGrass;
    }


    public double getInitialEnergy() {
        return initialEnergy;
    }

    public void setInitialEnergy(double initialEnergy) {
        this.initialEnergy = initialEnergy;
    }

    public double getMovementCost() {
        return movementCost;
    }

    public void setMovementCost(double movementCost) {
        this.movementCost = movementCost;
    }

    public double getGrassGrowthRate() {
        return grassGrowthRate;
    }

    public void setGrassGrowthRate(double grassGrowthRate) {
        this.grassGrowthRate = grassGrowthRate;
    }

    public double getEnergyGainFromEatingGrass() {
        return energyGainFromEatingGrass;
    }

    public void setEnergyGainFromEatingGrass(
            double energyGainFromEatingGrass) {
        this.energyGainFromEatingGrass = energyGainFromEatingGrass;
    }

    public double getEnergyGainFromEatingMoose() {
        return energyGainFromEatingMoose;
    }

    public void setEnergyGainFromEatingMoose(
            double energyGainFromEatingMoose) {
        this.energyGainFromEatingMoose = energyGainFromEatingMoose;
    }

}
