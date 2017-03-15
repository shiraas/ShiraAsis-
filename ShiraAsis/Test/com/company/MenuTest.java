package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Created by hackeru on 3/14/2017.
 */
class MenuTest {
    @BeforeEach
    void setUp() {
        System.out.println("begin testing MenuTest");
    }

    @AfterEach
    void tearDown() {
        System.out.println("end testing MenuTest");
    }

    @Test
    void operationBySelectTest() {
        MyFile file = new MyFile("C:\\eclipse\\features\\org.eclipse.e4.rcp_1.4.1.v20160212-1350\\feature.xml");
        Menu menu = mock(Menu.class);

    }

}