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
            setCurrentGrowth(2);
            boolean isLeft = false;
            boolean isRight = false;
            boolean isAbove = false;
            boolean isBelow = false;
            boolean leftUp = false;
            boolean rightUp = false;
            boolean leftDown = false;
            boolean rightDown = false;

            Grass newGrass = new Grass(simulator);
            int xCord = getLocationX(); // x location of original grass
            int yCord = getLocationY(); // y location of original grass

            //checks to see if surrounding tiles are filled with grass
            for (int j = 0; j < simulator.getCurrentGrass().size(); j++) {

                Grass grass = simulator.getCurrentGrass().get(j);

                if (xCord + 1 == grass.getLocationX() & yCord == grass.getLocationY()) {
                    isRight = true;
                }
                if (xCord - 1 == grass.getLocationX() & yCord == grass.getLocationY()) {
                    isLeft = true;
                }
                if (yCord - 1 == grass.getLocationY() & xCord == grass.getLocationX()) {
                    isAbove = true;
                }
                if (yCord + 1 == grass.getLocationY() & xCord == grass.getLocationX()) {
                    isBelow = true;
                }
                if (xCord + 1 == grass.getLocationX() & yCord - 1 == grass.getLocationY()) {
                    rightUp = true;
                }
                if (xCord + 1 == grass.getLocationX() & yCord + 1 == grass.getLocationY()) {
                    rightDown = true;
                }
                if (xCord - 1 == grass.getLocationX() & yCord - 1 == grass.getLocationY()) {
                    leftUp = true;
                }
                if (xCord - 1 == grass.getLocationX() & yCord + 1 == grass.getLocationY()) {
                    leftDown = true;
                }
            }

            //if there is no grass in one of the surrounding spaces it is filled
            if (isAbove == false) {
                if (yCord != 1) {
                    newGrass.setLocationX(xCord);
                    newGrass.setLocationY(yCord - 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                   // System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (isBelow == false) {
                if (yCord != simulator.getMaxY()) {
                    newGrass.setLocationX(xCord);
                    newGrass.setLocationY(yCord + 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                   // System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (isRight == false) {
                if (xCord != simulator.getMaxX()) {
                    newGrass.setLocationX(xCord + 1);
                    newGrass.setLocationY(yCord);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                   // System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (isLeft == false) {
                if (xCord != 1) {
                    newGrass.setLocationX(xCord - 1);
                    newGrass.setLocationY(yCord);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                   // System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (rightUp == false) {
                if (xCord != simulator.getMaxX() & yCord != 1) {
                    newGrass.setLocationX(xCord + 1);
                    newGrass.setLocationY(yCord - 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                   // System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (rightDown == false) {
                if (xCord != simulator.getMaxX() & yCord != simulator.getMaxY()) {
                    newGrass.setLocationX(xCord + 1);
                    newGrass.setLocationY(yCord + 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    //System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (leftUp == false) {
                if (xCord != 1 & yCord != 1) {
                    newGrass.setLocationX(xCord - 1);
                    newGrass.setLocationY(yCord - 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    //System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
                }
            }
            if (leftDown == false) {
                if (xCord != 1 & yCord != simulator.getMaxY()) {
                    newGrass.setLocationX(xCord - 1);
                    newGrass.setLocationY(yCord + 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    //System.out.println(newGrass.locationX + " " + newGrass.getLocationY());
                    simulator.setCurrentGrass(temp);
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

