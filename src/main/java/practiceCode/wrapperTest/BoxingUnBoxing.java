package practiceCode.wrapperTest;

public class BoxingUnBoxing {

	public static void main(String[] args) {
		// Boxing
		Byte obj1 = new Byte((byte) 1);
		Character obj2 = new Character('가');
		Short obj3 = new Short((short) 100);
		Integer obj4 = new Integer(1000);
		Long obj5 = new Long(10000);
		Float obj6 = new Float(2.5F);
		Double obj7 = new Double(3.5);
		Boolean obj8 = new Boolean(true);

		// UnBoxing
		byte value1 = obj1.byteValue();
		char value2 = obj2.charValue();
		short value3 = obj3.shortValue();
		int value4 = obj4.intValue();
		long value5 = obj5.longValue();
		float value6 = obj6.floatValue();
		double value7 = obj7.doubleValue();
		boolean value8 = obj8.booleanValue();

		Object[] d = { value1, value2, value3, value4, value5, value6, value7, value8 };
		for (Object x : d) {
			System.out.println(x);
		}
	}
}
