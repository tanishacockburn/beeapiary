/* FileName: QueenObj.java
 * Purpose: Queen object
 * Revision History
 * 		Steven Bulgin, 2017.03.26: Created
 */

package io.github.steve_bulgin.models;

public class QueenObj {

    private int queenID;
    private String queenBirth;
    private String queenReplaced;
    private int hiveID;

    public QueenObj() {}

    public int getQueenID() {
        return queenID;
    }

    public void setQueenID(int queenID) {
        this.queenID = queenID;
    }

    public String getQueenBirth() {
        return queenBirth;
    }

    public void setQueenBirth(String queenBirth) {
        this.queenBirth = queenBirth;
    }

    public String getQueenReplaced() {
        return queenReplaced;
    }

    public void setQueenReplaced(String queenReplaced) {
        this.queenReplaced = queenReplaced;
    }

    public int getHiveID() {
        return hiveID;
    }

    public void setHiveID(int hiveID) {
        this.hiveID = hiveID;
    }
}
