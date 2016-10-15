package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Pokemon.Pokemon;

public class TestRun
{
	public static void main(String [] args) throws IOException
	{
		File myFile = new File("src/Resources/testPoke.txt");
		Pokemon test = new Pokemon(myFile);
	}
}
