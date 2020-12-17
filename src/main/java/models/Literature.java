package models;

public class Literature {
    private int literatureId;
    private String literatureName;

    public Literature(int literatureId, String literatureName) {
        this.literatureId = literatureId;
        this.literatureName = literatureName;
    }

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    public String getLiteratureName() {
        return literatureName;
    }

    public void setLiteratureName(String literatureName) {
        this.literatureName = literatureName;
    }
}
