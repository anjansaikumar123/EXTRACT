package FILE.EXTRACT.UTIL;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import FILE.EXTRACT.POJO.FolderContents;
import FILE.EXTRACT.POJO.MyDirectory;
import FILE.EXTRACT.POJO.MyFile;

public class ExtractFileNamesUtil {

	static ExtractFileNamesUtil extractFileNamesUtil;
	public static  ExtractFileNamesUtil getInstance() {
		if(null != extractFileNamesUtil){
			return extractFileNamesUtil;
		}
		else{
			return new ExtractFileNamesUtil();
		}
	}

	public FolderContents getFolderContents(String folderPath){	
		
		List<MyFile> myFiles = new ArrayList<MyFile>();
		List<MyDirectory> myDirectories = new ArrayList<MyDirectory>();
		FolderContents folderContents = new FolderContents();
			
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		 
	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  MyFile file = new MyFile();
	    	  file.setFileName(listOfFiles[i].getName());
	    	  file.setFilePath(folderPath);
	    	  myFiles.add(file);
//	        System.out.println("adding File " + listOfFiles[i].getName()+" to the list of files");
	      } else if (listOfFiles[i].isDirectory()) {
	    	  MyDirectory directory = new MyDirectory();
	    	  directory.setDirectoryName(listOfFiles[i].getName());
	    	  directory.setDirectoryPath(folderPath/*+"\\"+listOfFiles[i].getName()*/);
	    	  myDirectories.add(directory);
//	    	  System.out.println("adding Directory " + listOfFiles[i].getName()+" to the list of directories");
	      }
	    }
	    
//	    System.out.println(myFiles.toString());
//	    System.out.println(myDirectories.toString());
	    folderContents.setMyFiles(myFiles);
	    folderContents.setMyDirectories(myDirectories);
	    return folderContents;
	}

	
	public String getFormatedOutputMessage(String outputMessage) {
		
		List<String> fileNames = new ArrayList<String>();
		List<String> filePaths = new ArrayList<String>();
		List<String> directoryNames = new ArrayList<String>();
		List<String> directoryPaths = new ArrayList<String>();
		String formatedOutputMessage ="FILEPATH , FILENAME"+"\n";
		
		while(outputMessage.contains("fileName=")){
			outputMessage = outputMessage.substring(outputMessage.indexOf("fileName")+9);
			fileNames.add(outputMessage.substring(0, outputMessage.indexOf(",")));
			outputMessage = outputMessage.substring(outputMessage.indexOf("filePath")+9);
			filePaths.add(outputMessage.substring(0, outputMessage.indexOf("]")));
		}
		
		System.out.println(fileNames);
		System.out.println(filePaths);
		
		while(outputMessage.contains("directoryName=")){
			outputMessage = outputMessage.substring(outputMessage.indexOf("directoryName")+14);
			directoryNames.add(outputMessage.substring(0, outputMessage.indexOf(",")));
			outputMessage = outputMessage.substring(outputMessage.indexOf("directoryPath")+14);
			directoryPaths.add(outputMessage.substring(0, outputMessage.indexOf("]")));
		}
		
		System.out.println(directoryNames);
		System.out.println(directoryPaths);
		
		formatedOutputMessage += (filePaths.get(0)+",");
		for(int i=0;i<fileNames.size();i++){
			formatedOutputMessage += (fileNames.get(i)+","+"\n");
			formatedOutputMessage += (" ,");
		}
		formatedOutputMessage +="\n";
		formatedOutputMessage +="DIRECTORYPATH , DIRECTORYNAME"+"\n";
		formatedOutputMessage += (directoryPaths.get(0)+",");
		for(int i=0;i<directoryNames.size();i++){
			formatedOutputMessage += (directoryNames.get(i)+","+"\n");
			formatedOutputMessage += (" ,");
		}
		
		return formatedOutputMessage;
	}
	
}
