import java.util.*;
import java.util.ArrayList;

public class Road {
    private Station[] stations;
    private ArrayList<Car> fleet;

    private static final int NUMSTATIONS = 32;

    public Road(){
        stations = new Station[NUMSTATIONS];
        for(int i = 0; i < stations.length; i++){
            stations[i] = new Station(i);
        }
        fleet = new ArrayList<Car>();
    }

    public void populateStations(int numPeople){
        for(int i = 0; i < numPeople; i++){
            int start = (int)(Math.random() * NUMSTATIONS);
            int stop = (int)(Math.random() * NUMSTATIONS);
            stations[start].addPerson(new Person(stop, start));
        }
    } 

    public void populateCars(int numCars){
        for(int i = 0; i < numCars; i++){
            int start = (int)(Math.random() * NUMSTATIONS);
            int stop = (int)(Math.random() * NUMSTATIONS);
            fleet.add(new Car(stop, start));
        }
    }

        public String toString(){
            String s = "Stations: \n";
            for(Station st : stations){
                if(st.empty() == false){
                    s += st.toString();
                    s += "\n";
                }
            }
            s += "Cars:\n";
            for(Car c : fleet){
                s += c.toString();
            }
            return s;
        }
        //moves every car forward while checking if either the car or the person has reached their destination
        public void move(){
            for(Car c : fleet){
                Person p = c.unload();
                while(p != null){
                    int location = c.getCurrentLocation();
                    stations[location].addPerson(p);
                    p = c.unload();
                } 
                c.loadPassengers(stations[c.getCurrentLocation()]);

                if(c.getCurrentLocation() != c.getDestination()){
                    c.move();
                } else{
                    c.exit(stations[c.getCurrentLocation()]);
                }

            }
        }
        //keeps track of how many people go to their destination
        public int numComplete(){
            int sum = 0;
            for(Station r : stations){
                sum += r.completedCount();
            }
            return sum;
        }

    }