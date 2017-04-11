package cf.awidiyadew.daggerexample.ui.listBarang;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import cf.awidiyadew.daggerexample.R;
import cf.awidiyadew.daggerexample.model.Barang;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class ListBarangAdapter extends RecyclerView.Adapter<ListBarangAdapter.ListBarangVHolder> {

    ArrayList<Barang> mListBarang;

    public ListBarangAdapter() {
        mListBarang = new ArrayList<>();
    }

    @Override
    public ListBarangVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        return new ListBarangVHolder(view);
    }

    @Override
    public void onBindViewHolder(ListBarangVHolder holder, int position) {
        Barang barang = mListBarang.get(position);
        holder.bind(barang);
    }

    @Override
    public int getItemCount() {
        return mListBarang.size();
    }

    public void add(Barang barang){
        mListBarang.add(barang);
        notifyItemInserted(mListBarang.size());
    }

    public class ListBarangVHolder extends RecyclerView.ViewHolder{

        @BindColor(R.color.colorPrimary) int primaryColor;
        @BindView(R.id.img_thumbnail) ImageView imgThumb;
        @BindView(R.id.tv_nama_barang) TextView tvNamaBarang;
        @BindView(R.id.tv_harga) TextView tvHarga;

        public ListBarangVHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Barang barang){
            if (barang != null){
                tvNamaBarang.setText(barang.getNamaBarang());
                tvHarga.setText(barang.getRupiah());

                if (barang.getPictures() != null){
                    String imgUrl = String.format("http://awidiyadew.cf/MettaHardware/api/%s", barang.getPictures().get(0).getPath());

                    Glide.with(imgThumb.getContext())
                            .load(imgUrl)
                            .crossFade()
                            .into(imgThumb);

                    Log.d("TAG", "bind: " + imgUrl);

                } else {
                    Log.d("TAG", "bind: getpicture null");
                }
            }
        }

    }
}
