package br.com.concretesolutions.workshops.camel.utils;

import java.util.UUID;

public class FileNameGenerator {
	
	
	public String generateFileName() {
		return UUID.randomUUID().toString();
	}

}
