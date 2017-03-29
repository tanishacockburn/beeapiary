/* FileName: InspectionObj.java
 * Purpose: Inspection object
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class InspectionObj {

	private int inspectionID;
	private String dateofInspection;
	private String hiveBehaviour;
	private String observation;
	private String concern;
	private int hiveID;

	public InspectionObj() {}

	public int getInspectionID() {
		return inspectionID;
	}

	public void setInspectionID(int inspectionID) {
		this.inspectionID = inspectionID;
	}

	public String getDateofInspection() {
		return dateofInspection;
	}

	public void setDateofInspection(String dateofInspection) {
		this.dateofInspection = dateofInspection;
	}

	public String getHiveBehaviour() {
		return hiveBehaviour;
	}

	public void setHiveBehaviour(String hiveBehaviour) {
		this.hiveBehaviour = hiveBehaviour;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

	public int getHiveID() {
		return hiveID;
	}

	public void setHiveID(int hiveID) {
		this.hiveID = hiveID;
	}
}
