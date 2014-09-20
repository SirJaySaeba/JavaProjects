package main.app;

import java.io.File;

import javax.swing.JOptionPane;

import org.apache.tika.metadata.Metadata;

public class FileAccess {

	private static final String ARTIST = "xmpDM:artist";
	private static final String ALBUM = "xmpDM:album";
	private static final String COMPOSER = "xmpDM:composer";
	private static final String TRACKNO = "xmpDM:trackNumber";
	private static final String TITLE = "title";
	private static final String DURATION = "xmpDM:duration";
	
	private void prepareFileData(File fileEntry) {
		Metadata metadata;
		FileData fileData = new FileData(fileEntry.getPath());
		metadata = fileData.getMetaData(fileEntry);
		fileData.setDuration(metadata.get(DURATION));
		if (fileData.getDuration() != null ) {
			try{
					
				fileData.setTitle(metadata.get(TITLE));
				fileData.setArtist(metadata.get(ARTIST));
				fileData.setTrackNo(metadata.get(TRACKNO));
				fileData.setComposer(metadata.get(COMPOSER));
				fileData.setAlbum(metadata.get(ALBUM));
				//fileData.displayMetaData(fileData);
				if(fileData.getTitle() == null || fileData.getTitle() == ""
						|| fileData.getTrackNo() == null || fileData.getTrackNo() == ""){
					throw new MissingMetaInformationException();
				}else{
					renameFile(fileData);
				}
			}catch(MissingMetaInformationException e){				
				e.fileWithNoMetaInfo(fileData);;
			}
		}		
	}

	private void displayNonMp3Files(File fileEntry){		
		if(!(fileEntry.getName().equals("desktop.ini") 
				|| fileEntry.getName().equals("Thumbs.db")
				|| fileEntry.getName().toLowerCase().contains(".jpg")
				|| fileEntry.getName().toLowerCase().contains(".png")
				)){					
			System.out.println(fileEntry.getPath());
		}
	}
	
	private void deleteNonMp3Files(File fileEntry){
		if(fileEntry.getName().contains(".nfo") 
				|| fileEntry.getName().contains(".log")
				|| fileEntry.getName().contains(".txt")
				|| fileEntry.getName().contains(".rtf")){
			fileEntry.delete();
		}		
	}
	
	private void checkAndRename(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				checkAndRename(fileEntry);
			}else if(!fileEntry.getName().toLowerCase().contains(".mp3")){
				displayNonMp3Files(fileEntry);
				deleteNonMp3Files(fileEntry);
				continue;
			} else {
				prepareFileData(fileEntry);
			}
		}
	}

	private void renameFile(FileData fileData) {
		File newFile = null;
		String folderPath = fileData.getParent();
		String fileLocation = fileData.getPath();
		String currentfileName = fileData.getName();
		String metaTitle = fileData.getTitle();

		//Since there are actually trackNos like 10/14, a split is needed
		String metaTrackNo = fileData.getTrackNo();
		if(metaTrackNo == null){
			metaTrackNo = "00";
		}else if(metaTrackNo.length() > 2){
			String [] ridTrackNo = metaTrackNo.split("/");
			metaTrackNo = ridTrackNo[0];
		}

		final String newFileName = replaceNameString(currentfileName, metaTitle, metaTrackNo);

		try {
			fileData = new FileData(fileLocation);
			System.out.println(newFileName);
			newFile = new File(folderPath + "/" + newFileName);
			fileData.renameTo(newFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("xxxxxxxxxxxxx--------NOOOOOOOOOOOOOOOOOOOOOOOO!!-----xxxxxxxxxxxxxxx");
		}
	}

	private String replaceNameString(String fileName, String metaTitle, String metaTrackNo) {
		
		if(!(metaTitle == null || metaTitle == "")){
			fileName = metaTitle;
		}else{
			return fileName;
		}
		
		if(metaTrackNo != null){
			metaTrackNo = String.format("%02d", Integer.parseInt(metaTrackNo));
			fileName = metaTrackNo+" - "+fileName;
		}
		
		return fileName.concat(".mp3");
	}

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		String destination = JOptionPane.showInputDialog("Wie heiﬂt der Zielordner?");
		destination = destination.replace("\\", "/");

		File folder = new File(destination);
		fa.checkAndRename(folder);
	}
}