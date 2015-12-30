package space.sternenforscher.nullrank.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sternenforscher on 30.12.15, 01:30.
 */
public class SpecialUtils {

	public static enum Time {
		DAYS, HOURS, MINUTES, SECONDS
	}

	/** From AutoRank 'Autome.armar.plugins.autorank.util'
	 * Convert a string to an integer.
	 *
	 * @param string input; this must be in the format '10d 14h 15m'
	 * @param time the time type of the output
	 * @return the integer representing the number of seconds/minutes/hours/days
	 */
	public static int stringToTime(String string, final Time time) {
		int res = 0;

		string = string.trim();

		final Pattern pattern = Pattern
				.compile("((\\d+)d)?((\\d+)h)?((\\d+)m)?");
		final Matcher matcher = pattern.matcher(string);

		matcher.find();
		final String days = matcher.group(2);
		final String hours = matcher.group(4);
		final String minutes = matcher.group(6);

		res += stringtoDouble(minutes);
		res += stringtoDouble(hours) * 60;
		res += stringtoDouble(days) * 60 * 24;

		// Res time is in minutes

		if (time.equals(Time.SECONDS)) {
			return res * 60;
		} else if (time.equals(Time.MINUTES)) {
			return res;
		} else if (time.equals(Time.HOURS)) {
			return res / 60;
		} else if (time.equals(Time.DAYS)) {
			return res / 1440;
		} else {
			return 0;
		}
	}

	public static double stringtoDouble(final String string)
			throws NumberFormatException {
		double res = 0;

		if (string != null)

			res = Double.parseDouble(string);

		return res;
	}
}
