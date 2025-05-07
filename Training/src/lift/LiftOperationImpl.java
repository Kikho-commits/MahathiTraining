package lift;

public class 
LiftOperationImpl implements LiftOperation{

	@Override
	public void moveTo(Lift lift, int destination) {
		lift.setPreviousFloor(lift.getCurrentFloor());
		lift.setDestination(destination);
		lift.setCurrentFloor(destination);
	}
	

}
