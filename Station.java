import java.util.ArrayList;

public class Station {
    private ArrayList<Person> waitingLeft;
    private ArrayList<Person> waitingRight;
    private ArrayList<Person> completed;
    private int number;

    public Station(int myNumber){
        number = myNumber;
        waitingLeft = new ArrayList<Person>();
        waitingRight = new ArrayList<Person>();
        completed = new ArrayList<Person>();
    }

    public boolean empty(){
        return waitingLeft.size() + waitingRight.size() == 0;
    }

    public void addPerson(Person p){
        if(p.getDestination() == number){
            completed.add(p);
        } else if(p.getDirection()){
            waitingRight.add(p);
        } else{
            waitingLeft.add(p);
        }
    }
    // returns people who are waiting for left
    public Person nextLeft(){
        if(waitingLeft.size() > 0){
            return waitingLeft.remove(0);
        }else {
            return null;
        }
    }
    //returns people who are waiting for right
    public Person nextRight(){
        if(waitingRight.size() > 0){
            return waitingRight.remove(0);
        }else {
            return null;
        }
    }

    public String toString(){
        String s = "Station: " + number + "\n";
        s += "Leftbound: " + waitingLeft.toString() + "\n";
        s += "Rightbound: " + waitingRight.toString() + "\n";
        s += "Completed: " + completed.toString();
        return s;
    }

    public int completedCount(){
        return completed.size();
    }



}
