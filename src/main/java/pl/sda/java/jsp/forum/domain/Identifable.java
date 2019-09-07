package pl.sda.java.jsp.forum.domain;

public abstract class Identifable {

    private static int ID_SEQUENCE = 0;

    Identifable(){
        id = ID_SEQUENCE ++;
    }

    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
