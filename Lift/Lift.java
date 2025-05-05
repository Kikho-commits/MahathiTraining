package lift;

public class Lift extends Building{
	private int id;
	private int currentFloor = 0;
	private int previousFloor  = 0;
	private int destination  = 0;
	
	
	Lift(int maxFloor,int minFloor,int lifts, int id){
		super(maxFloor,minFloor,lifts);
		this.id = id;
	}
	
	Lift(int id){
		this.id = id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public void setPreviousFloor(int previousFloor) {
		this.previousFloor = previousFloor;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	int getCurrentFloor() {
		return currentFloor;
	}

	int getPreviousFloor() {
		return previousFloor;
	}

	int getId() {
		return id;
	}

	int getDestination() {
		return destination;
	}
	
	public int getMaxFloor() {
		return maxFloor;
	}
	
	public int getMinFLoor() {
		return  minFloor;
	}

	
}
