package Algorithm.io;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO4_BufferedReaderTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("기수? " );
		int no = Integer.parseInt(in.readLine());
		System.out.println("한마디? ");
		String msg = in.readLine();
		System.out.println(no+"::"+msg);
	}
}
