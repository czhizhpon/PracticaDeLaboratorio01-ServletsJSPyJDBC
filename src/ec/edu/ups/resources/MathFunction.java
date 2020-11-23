package ec.edu.ups.resources;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathFunction {

	public static double getTrunkDecimal(double n) {
		DecimalFormat df = new DecimalFormat("############.######");
		df.setRoundingMode(RoundingMode.DOWN);
		return Double.parseDouble(df.format(n));
	}
	
}
