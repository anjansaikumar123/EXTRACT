package FILE.EXTRACT.POJO;

import java.util.ArrayList;
import java.util.List;

public class FolderContents {

	private List<MyFile> myFiles = new ArrayList<MyFile>();
	private List<MyDirectory> myDirectories = new ArrayList<MyDirectory>();
	
	public List<MyFile> getMyFiles() {
		return myFiles;
	}
	public void setMyFiles(List<MyFile> myFiles) {
		this.myFiles = myFiles;
	}
	public List<MyDirectory> getMyDirectories() {
		return myDirectories;
	}
	public void setMyDirectories(List<MyDirectory> myDirectories) {
		this.myDirectories = myDirectories;
	}
	
	@Override
	public String toString() {
		return "FolderContents [myFiles=" + myFiles.toString() + ", myDirectories="
				+ myDirectories.toString() + "]";
	}
	
}
