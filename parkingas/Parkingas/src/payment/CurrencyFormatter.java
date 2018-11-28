package payment;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

	public static String CurrencyFormatter(String countryCode, double sum) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag(countryCode.toLowerCase() + "-" + countryCode.toUpperCase()));
		return nf.format(sum);
	}
	
}
