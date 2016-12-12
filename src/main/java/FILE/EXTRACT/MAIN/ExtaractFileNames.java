package FILE.EXTRACT.MAIN;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import FILE.EXTRACT.POJO.FolderContents;
import FILE.EXTRACT.UTIL.ExtractFileNamesUtil;

public class ExtaractFileNames {
	
	static ExtaractFileNames extaractFileNames;
	static ExtractFileNamesUtil extractFileNamesUtil;
	private static ExtaractFileNames getInstance() {
		if(null != extaractFileNames){
			return extaractFileNames;
		}
		else{
			return new ExtaractFileNames();
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		String inputPath ="E:\\5.TECHNOLOGIES\\YOUTUBE";
		String outputFilePath = "C:\\Users\\anjan\\Git\\EXTRACT\\OUTPUT_FILES\\";
		String outputFileName = "Folder Details_"+inputPath.substring(inputPath.lastIndexOf("\\")+1)+".csv";
		String outputFileName1 = "Folder Details1_"+inputPath.substring(inputPath.lastIndexOf("\\")+1)+".csv";
		ExtractFileNamesUtil extractFileNamesUtil = ExtractFileNamesUtil.getInstance();
		
		FolderContents folderContents = new FolderContents();
		folderContents = extractFileNamesUtil.getFolderContents(inputPath);
		System.out.println(folderContents.toString());
		
		String outputMessage = folderContents.toString();
		String formatedOutputMessage = extractFileNamesUtil.getFormatedOutputMessage(outputMessage);
		System.out.println("formatedOutputMessage is \n"+formatedOutputMessage);
		
		PrintWriter writer = new PrintWriter(outputFilePath+outputFileName);
		writer.println(formatedOutputMessage);
		writer.close();
		
		List<String> lines = Arrays.asList(formatedOutputMessage);
		Path file = Paths.get(outputFilePath+outputFileName1);
		Files.write(file, lines);
		
	}
	
}