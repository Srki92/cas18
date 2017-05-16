package rs.aleph.android.example12.activities.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.provider.JeloProvider;
import rs.aleph.android.example12.activities.provider.KategorijaProvider;

/**
 * Created by androiddevelopment on 13.5.17..
 */

public class DetailFragment extends Fragment {

    private int position = 0;

    @Override
    public void onCreate(Bundle savedInstaneceState) {
        super.onCreate(savedInstaneceState);

        Toast.makeText(getActivity(), "DetailFragment.onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanecState) {
        super.onActivityCreated(savedInstanecState);

        Toast.makeText(getActivity(), "DetailFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        if (savedInstanecState != null) {
            position = savedInstanecState.getInt("position", 0);

        }

        ImageView ivSlika = (ImageView) getView().findViewById(R.id.iv_slika);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivSlika.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvNaziv = (TextView) findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvider.getJeloById(position).getNaziv());


        TextView tvOpis = (TextView) findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        TextView tvCena = (TextView) findViewById(R.id.tv_cena);
        tvCena.setText(Float.toString(JeloProvider.getJeloById(position).getCena()));


        TextView tvKalorijskeVrednosti = (TextView) findViewById(R.id.tv_kalorijskaVrednost);
        tvKalorijskeVrednosti.setText(Float.toString(JeloProvider.getJeloById(position).getKalorijskaVrednost()));


        Spinner kategorija = (Spinner) findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNaziv();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection((int) JeloProvider.getJeloById(position).getKategorija().getId());


        Button btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + JeloProvider.getJeloById(position).getNaziv() + "!", Toast.LENGTH_LONG);
                toast.show();
            }

        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedinstanceState) {
        super.onSaveInstanceState(savedinstanceState);

        Toast.makeText(getActivity(), "DetailFragment.onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        savedinstanceState.putInt("position", position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "DetailFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Toast.makeText(getActivity(), "DetailFragment.onDestroyView()", Toast.LENGTH_SHORT).show();

    }

    public void setCntent(final int position) {
        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to" + position);


        ImageView ivSlika = (ImageView) getView().findViewById(R.id.iv_slika);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivSlika.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvNaziv = (TextView) getView().findViewById(R.id.tv_naziv);
        tvNaziv.setText(JeloProvider.getJeloById(position).getNaziv());


        TextView tvOpis = (TextView) findViewById(R.id.tv_opis);
        tvOpis.setText(JeloProvider.getJeloById(position).getOpis());

        TextView tvCena = (TextView) findViewById(R.id.tv_cena);
        tvCena.setText(Float.toString(JeloProvider.getJeloById(position).getCena()));


        TextView tvKalorijskeVrednosti = (TextView) findViewById(R.id.tv_kalorijskaVrednost);
        tvKalorijskeVrednosti.setText(Float.toString(JeloProvider.getJeloById(position).getKalorijskaVrednost()));


        Spinner kategorija = (Spinner) findViewById(R.id.sp_kategorija);
        List<String> kategorije = KategorijaProvider.getKategorijaNaziv();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, kategorije);
        kategorija.setAdapter(adapter);
        kategorija.setSelection((int) JeloProvider.getJeloById(position).getKategorija().getId());


        Button btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + JeloProvider.getJeloById(position).getNaziv() + "!", Toast.LENGTH_LONG);
                toast.show();
            }

        });
    }

    private void showNotification() {
        // Creates notification with the notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_stat_buy);
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        builder.setContentTitle(getActivity().getString(R.string.notification_title));
        builder.setContentText(getActivity().getString(R.string.notification_text));
        builder.setLargeIcon(bitmap);

        // Shows notification with the notification manager (notification ID is used to update the notification later on)
        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());

    }
}
