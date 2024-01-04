package _20010310065_Suha_Vural_;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _20010310065_Main {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> list = new ArrayList<>();
		String fileName = "FST.txt";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String row = sc.nextLine();
			list.add(row);
		}
		sc.close();
		System.out.println(fileName + " dosyasý okundu.");
		_20010310065_Fst fst = new _20010310065_Fst();
		fst.setList(list);
		fst.execute();
	}

}

