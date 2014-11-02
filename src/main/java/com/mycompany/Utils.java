package com.mycompany;

/**
 * Includes some general utility methods.
 *
 * @author <a href="mailto:androideper@gmail.com"> Android Developer</a>
 *         Date: 11/3/14 - 1:47 AM
 */
public class Utils {
    /**
     * Checks if two strings are equal. It assumes that two null strings are equal as well.
     *
     * @param first string to be compared
     * @param second string to be compared
     * @return true if two string are equal or both of them are null, false otherwise
     */
    public static boolean stringsEqual(String first, String second) {
        if (first != null) {
            return first.equals(second);
        }
        return second == null;
    }
}
