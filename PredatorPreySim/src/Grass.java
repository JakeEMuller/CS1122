public class Grass {
    private Simulator simulator;
    private int locationX;
    private int locationY;
    private double CurrentGrowth;

    // ---------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------
    public Grass(Simulator simulator){
        this.simulator = simulator;
        CurrentGrowth = simulator.getGrassGrowthRate();
    }

    // ---------------------------------------
    // METHODS
    // ---------------------------------------
    public void grow(){
        double current = getCurrentGrowth();
        current += simulator.getGrassGrowthRate();
        setCurrentGrowth(current);
    }

    public Grass spread(){
        if(getCurrentGrowth() >= 10  ){
            setCurrentGrowth(10);
            Grass newGrass = new Grass(simulator);
            
            for(Grass grass: simulator.getCurrentGrass() ){

            }

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

