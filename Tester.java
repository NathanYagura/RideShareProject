public class Tester {
    public static void main(String[] args){
        Road r = new Road();

        r.populateCars(20);
        r.populateStations(50);
        System.out.println(r.toString());

        for(int i = 0; i < 33; i++){
            r.move();
        }

        System.out.println(r.toString());
        System.out.println(r.numComplete());

        System.out.println("Percent completed: ");
        System.out.println((double)r.numComplete()/50*100);
    }
}
