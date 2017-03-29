/* FileName: PestObj.java
 * Purpose: Pest object
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class PestObj {

	private int pestID;
	private String pestSeen;
	private String pestManagement;
	private int inspectionID;

	public PestObj() {}

	public int getPestID() {
		return pestID;
	}

	public void setPestID(int pestID) {
		this.pestID = pestID;
	}

	public String getPestSeen() {
		return pestSeen;
	}

	public void setPestSeen(String pestSeen) {
		this.pestSeen = pestSeen;
	}

	public String getPestManagement() {
		return pestManagement;
	}

	public void setPestManagement(String pestManagement) {
		this.pestManagement = pestManagement;
	}

	public int getInspectionID() {
		return inspectionID;
	}

	public void setInspectionID(int inspectionID) {
		this.inspectionID = inspectionID;
	}

}
