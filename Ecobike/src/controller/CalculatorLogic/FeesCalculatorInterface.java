package controller.CalculatorLogic;

public interface FeesCalculatorInterface {

	public int calculateRentalFees(String bikeType, long unlockedTime, long returnTime);
	public int getDeposit(String bikeType);
}
