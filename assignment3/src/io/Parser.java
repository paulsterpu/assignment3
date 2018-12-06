package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Parser {
	public static String readFromFile(String path) throws IOException {
		// TODO(1): Implementati functia readFromFile, care citeste un fisier si ii intoarce
		// continutul sub forma de String.
		
		 String logs = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);	
		 
		return logs;
	}
}
