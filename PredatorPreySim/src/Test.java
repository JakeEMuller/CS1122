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
                for(int i = 0; i < getCurrentWolfs().size(); i++){
                    Wolf wolf = getCurrentWolfs().get(i);
                    wolf.die();
                }
                for(int i = 0; i < getCurrentMoose().size(); i++){
                    Moose moose = getCurrentMoose().get(i);
                    moose.die();
                }
            }

            @Override
            public void animalsEat() {
                for(int i = 0; i < getCurrentWolfs().size(); i++){
                    Wolf wolf = getCurrentWolfs().get(i);
                    wolf.eat();
                }

                for(int i = 0; i < getCurrentMoose().size(); i++){
                    Moose moose = getCurrentMoose().get(i);
                    moose.eat();
                }
            }


            @Override
            public void animalsReproduce() {
                for(int i = 0; i < getCurrentWolfs().size(); i++){
                    Wolf wolf = getCurrentWolfs().get(i);
                    Wolf newWolf = wolf.reproduce();
                    if (newWolf != null) {
                        ArrayList<Wolf> temp = getCurrentWolfs();
                        temp.add(newWolf);
                        setCurrentWolfs(temp);
                    }
                }

                for(int i = 0; i < getCurrentMoose().size(); i++){
                    Moose moose = getCurrentMoose().get(i);
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
                for(int i = 0; i < getCurrentGrass().size(); i++){
                    Grass grass = getCurrentGrass().get(i);
                    grass.grow();
                    grass.spread();
                }

//                for (Grass grass : getCurrentGrass()) {
//                    grass.grow();
//                    grass.spread();
//                }
            }

            @Override
            public void run() {
                int i = 1;
                while( getCurrentWolfs().size() != 0 & getCurrentMoose().size() != 0 ) {
                    tick();
                    System.out.println("Tick Number: " + i);
                    System.out.println("There are " + getCurrentMoose().size() + " Moose");
                    System.out.println("There are " + getCurrentWolfs().size() + " Wolves\n");
                    // System.out.println("there are " + getCurrentGrass().size() + " Grass");
                    i++;
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
        for (int i = 1; i <= simulator.getMaxX(); i++) {
            for (int j = 1; j <= simulator.getMaxY(); j++) {
                Grass grass = new Grass(simulator);
                grass.setLocationX(i);
                grass.setLocationY(j);
                System.out.printf("(%d,%d)\n",i,j);
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
