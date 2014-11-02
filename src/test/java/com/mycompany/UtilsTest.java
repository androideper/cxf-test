package com.mycompany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author <a href="mailto:androideper@gmail.com"> Android Developer</a>
 *         Date: 11/3/14 - 1:51 AM
 */
@RunWith(Parameterized.class)
public class UtilsTest {
    String firstString, secondString;
    boolean result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null, true},
                {"",   null, false},
                {null, "",   false},
                {"",   "",   true},
                {"1",  "",   false},
                {"",   "1",  false},
                {"1",  "1",  true},
        });
    }

    public UtilsTest(String firstString, String secondString, boolean result) {
        this.firstString = firstString;
        this.secondString = secondString;
        this.result = result;
    }

    @Test
    public void stringEquals() {
        assertThat(Utils.stringsEqual(firstString, secondString), is(result));
    }
}
