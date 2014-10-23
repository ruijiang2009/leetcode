package com.programapprentice.app;

/**
 * @author rjiang
 * @date 10/22/14
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        int lineCount = 0;
        int wordCount = 0;
        for(String word : words) {
            if(lineCount == 0) {
                lineCount += word.length();
                wordCount += word.length();
                line.add(word);
            } else {
                if(lineCount + word.length() + 1 > L) {
                    result.add(justifyOneLine(line, L, wordCount));
                    line = new ArrayList<String>();
                    line.add(word);
                    lineCount = word.length();
                    wordCount = word.length();
                } else {
                    line.add(word);
                    lineCount += word.length() + 1;
                    wordCount += word.length();
                }
            }
        }
        result.add(justifyLastLine(line, L, wordCount));

        return result;
    }

    public String justifyOneLine(List<String> line, int L, int wordCount) {
        StringBuilder sb = new StringBuilder();
        if(line.size() == 1) {
            sb.append(line.get(0));
            char[] array = new char[L - wordCount];
            Arrays.fill(array, ' ');
            sb.append(new String(array));
            return sb.toString();
        }
        int numOfWords = line.size();
        int numOfSpace = L - wordCount;
        int regularSpaceLength = numOfSpace / (numOfWords - 1);
        int numOfUnregularSpace = numOfSpace % (numOfWords - 1);
        char[] array = new char[regularSpaceLength];
        Arrays.fill(array, ' ');
        String regularSpace = new String(array);
        String nonRegularSpace = regularSpace + ' ';
        sb.append(line.get(0));
        for(int i = 1; i < line.size(); i++) {
            if(i <= numOfUnregularSpace) {
                sb.append(nonRegularSpace);
            } else {
                sb.append(regularSpace);
            }
            sb.append(line.get(i));
        }
        return sb.toString();
    }

    public String justifyLastLine(List<String> line, int L, int wordCount) {
        StringBuilder sb = new StringBuilder();
        int spaceLength = L;
        sb.append(line.get(0));
        spaceLength -= line.get(0).length();
        for(int i = 1; i < line.size(); i++) {
            sb.append(" ");
            sb.append(line.get(i));
            spaceLength -= line.get(i).length() + 1;
        }
        if(spaceLength > 0) {
            char[] array = new char[spaceLength];
            Arrays.fill(array, ' ');
            sb.append(new String(array));
        }
        return sb.toString();
    }
}
