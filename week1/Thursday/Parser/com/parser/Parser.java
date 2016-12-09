package com.parser;

import com.listify.Listify;

class Parser {

	public static void main(String[] args) {


		String[] content = Listify.readToArray("com/parser/something.ini");
		
		boolean inObject = false;
		boolean inProperty=false;

		System.out.println('{');
		//	
		for(String line : content ) {

			if(isLineBlank(line.trim())) {
				continue;
			} else {
				if(line.contains("[")) {
					if(inObject) {
						System.out.println();
						System.out.println("\t" + "},");
					}
					inObject=true;
					inProperty=false;
					readObj(line);
				} else {
					if(inProperty) {
						System.out.println(',');
					}
					readProperty(line);
					inProperty=true;
				
}			}
		}
		System.out.println("\n\t" + '}');
		System.out.println('}');
	}

	public static boolean isLineBlank(String line) {
		return line.length()<1;
	}
	public static void readObj(String line) {
		line = line.replace('[','\"');
		line = line.replace(']','\"');
		System.out.println("\t" + line + ": {");
	}

	public static void readProperty(String line) {
		if(line.contains(";")) {
			int index = line.indexOf(';');
			line=line.substring(0,index);
		}
		String[] str =  line.split("=");
		System.out.print("\t" + "\t" + '\"' + str[0] + '\"' + ": " + '\"' + str[1] + '\"' );
	}
}