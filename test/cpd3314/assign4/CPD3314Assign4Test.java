/*
 * Copyright 2014 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cpd3314.assign4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class CPD3314Assign4Test {

    // Streams used to hijack System.out and System.err
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public CPD3314Assign4Test() {
    }

    @Before
    public void setUp() {
        // Hijacking the Out and Err Streams
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        // Resetting the Out and Err Streams
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }

    /**
     * Test of doExercise1 method, of class CPD3314Assign4.
     */
    @Test
    public void testDoExercise1ForTen() {
        String fakeInput = "10\n";
        byte[] fakeInputArray = fakeInput.getBytes();
        System.setIn(new ByteArrayInputStream(fakeInputArray));

        String expected = "30";

        CPD3314Assign4.doExercise1();

        String actual = outContent.toString();
        assertTrue("Checking if \"" + actual + "\" contains expected result " + expected,
                actual.contains(expected));
    }

    /**
     * Test of doExercise1 method, of class CPD3314Assign4.
     */
    @Test
    public void testDoExercise1ForRandom() {
        Random rng = new Random();
        int input = rng.nextInt(10000);
        String fakeInput = input + "\n";
        byte[] fakeInputArray = fakeInput.getBytes();
        System.setIn(new ByteArrayInputStream(fakeInputArray));
        int floorByTwo = (input / 2) * 2;

        int expectedNum = (floorByTwo * (floorByTwo + 1)) / 2 + (floorByTwo / 2) / 2;
        String expected = Integer.toString(expectedNum);

        CPD3314Assign4.doExercise1();

        String actual = outContent.toString();
        assertTrue("Checking if \"" + actual + "\" contains expected result " + expected,
                actual.contains(expected));
    }

    /**
     * Test of doExercise2 method, of class CPD3314Assign4.
     */
    @Test
    public void testDoExercise2() {
        try {
            PrintWriter pw = new PrintWriter("ex3output.txt");
            pw.println();
            pw.close();
        } catch (IOException ex) {
            System.err.println("Unexpected IO Exception: " + ex.getMessage());
        }
        String fakeInput = "60\n5\n";
        byte[] fakeInputArray = fakeInput.getBytes();
        System.setIn(new ByteArrayInputStream(fakeInputArray));

        String[] hours = {"1", "2", "3", "4", "5"};
        String[] miles = {"60", "120", "180", "240", "300"};

        try {
            CPD3314Assign4.doExercise2();
        } catch (Exception ex) {
            fail("Unexpected Exception: " + ex.getMessage());
        }

        try {
            File file = new File("ex3output.txt");
            Scanner actual = new Scanner(file);
            int i = 0;
            if (!actual.hasNext()) {
                fail("Output file is empty.");
            }
            while (actual.hasNext()) {
                String input = actual.nextLine();
                if (input.contains(hours[i])) {
                    assertTrue("Checking if \"" + input + "\" contains expected result: " + hours[i] + "\t" + miles[i],
                            input.contains(hours[i]) && input.contains(miles[i]));
                    i++;
                }
            }
        } catch (FileNotFoundException ex) {
            fail("Output file not found.");
        }
    }

    /**
     * Test of doExercise3 method, of class CPD3314Assign4.
     */
    @Test
    public void testDoExercise10() {
        String fakeInput = "10\n9\n11\n200\n7\n8\n3\n20\n-99\n";
        byte[] fakeInputArray = fakeInput.getBytes();
        System.setIn(new ByteArrayInputStream(fakeInputArray));

        String expectedLow = "3";
        String expectedHigh = "200";

        CPD3314Assign4.doExercise3();

        String[] actual = outContent.toString().split("\n");
        String actualLow = actual[actual.length - 2];
        String actualHigh = actual[actual.length - 1];
        assertTrue("Checking if \"" + actualLow + "\" contains expected result " + expectedLow,
                actualLow.contains(expectedLow));
        assertTrue("Checking if \"" + actualHigh + "\" contains expected result " + expectedHigh,
                actualHigh.contains(expectedHigh));
    }

    /**
     * Test of doExercise4 method, of class CPD3314Assign4.
     */
    @Test
    public void testDoExercise11() {
        CPD3314Assign4.doExercise4();
        String[] actual = outContent.toString().split("\n");
        int i = 0;
        while (i < actual.length
                && !(actual[i].contains("0.0") && actual[i].contains("32.0"))) {
            i++;
        }
        for (double C = 0; C <= 100; C++) {
            int iC = (int) C;
            double F = (9.0 / 5.0) * C + 32;
            double K = C + 273.15;
            String expectedC = String.format("%.1f", C);
            String expectedF = String.format("%.1f", F);
            String expectedK = String.format("%.1f", K);
            if (i + C < actual.length) {
                String actualLine = actual[i + iC];
                assertTrue("Checking if \"" + actualLine + "\" contains: " + expectedC + ", " + expectedF + " and " + expectedK,
                        (actualLine.contains(expectedC) && actualLine.contains(expectedF) && actualLine.contains(expectedK)));
            } else {
                fail("Out of input: Did you count to 100, or stop at 99?");
            }
        }

    }

    /**
     * Test of doExercise5 method, of class CPD3314Assign4.
     */
    @Test
    public void testDoExercise14() {
        String fakeInput = "shakespeare.txt\n";
        byte[] fakeInputArray = fakeInput.getBytes();
        System.setIn(new ByteArrayInputStream(fakeInputArray));

        String[] expected = {
            "1: Music to hear, why hear'st thou music sadly?",
            "2: Sweets with sweets war not, joy delights in joy:",
            "3: Why lov'st thou that which thou receiv'st not gladly,",
            "4: Or else receiv'st with pleasure thine annoy?",
            "5: If the true concord of well-tuned sounds,",
            "6: By unions married, do offend thine ear,",
            "7: They do but sweetly chide thee, who confounds",
            "8: In singleness the parts that thou shouldst bear.",
            "9: Mark how one string, sweet husband to another,",
            "10: Strikes each in each by mutual ordering;",
            "11: Resembling sire and child and happy mother,",
            "12: Who, all in one, one pleasing note do sing:",
            "13:    Whose speechless song being many, seeming one,",
            "14:    Sings this to thee: 'Thou single wilt prove none.'"
        };

        try {
            CPD3314Assign4.doExercise5();
        } catch (Exception ex) {
            fail("Unexpected Exception: " + ex.getMessage());
        }

        String[] actual = outContent.toString().split("\n");
        int offset = 0;
        if (actual.length < expected.length) {
            fail("Output does not have enough lines.");
        }
        while (!actual[offset].contains(expected[0])) {
            offset++;
        }
        for (int i = 0; i < actual.length - offset; i++) {
            String input = actual[i + offset];
            assertTrue("Checking if \"" + input + "\" contains: " + expected[i],
                    input.contains(expected[i]));

        }
    }
}
