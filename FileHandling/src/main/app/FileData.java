package main.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class FileData extends File{

	public FileData(String fileLocation) {
		super(fileLocation);
	}

	private static final long serialVersionUID = 1L;
	private String title;
	private String trackNo;
	private String artist;
	private String composer;
	private String album;
	private String duration;
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrackNo() {
		return trackNo;
	}

	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Metadata getMetaData(File fileEntry){
		String loc = fileEntry.getPath();
		Metadata metadata = new Metadata();
		ContentHandler handler = new DefaultHandler();
		ParseContext parseCtx = new ParseContext();
		Parser parser = new Mp3Parser();
		
		try {
			InputStream input = new FileInputStream(new File(loc));
			parser.parse(input, handler, metadata, parseCtx);
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e){
			System.err.println("----------------------------");
			System.err.println("fuggit!! somethings Wrong with File");
			System.err.println(fileEntry.getAbsolutePath());
			System.err.println("----------------------------");
		}
		return metadata;
	}
	
	public void showAllMetaAttributes(Metadata metadata){		
		String[] metadataNames = metadata.names();
		
		for (String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
		}
		System.out.println("-----------------------------------");
	}
	
	public void displayMetaData(FileData fileData){
		System.out.println("Title: " + fileData.getTitle());
		System.out.println("Artists: " + fileData.getArtist());
		System.out.println("Composer : " + fileData.getComposer());
		System.out.println("Album : " + fileData.getAlbum());
		System.out.println("Trackno.: "+fileData.getTrackNo());		
		System.out.println("------------------------------------");
	}
	
}
