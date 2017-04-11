package cf.awidiyadew.daggerexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class Barang {

    @SerializedName("id_barang")
    @Expose
    public String idBarang;

    @SerializedName("id_supplier")
    @Expose
    public String idSupplier;

    @SerializedName("nama_barang")
    @Expose
    public String namaBarang;

    @SerializedName("harga_beli")
    @Expose
    public String hargaBeli;

    @SerializedName("harga_jual")
    @Expose
    public String hargaJual;

    @SerializedName("merk")
    @Expose
    public String merk;

    @SerializedName("kategori")
    @Expose
    public String kategori;

    @SerializedName("keterangan")
    @Expose
    public String keterangan;

    @SerializedName("stok")
    @Expose
    public String stok;

    @SerializedName("tb_picture")
    @Expose
    public ArrayList<Picture> pictures;

    public Barang() {
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(String hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public String getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(String hargaJual) {
        this.hargaJual = hargaJual;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public ArrayList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getRupiah(){
        String harga = NumberFormat.getIntegerInstance().format(Integer.valueOf(getHargaJual()));
        return "Rp " + harga;
    }
}
