package model.bean.employee;

public class Degree {
    private int degreeId;
    private String degreeName;

    public Degree() {
    }

    public Degree(int degreeId, String degreeName) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
