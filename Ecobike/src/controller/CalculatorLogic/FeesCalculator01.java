package controller.CalculatorLogic;


public class FeesCalculator01 implements FeesCalculatorInterface {


	@Override
	public int calculateRentalFees(String bikeType, long unlockedTime, long returnTime) {
		return 0;
	}

	@Override
	public int getDeposit(String bikeType) {
		if(bikeType.equals("SingleBike")){
			return 400000;
		} else if(bikeType.equals("EBike")){
			return 700000;
		} else if(bikeType.equals("TwinBike")){
			return 550000;
		} else{
			return -1;
		}
	}
}
