/* FileName: TreatmentObj.java
 * Purpose: Treatment object
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class TreatmentObj {


	private int treatmentID;
	private String treatmentapplied;
	private String concerns;
	private int inspectionID;


	public TreatmentObj() {}

	public int getTreatmentID() {
		return treatmentID;
	}

	public void setTreatmentID(int treatmentID) {
		this.treatmentID = treatmentID;
	}

	public String getTreatmentapplied() {
		return treatmentapplied;
	}

	public void setTreatmentapplied(String treatmentapplied) {
		this.treatmentapplied = treatmentapplied;
	}

	public String getConcerns() {
		return concerns;
	}

	public void setConcerns(String concerns) {
		this.concerns = concerns;
	}

	public int getInspectionID() {
		return inspectionID;
	}

	public void setInspectionID(int inspectionID) {
		this.inspectionID = inspectionID;
	}

}
