/**
 * This class represents a size comparison strategy
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public class SizeComparison implements IComparison{
    /**
     * Compares the old and new content's size to detect updates
     * 
     * @param oldContent the String that holds old content of website
     * @param newContent the String that holds new content of website
     * @return true if contents are same length, false otherwise
     */
    public boolean compare(String oldContent, String newContent){
        return oldContent.length() == newContent.length();
    }
}