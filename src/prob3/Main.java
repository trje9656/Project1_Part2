package prob3;

import prob3.Decoder;

import java.io.IOException;

public class Main {


    public static void main(String[] args)throws IOException {
        prob3.Decoder asciiDecoder = new prob3.Decoder();
        asciiDecoder.read();
        asciiDecoder.parse();
        asciiDecoder.output();
    }
}
