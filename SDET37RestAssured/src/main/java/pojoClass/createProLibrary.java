package pojoClass;
/**
 * 
 * @author nithin
 *
 */
public class createProLibrary {
	//create the keys as global variables
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	//create constructor
	public createProLibrary() {
		
	}
	/**
	 * this method is used to create request body
	 * @param createdBy
	 * @param projectName
	 * @param status
	 * @param teamSize
	 */
	public createProLibrary(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
}
