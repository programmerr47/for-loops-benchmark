
import com.github.programmerr47.tapeline.Measurements;
import com.github.programmerr47.tapeline.TimeMeasurement;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final Random rnd = new Random();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        for (int i = 0; i < 30000; i+=5000) {
            final List<String> rndStringList = rndStringList(i);
            new Measurements(asList(
                    new TimeMeasurement(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("Index: ");
                            String overallString = "";
                            for (int i = 0; i < rndStringList.size(); i++) {
                                overallString += rndStringList.get(i);
                            }
                        }
                    }),
                    new TimeMeasurement(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("For each: ");
                            String overallString = "";
                            for (String rndString : rndStringList) {
                                overallString += rndString;
                            }
                        }
                    }),
                    new TimeMeasurement(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("Iterator: ");
                            String overallString = "";
                            for (Iterator<String> it = rndStringList.iterator(); it.hasNext(); ) {
                                overallString += it.next();
                            }
                        }
                    }))).measure().print();
        }
    }

    private List<String> rndStringList(int size) {
        List<String> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(rndString());
        }
        return result;
    }

    private String rndString() {
        return String.valueOf(rnd.nextInt());
    }
}