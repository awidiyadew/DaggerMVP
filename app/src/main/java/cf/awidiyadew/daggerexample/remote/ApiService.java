package cf.awidiyadew.daggerexample.remote;

import cf.awidiyadew.daggerexample.model.ApiResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by awidiyadew on 4/11/17.
 */

public interface ApiService {

    @GET("tb_barang?transform=1")
    Observable<ApiResponse> getListBarang();

}
