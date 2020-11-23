package ec.edu.ups.resources;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormat {

	public static String getMySQLDate(Calendar datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		if (datetime == null) {
			date = "NULL";
		}else {
			date = "'" + sdf.format(datetime.getTimeInMillis()) + "'";
		}
		return date;
	}
	
	public static Calendar getCalentarByTimestamp(Timestamp ts) {
		Calendar datetime = Calendar.getInstance();
		datetime.setTimeInMillis(ts != null ? ts.getTime(): 0L);
		return datetime;
	}
	
}
