
public class test {

	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		System.out.println(uc.getUnit());
		System.out.println(uc.convert(3.0, Length.KILOMETER, Length.METER));
		for(int i=0;i<uc.getUnit().length;i++){
			System.out.println(uc.getUnit()[i]);
		}
	}

}
