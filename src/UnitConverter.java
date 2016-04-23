
public class UnitConverter {
	
	public  double convert(double amount,Unit fromUnit,Unit toUnit){
		double temp = 0;
		temp = amount*fromUnit.getValue();
		temp/= toUnit.getValue();
		return temp;
	}
	public Unit[] getUnit(){
		return Length.values();
	}
}
