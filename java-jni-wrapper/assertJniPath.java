/*
 *
 * Vaisala software source code file
 *
 * Copyright (c) Vaisala Oyj 2016. All rights reserved.
 *
 */

/**
 * A java test class to verify that "usr/lib/jni" is in the dynamic library path.
 * 
 * @author eja
 * @date 2016-05-18
 */
public class assertJniPath {

    public static void main(String[] args) {
        String javaLibraryPath = System.getProperty("java.library.path");
        System.out.println("java.library.path="+javaLibraryPath);
        if (javaLibraryPath.contains("usr/lib/jni")) {
            System.out.println("ok");
        } else {
            throw new AssertionError("'usr/lib/jni' is not in java.library.path");
        }
    }

}
