package org.com.core.threads;

import java.io.IOException;

public class OpenNotePad {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("notepad");
    }
}
