/***
 * This is taken from : http://www.jroller.com/dpmihai/entry/documentfilter
 */

package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PatternFilter extends DocumentFilter {
	public static PatternFilter datumFilter = new PatternFilter("[0-3](\\d(/(0([1-9](/(\\d{0,4})?)?)?)?)?)?|[0-3](\\d(/(1([0-2](/(\\d{0,4})?)?)?)?)?)?");
	public static PatternFilter uurFilter = new PatternFilter("0?(\\d(:(0(\\d)?)?)?)?|0?(\\d(:([1-5](\\d)?)?)?)?|1(\\d(:(0(\\d)?)?)?)?|1(\\d(:([1-5](\\d)?)?)?)?|2([0-3](:(0(\\d)?)?)?)?|2([0-3](:([1-5](\\d)?)?)?)?");
	public static PatternFilter prijsFilter = new PatternFilter("\\d+(\\.(\\d{0,2})?)?");		
	
    // Useful for every kind of input validation !
    // this is the insert pattern
    // The pattern must contain all subpatterns so we can enter characters into a text component !
    private Pattern pattern;

    public PatternFilter(String pat) {
        pattern = Pattern.compile(pat);
    }

    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {

        String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
        Matcher m = pattern.matcher(newStr);
        if (m.matches()) {
            super.insertString(fb, offset, string, attr);
        } else {
        }
    }

    public void replace(FilterBypass fb, int offset,
                        int length, String string, AttributeSet attr) throws
            BadLocationException {

        if (length > 0) fb.remove(offset, length);
        insertString(fb, offset, string, attr);
    }
}