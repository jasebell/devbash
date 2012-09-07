package com.cloudatics.devbash;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RETokenizer implements Iterator {
    
    private CharSequence input;

   
    private Matcher matcher;

    
    private boolean returnDelims;


    private String delim;

    private String match;

    private int lastEnd = 0;


    public RETokenizer(CharSequence input, String patternStr, boolean returnDelims) {
        // Save values
        this.input = input;
        this.returnDelims = returnDelims;

        // Compile pattern and prepare input
        Pattern pattern = Pattern.compile(patternStr);
        matcher = pattern.matcher(input);
    }

    // Returns true if there are more tokens or delimiters.
    public boolean hasNext() {
        if (matcher == null) {
            return false;
        }
        if (delim != null || match != null) {
            return true;
        }
        if (matcher.find()) {
            if (returnDelims) {
                delim = input.subSequence(lastEnd, matcher.start()).toString();
            }
            match = matcher.group();
            lastEnd = matcher.end();
        } else if (returnDelims && lastEnd < input.length()) {
            delim = input.subSequence(lastEnd, input.length()).toString();
            lastEnd = input.length();

            // Need to remove the matcher since it appears to automatically
            // reset itself once it reaches the end.
            matcher = null;
        }
        return delim != null || match != null;
    }

    // Returns the next token (or delimiter if returnDelims is true).
    public Object next() {
        String result = null;

        if (delim != null) {
            result = delim;
            delim = null;
        } else if (match != null) {
            result = match;
            match = null;
        }
        return result;
    }

    // Returns true if the call to next() will return a token rather
    // than a delimiter.
    public boolean isNextToken() {
        return delim == null && match != null;
    }

    // Not supported.
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
