package _20010310065_Suha_Vural_;

import java.util.ArrayList;
import java.util.Scanner;

public class _20010310065_Fst {
	private ArrayList<String> list;
	private String initialState;
	private ArrayList<String> states;
	private ArrayList<String> inputAlphabets;
	private String[][] functionTable;

	public void execute() {
		setInitialState();
		setStates();
		setInputAlphabets();
		setFunctionTable();
		inputAndOutput();
	}

	private void inputAndOutput() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		while (i < 2) {
			String outputAlphabets = "";
			String linkedStates = "";
			linkedStates += initialState;
			String onState = initialState;
			String onAlphabet = "";
			int rowIndex = 0;
			int columnIndex = 0;
			System.out.println("Lütfen input’u giriniz:");
			String query = input.nextLine();
			for (int j = 0; j < query.length(); j++) {
				onAlphabet = String.valueOf(query.charAt(j));
				for (int k = 0; k < functionTable.length; k++) {
					if (functionTable[k][0].equals(onState)) {
						rowIndex = k;
					}
				}
				for (int l = 0; l < functionTable[0].length; l++) {
					if (functionTable[0][l].equals(onAlphabet)) {
						columnIndex = l;
					}
				}
				String unionValue = functionTable[rowIndex][columnIndex];
				onState = unionValue.split("-")[0];
				outputAlphabets += unionValue.split("-")[1];
				linkedStates = linkedStates + ", " + onState;
			}
			System.out.println("Durumlarýn sýrasý: " + linkedStates);
			System.out.println("Çýktý: " + outputAlphabets);
			i++;
		}
		input.close();
	}

	private void setFunctionTable() {
		functionTable = new String[states.size() + 1][inputAlphabets.size() + 1];
		int rowCount = functionTable.length;
		int index = 3;
		for (int i = 0; i < rowCount; i++) {
			int j = 0;
			for (String item : list.get(index + i).replace(", ", "-").split("	")) {
				functionTable[i][j] = item.replace("(", "").replace(")", "");
				j++;
			}
		}
	}

	private void setInputAlphabets() {
		inputAlphabets = new ArrayList<>();
		for (String alphabet : list.get(1).split(" = ")[1].replace("{", "").replace("}", "").split(", ")) {
			inputAlphabets.add(alphabet);
		}
	}

	private void setStates() {
		states = new ArrayList<>();
		for (String state : list.get(0).split(" = ")[1].replace("{", "").replace("}", "").split(", ")) {
			states.add(state);
		}
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	private void setInitialState() {
		int listSize = list.size();
		String stateRow = list.get(listSize - 1);
		for (int i = 0; i < stateRow.length(); i++) {
			if (stateRow.charAt(i) == '=') {
				this.initialState = stateRow.substring((i + 2), stateRow.length());
			}
		}
	}
}
