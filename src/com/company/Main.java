package com.company;

import com.company.Sorter;

import java.io.IOException;

public class Main {


    public static void main(String[] args)throws IOException {
        com.company.Sorter StringSort = new com.company.Sorter();
        StringSort.read();
        StringSort.sort();
        StringSort.write();

    }
}
