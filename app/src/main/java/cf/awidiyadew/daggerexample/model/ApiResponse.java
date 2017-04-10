package cf.awidiyadew.daggerexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class ApiResponse {

    /* TODO : REPLACE NAME ACCORDINGLY MODEL RESPONSE (ApiResponse<Model>)*/

    @SerializedName("tb_barang")
    @Expose
    public List<Barang> tbBarang = null;

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
}
