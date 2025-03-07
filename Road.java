import java.util.*;
import java.util.ArrayList;

public class Road {
    private Station[] stations;
    private ArrayList<Car> fleet;

    private static final int NUMSTATIONS = 32;

    public Road(){
        stations = new Station(NUMSTATIONS);
        for(int i = 0; i < stations.length; i++){
            stations[i] = new Station(i);
        }
        fleet = new ArrayList<Car>();
    }

    public void populateStations(int numPeople){
        for(int i = 0; i < numPeople; i++){
            int start = (int)(Math.random() * NUMSTATIONS);
            int stop = (int)(Math.random() * NUMSTATIONS);
            stations[start].addPersons(new Person(stop, start));
        }

    public void populateCars(int numCars){
        for(int i = 0; i < numCars; i++){
            int start = (int)(Math.random() * NUMSTATIONS);
            int stop = (int)(Math.random() * NUMSTATIONS);
            fleed.add(new Car(stop, start));
        }
    }

        public String toString(){
            String s = "Stations: \n";
            for(Stations st : stations){
                s += st.toString();
                s += "\n";
            }
            s += "Cars:\n";
            for(Car c : fleet){
                s += c.toString();
            }
            return s;
        }

        public void move(){
            for(Car c : fleet){
                Person p = c.unload();
                if(p != null){
                    int location = c.getLocation();
                    stations[location].addPerson(p);
                } else{
                    break;
                }
            }
        }


    }
}