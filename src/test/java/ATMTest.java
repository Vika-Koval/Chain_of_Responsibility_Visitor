import org.junit.jupiter.api.Test;

import ucu.edu.ua.atm.ATM;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ATMTest {

    @Test
    public void testProcessValidAmount() {
        ATM atm = new ATM();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        atm.process(155);

        String expectedOutput = 
            "Pleaser recieve 1 x 5\n" +
            "Pleaser recieve 1 x 50\n" +
            "Pleaser recieve 1 x 100\n";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());

        System.setOut(System.out);
    }

    @Test
    public void testProcessInvalidAmount() {
        ATM atm = new ATM();
        assertThrows(IllegalArgumentException.class, () -> atm.process(3));
    }
}
