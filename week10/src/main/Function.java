package main;

public class Function {

	private String fnName;
	private String input;
	private String output;

	public Function(String fnName, String input, String output) {
		setFnName(fnName);
		setInput(input);
		setOutput(output);
	}

	public Function() {
		fnName = "";
		input = "";
		output = "";
	}

	public String getFnName() {
		return fnName;
	}

	public void setFnName(String fnName) {
		this.fnName = fnName;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
