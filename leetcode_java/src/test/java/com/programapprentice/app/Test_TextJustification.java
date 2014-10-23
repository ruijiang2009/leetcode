package com.programapprentice.app;

import org.junit.Test;

import javax.xml.soap.Text;
import java.util.List;

/**
 * @author rjiang
 * @date 10/23/14
 */
public class Test_TextJustification {
    TextJustification obj = new TextJustification();

    @Test
    public void test1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int L = 16;
        List<String> output = obj.fullJustify(words, L);
        printOutput(output);
    }

    @Test
    public void test2() {
        String[] words = {"What","must","be","shall","be."};
        int L = 12;
        List<String> output = obj.fullJustify(words, L);
        printOutput(output);
    }

    private void printOutput(List<String> output) {
        for(String str : output) {
            System.out.println(str);
        }
    }
}
