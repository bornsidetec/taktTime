/*
 * FixedLengthDocument.java
 *
 * Created on August 24, 2007, 6:02 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package takttime;

import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author root
 */
public class FixedLengthDocument extends PlainDocument {
    
    private int iMaxLength;
    /** Creates a new instance of FixedLengthDocument */
    public FixedLengthDocument(int maxLen) {
        super();
        iMaxLength = maxLen;
    }
    
    public void insertString(int offSet, String str, AttributeSet attr) throws BadLocationException{
        //if (s == null) return;
        
        if (iMaxLength <=0) {
            super.insertString(offSet, str, attr);
            return;
        }
        
        int iLen = (getLength() + str.length());
        if (iLen <= iMaxLength){
            super.insertString(offSet, str, attr);
            return;
        } else {
            if (iLen == iMaxLength) return;
            String newStr = str.substring(0, (iMaxLength - getLength()));
            super.insertString(offSet, newStr, attr);
        }
        
    }
        
}
