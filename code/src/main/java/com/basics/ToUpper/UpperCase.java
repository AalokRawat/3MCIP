package com.basics.ToUpper;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCase extends FilterInputStream {

    public UpperCase(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int i = super.read();
        return Character.toUpperCase(i);
    }
}
