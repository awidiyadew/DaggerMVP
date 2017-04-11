package cf.awidiyadew.daggerexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class Picture {
    @SerializedName("id_picture")
    @Expose
    public String idPicture;

    @SerializedName("id_barang")
    @Expose
    public String idBarang;

    @SerializedName("path")
    @Expose
    public String path;

    public Picture() {
    }

    public String getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(String idPicture) {
        this.idPicture = idPicture;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
