package ProductsRealization.ProductsRealization;
import javax.swing.JTextField;

public class Calculations {
	
	private static double NDS = 0.2;
	
	public String calculateEachSumm (JTextField textfield_kol, JTextField textfield_price, String summ_no_nds) {
		double kol = Double.parseDouble(textfield_kol.getText());
		double price = Double.parseDouble(textfield_price.getText());
		double price_no_nds_double = kol*price;
		summ_no_nds = Double.toString(price_no_nds_double);
		return summ_no_nds;
	}
	
	public String calculateEachNDS (JTextField textfield_kol, JTextField textfield_price, String nds) {
		double kol = Double.parseDouble(textfield_kol.getText());
		double price = Double.parseDouble(textfield_price.getText());
		double nds_double = kol*price*0.2;
		nds = Double.toString(nds_double);
		return nds;
	}
	
	public String calculateEachSummWithNDS (JTextField textfield_kol, JTextField textfield_price, String summ_with_nds) {
		double kol = Double.parseDouble(textfield_kol.getText());
		double price = Double.parseDouble(textfield_price.getText());
		double summ_with_nds_double = kol*price*(1+NDS);
		summ_with_nds = Double.toString(summ_with_nds_double);
		return summ_with_nds;
	}
	
}
