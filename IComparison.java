/**
 * This interface represents a comparison strategy
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public interface IComparison{
    /**
     * Compares the old and new contents to detect updates
     * 
     * @param oldContent the String that holds old content of website
     * @param newContent the String that holds new content of website
     * @return true if contents are same, false otherwise
     */
    public boolean compare(String oldContent, String newContent);
}