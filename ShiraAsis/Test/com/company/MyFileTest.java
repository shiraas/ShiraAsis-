package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hackeru on 3/14/2017.
 */
class MyFileTest {
  /*  @BeforeEach
    void setUp() {
        System.out.println("begin testing MyFile");
    }

    @AfterEach
    void tearDown() {
        System.out.println("end testing MyFile");
    }*/
    @Test
    void checkMyFile_notPath() {
        MyFile file = new MyFile("aa45415a");
        if (file.checkMyFile())
            Assertions.fail("not path");
    }
    @Test
    void checkMyFile_notFile() {
        MyFile file = new MyFile("C:\\eclipse\\features");
        if (file.checkMyFile())
            Assertions.fail("not file");
    }
    @Test
    void checkMyFile_notExist() {
        MyFile file = new MyFile("C:\\eclipse\\ddddd");
        if (file.checkMyFile())
            Assertions.fail("Path doesn't exist ");
    }
    void checkMyFile_pathExist() {
        MyFile file = new MyFile("C:\\eclipse\\features\\org.eclipse.e4.rcp_1.4.1.v20160212-1350\\feature.xml");
        if (!file.checkMyFile())
            Assertions.fail("Path exists ");
    }
}