package cf.awidiyadew.daggerexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class ApiResponse<T> {

    /* TODO : REPLACE NAME ACCORDINGLY MODEL RESPONSE (ApiResponse<Model>)*/

    @SerializedName("tb_barang")
    @Expose
    public List<Barang> tbBarang = null;

    @SerializedName("tb_picture")
    @Expose
    public List<Picture> tbPicture = null;

    public ApiResponse() {
    }

    public ApiResponse(List<Barang> tbBarang) {
        this.tbBarang = tbBarang;
    }

    public List<Barang> getTbBarang() {
        return tbBarang;
    }

    public void setTbBarang(List<Barang> tbBarang) {
        this.tbBarang = tbBarang;
    }

    public List<Picture> getTbPicture() {
        return tbPicture;
    }

    public void setTbPicture(List<Picture> tbPicture) {
        this.tbPicture = tbPicture;
    }
}
