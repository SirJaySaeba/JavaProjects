package main.app;

import java.io.File;

import org.apache.tika.metadata.Metadata;

public class MissingMetaInformationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void fileWithNoMetaInfo(FileData fileData){
		System.err.println("-------------------------------");
		System.err.println("No Meta: "+fileData.getAbsolutePath());
	}
	
}
