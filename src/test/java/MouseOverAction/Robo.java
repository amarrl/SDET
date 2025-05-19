package MouseOverAction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Robo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		Robot robo = new Robot();

        // Ctrl + A
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_A);
        robo.keyRelease(KeyEvent.VK_A);
        robo.keyRelease(KeyEvent.VK_CONTROL);

        // Small delay to ensure copy happens after selection
        Thread.sleep(500);

        // Ctrl + V
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);	

	}

}
