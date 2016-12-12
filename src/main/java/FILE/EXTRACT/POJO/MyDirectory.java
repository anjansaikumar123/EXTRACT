package FILE.EXTRACT.POJO;

public class MyDirectory {

	private String directoryName;
	private String directoryPath;
	
	public String getDirectoryName() {
		return directoryName;
	}
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	public String getDirectoryPath() {
		return directoryPath;
	}
	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
	
	@Override
	public String toString() {
		return "MyDirectory [directoryName=" + directoryName
				+ ", directoryPath=" + directoryPath + "]";
	}
	
}
