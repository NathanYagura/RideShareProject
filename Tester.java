public class Tester {
    public static void main(String[] args){
        Road r = new Road();
        int people = 50;
        int cars = 20;
        r.populateCars(cars);
        r.populateStations(people);
        System.out.println(r.toString());
        //the i < 33 is to make sure all cars reach their destination since they move 32 times
        //the System.out.println("-----" + i) is used to figure out which move the simulation is on relative to the output
        for(int i = 0; i < 33; i++){
            r.move();
            System.out.println("----- " + i);
            System.out.println(r);
        }


        System.out.println(r.numComplete());
        // calculates error
        System.out.println("Percent completed: ");
        System.out.println((double)r.numComplete()/people*100);
    }
}
