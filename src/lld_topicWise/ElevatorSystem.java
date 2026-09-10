package lld_topicWise;

import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.List;

enum Direction{
    UP, DOWN
}
enum ElevatorState {
    IDLE, MOVING_UP, MOVING_DOWN, MAINTENANCE
}

class Request {
    int floor;
    Direction direction;
    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}

class Elevator{
    int id;
    int currentFloor;
    ElevatorState state;
    List<Integer> destinations = new ArrayList<>();

    public Elevator(int id){
        this.id= id;
        this.currentFloor=0;
        this.state= ElevatorState.IDLE;
    }

    public void move(){
        if(destinations.isEmpty()){
            state=ElevatorState.IDLE;
            return;
        }
        int target = destinations.get(0);
        if(target>currentFloor){
            state= ElevatorState.MOVING_UP;
            currentFloor++;
        } else if (target<currentFloor) {
            state= ElevatorState.MOVING_DOWN;
            currentFloor--;
        }
        else{
            destinations.remove(0);
            state = ElevatorState.IDLE;
        }

    }

}

interface SchedulingStrategy {
    Elevator assignElevator(List<Elevator> elevators, Request request);
}

class NearestSchedulingStrategy implements SchedulingStrategy{


    @Override
    public Elevator assignElevator(List<Elevator> elevators, Request request) {
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator e : elevators){
            int distance = Math.abs(e.currentFloor- request.floor);
            if(distance<minDistance){
                minDistance= distance;
                nearest =e ;
            }
        }
        return nearest;
    }
}

public class ElevatorSystem {
    private static ElevatorSystem instance;
    private List<Elevator> elevators;
    private SchedulingStrategy strategy;

    private ElevatorSystem(int numElevators, SchedulingStrategy strategy)
    {
        elevators= new ArrayList<>();
        for(int i=0; i<numElevators; i++){
            elevators.add(new Elevator(i));
        }
        this.strategy = strategy;
    }

    public static ElevatorSystem getInstance(int numsElevators, SchedulingStrategy strategy){
        if(instance==null){
            instance = new ElevatorSystem(numsElevators, strategy);
        }
        return instance;
    }

    public void handleReqeust (Request request){
        Elevator assigned = strategy.assignElevator(elevators, request);
        assigned.destinations.add(request.floor);
        System.out.println("Request for floor"+ request.floor + "assign to elevator" + assigned.id);
    }

    public void step(){
        for(Elevator e : elevators){
            e.move();
            System.out.println("Elevator"+ e.id + "at floor"+ e.currentFloor+ "state"+ e.stateb);
        }
    }
}
