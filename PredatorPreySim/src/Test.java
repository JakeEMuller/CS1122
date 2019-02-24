import java.util.ArrayList;

public class Test {


    // ------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------
    public static void main(String[] args) {
        Simulator simulator = new Simulator() {
            @Override
            public void animalsMove() {
                for (Wolf wolf : getCurrentWolfs()) {
                    wolf.move();
                }
                for (Moose moose : getCurrentMoose()) {
                    moose.move();
                }
            }

            @Override
            public void animalsDie() {
                for (Wolf wolf : getCurrentWolfs()) {
                    wolf.die();
                }
                for (Moose moose : getCurrentMoose()) {
                    moose.die();
                }
            }

            @Override
            public void animalsEat() {
                for (Wolf wolf : getCurrentWolfs()) {
                    wolf.eat();
                }
                for (Moose moose : getCurrentMoose()) {
                    moose.eat();
                }
            }


            @Override
            public void animalsReproduce() {
                for (Wolf wolf : getCurrentWolfs()) {
                    Wolf newWolf = wolf.reproduce();
                    if (newWolf != null) {
                        ArrayList<Wolf> temp = getCurrentWolfs();
                        temp.add(newWolf);
                        setCurrentWolfs(temp);
                    }
                }
                for (Moose moose : getCurrentMoose()) {
                    Moose newMoose = moose.reproduce();
                    if (newMoose != null) {
                        ArrayList<Moose> temp = getCurrentMoose();
                        temp.add(newMoose);
                        setCurrentMoose(temp);
                    }
                }
            }

            @Override
            public void grassGrows() {
                for (Grass grass : getCurrentGrass()) {
                    grass.grow();
                    grass.spread();
                }
            }

            @Override
            public void run() {
                for (int i = 0; i <= 500; i++) {
                    tick();
                    System.out.println("there are " + getCurrentMoose().size() + " Moose");
                    System.out.println("there are " + getCurrentWolfs().size() + " Wolfs");
                    System.out.println("there are " + getCurrentGrass().size() + " Grass");
                    System.out.println(i);
                }


            }
        };

        // create the initial set of wolfs and moose and populates the world with grass
        for (int i = 0; i < simulator.getInitialWolves(); i++) {
            Wolf wolf = new Wolf(simulator);
            ArrayList<Wolf> intialWolfs = simulator.getCurrentWolfs();
            intialWolfs.add(wolf);
        }

        for (int i = 0; i < simulator.getInitialMoose(); i++) {
            Moose moose = new Moose(simulator);
            ArrayList<Moose> intialWolfs = simulator.getCurrentMoose();
            intialWolfs.add(moose);
        }
        for (int i = 0; i < simulator.getMaxX(); i++) {
            for (int j = 0; j < simulator.getMaxY(); j++) {
                Grass grass = new Grass(simulator);
                grass.setLocationX(i);
                grass.setLocationY(j);
                ArrayList<Grass> setGrass;
                setGrass = simulator.getCurrentGrass();
                setGrass.add(grass);
                simulator.setCurrentGrass(setGrass);
            }
        }

        //this is what starts the simulation
        simulator.run();

    }
}
