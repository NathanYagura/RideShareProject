import java.util.ArrayList;

public class Car {
    private int destination;
    private boolean direction; //true for going right, false for left
    private int currentlocation;
    private ArrayList<Person> passengers;


    public Car(int myDestination, int start){
        destination = myDestination;
        currentlocation = start;
        direction = destination > currentlocation;
        passengers = new ArrayList<Person>();

    }

     public String toString(){
        return super.toString() + " Destination: " + destination + "Current location: " + currentlocation + " Going right? " + direction + " Passengers: " + passengers;

     }

     public void addPassenger(Person p){
        if(passengers.size() >= 3){
            System.out.println("ERROR: No Room!");
        } else{
            passengers.add(p);
        }
     }

     public boolean hasRoom(){
        return passengers.size() < 3;
     }

    public int getDestination(){
        return destination;
    }

    public boolean getDirection(){
        return direction;
    }

    public int getCurrentLocation(){
        return currentlocation;
    }

    public void move(){
        if(currentlocation == destination){
            return; //kick out early before trying to move
        }
        if(direction == true){
            currentlocation++;
        } else{
            currentlocation--;
        }
    }
    // loadPassengers method loads passengers onto cars that are passing by the stations and going in the same direction needed
    public void loadPassengers(Station s){
        Person p = null;
        if(direction ==true){
            p = s.nextRight();

        }else{
            p = s.nextLeft();
        }
        
        while(p != null && hasRoom()){
            addPassenger(p);
            if(direction ==true){
                p = s.nextRight();
    
            }else{
                p = s.nextLeft();
            }
        }
    }
    // exit method kicks out all passengers to the current station once the car gets to its destination
    public void exit(Station s){
        for(int i = 0; i < passengers.size(); i++){
            Person a = passengers.get(i);
            passengers.remove(i);
            i--;
            s.addPerson(a);
        }
    }

    //unload method kicks out passengers whose destination is the current location
    public Person unload(){
        for(int i = 0; i < passengers.size(); i++){
            Person a = passengers.get(i);
            if(a.getDestination() == currentlocation){
                return passengers.remove(i);
            }
        }
        return null;
    }




}
