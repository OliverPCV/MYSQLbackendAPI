package cz.educanet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.ApplicationPath;
import java.io.Serializable;

public class Animals {

    private String  jmeno;
    private String   druh;
    private String     id;
    private String narozen;
    private String    vaha;

    public Animals(){

    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getDruh() {
        return druh;
    }

    public void setDruh(String druh) {
        this.druh = druh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNarozen() {
        return narozen;
    }

    public void setNarozen(String narozen) {
        this.narozen = narozen;
    }

    public String getVaha() {
        return vaha;
    }

    public void setVaha(String vaha) {
        this.vaha = vaha;
    }
}
