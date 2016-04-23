

public enum Length implements Unit{
	
	METER( "Meter",1.0 ),
	KILOMETER( "Kilometer",1000 ),
	CENTIMETER( "Centimeter",0.01 ),
	MILE( "Mile",1609.344 ),
	FOOT( "Foot",0.3048 ),
	WA( "Wa",2.0 );
	
	
	public final String name;
	public final double value;
	
	Length(String name,double value) {
		this.name = name;
		this.value = value;
	}
	
//	public Length[] value(){
//		Length temp [] = {METER,KILOMETER,CENTIMETER,MILE,FOOT,WA};
//		return temp;
//	}

	@Override
	public double getValue() { 
		return this.value;
	}
	
	public String toSting(){
		return this.name;
	}
	

}
