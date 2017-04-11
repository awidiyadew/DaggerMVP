package cf.awidiyadew.daggerexample.remote;

import cf.awidiyadew.daggerexample.model.ApiResponse;
import cf.awidiyadew.daggerexample.model.Barang;
import cf.awidiyadew.daggerexample.model.Picture;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by awidiyadew on 4/11/17.
 */

public interface ApiService {

    @GET("tb_barang?transform=1")
    Observable<ApiResponse<Barang>> getListBarang();

    @GET("tb_picture?transform=1")
    Observable<ApiResponse<Picture>> getListPicture();

}
