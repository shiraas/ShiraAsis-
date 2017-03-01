package com.company;

import java.io.File;

/**
 * Created by hackeru on 2/28/2017.
 */
public class MyFile {

    private File file;

    public MyFile(String pathname) {
        file = new File(pathname);
    }

    public boolean checkMyFile() {
        if (file.exists() && (file.isFile()))
            return true;
        return false;

    }

    public File getFile() {
        return file;
    }
}