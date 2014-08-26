import com.programapprentice.app.RestoreIPAddresses;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 8/26/14
 */
public class Test_RestoreIPAddresses {
    RestoreIPAddresses obj = new RestoreIPAddresses();
    @Test
    public void test1() {
        String input = "25525511135";
        List<String> actual = obj.restoreIpAddresses(input);
        Collections.sort(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("255.255.11.135");
        expected.add("255.255.111.35");
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "2552551113";
        List<String> actual = obj.restoreIpAddresses(input);
        Collections.sort(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("255.25.51.113");
        expected.add("255.255.1.113");
        expected.add("255.255.11.13");
        expected.add("255.255.111.3");
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String input = "255";
        List<String> actual = obj.restoreIpAddresses(input);
        Collections.sort(actual);
        List<String> expected = new ArrayList<String>();
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String input = "1111";
        List<String> actual = obj.restoreIpAddresses(input);
        Collections.sort(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("1.1.1.1");
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String input = "0000";
        List<String> actual = obj.restoreIpAddresses(input);
        Collections.sort(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("0.0.0.0");
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String input = "010010";
        List<String> actual = obj.restoreIpAddresses(input);
        Collections.sort(actual);
        List<String> expected = new ArrayList<String>();
        expected.add("0.10.0.10");
        expected.add("0.100.1.0");
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

}
