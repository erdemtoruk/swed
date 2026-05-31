/**
 * This class represents a html comparison strategy
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public class HtmlComparison implements IComparison{
    /**
     * Compares the old and new content's html texts to detect updates
     * 
     * @param oldContent the String that holds old content of website
     * @param newContent the String that holds new content of website
     * @return true if contents are same, false otherwise
     */
    public boolean compare(String oldContent, String newContent){
        return oldContent.equals(newContent);
    }
}