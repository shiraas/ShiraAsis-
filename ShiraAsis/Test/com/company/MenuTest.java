package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by hackeru on 3/14/2017.
 */
class MenuTest {

    int outputCount = 0;
    int inputCount = 0;

   /* @BeforeEach
    void setUp() {
        System.out.println("begin testing MenuTest");
    }

    @AfterEach
    void tearDown() {
        System.out.println("end testing MenuTest");
    }
*/
    @Test
    void startTest_select_0() {
        Input input = mock(Input.class);
        when(input.input()).thenReturn("0").thenReturn("3");
        Output output = mock(Output.class);
        Menu menu = new Menu(input, output);
        menu.start();
        verify(output, times(2)).output("please choose:\n" +
                "0. return to menu\n"+
                "1. encryption\n"+
                "2. decryption\n"+
                "3. exit\n"+
                "your choice: \n");
    }
    @Test
    void startTest_select_1_correctPath() {
        Input input = mock(Input.class);
        when(input.input()).thenReturn("1").thenReturn("C:\\Users\\hackeru.HACKERU3\\Downloads\\shira.txt").thenReturn("3");
        Output output = mock(Output.class);
        Menu menu = new Menu(input, output);
        menu.start();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("Enter a file path: ");
        orderedOutput.verify(output).output(anyObject());
        orderedOutput.verify(output).output("Encryption succeeded");

    }
    @Test
    void startTest_select_1_NoCorrectPath() {
        Input input = mock(Input.class);
        when(input.input()).thenReturn("1").thenReturn("C:\\Users\\hackeru.HACKERU3\\Downloads").thenReturn("3");
        Output output = mock(Output.class);
        Menu menu = new Menu(input, output);
        menu.start();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("Enter a file path: ");
        orderedOutput.verify(output).output("The file doesn't exist.\n press 3 to exit or");
        orderedOutput.verify(output).output("Enter a file path: ");
    }
    @Test
    void startTest_select_2_correctPath_rightNumber() {
        Input input = mock(Input.class);
        when(input.input()).thenReturn("2").thenReturn("C:\\Users\\hackeru.HACKERU3\\Downloads\\shira.txt").thenReturn("50").thenReturn("3");
        Output output = mock(Output.class);
        Menu menu = new Menu(input, output);
        menu.start();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("Enter a file path: ");
        orderedOutput.verify(output).output("enter key:");
        orderedOutput.verify(output).output("Decryption succeeded");
    }
    /*@Test
    void startTest_select_2_correctPath_NoRightNumber() {
        Input input = mock(Input.class);
        when(input.input()).thenReturn("2").thenReturn("C:\\Users\\hackeru.HACKERU3\\Downloads\\shira.txt").thenReturn("ggg").thenReturn("3");
        Output output = mock(Output.class);
        Menu menu = new Menu(input, output);
        menu.start();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("Enter a file path: ");
        orderedOutput.verify(output).output("enter key:");
        orderedOutput.verify(output).output("not number, try again");
    }
    */
    @Test
    void startTest_select_2_NoCorrectPath() {
    }
    @Test
    void startTest_select_3() {}
    @Test
    void startTest_select_5() {}
    @Test
    void startTest_select_string() {}

    @Test
    void operationBySelectTest() {
    }

}