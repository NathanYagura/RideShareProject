public class Person{
    private int destination;
    private boolean direction; //true for going right, false for left
    private int startLocation;

    public Person(int myDestination, int myStart){
        destination = myDestination;
        startLocation = myStart;
        if(destination < startLocation){
            direction = false;
        } else {
            direction = true;
        } 
    }


    public int getDestination(){
        return destination;
    }

    public boolean getDirection(){
        return direction;
    }

    public int getStart(){
        return startLocation;
    }
    // to string is used to help keep track of where person needs to go and where it starts relative to cars
    public String toString(){
        return super.toString() + " Start: " + startLocation + " Destination: " + destination + " Going right? " + direction; 
    }
}