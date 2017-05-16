package rs.aleph.android.example12.activities.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.provider.JeloProvider;

/**
 * Created by androiddevelopment on 13.5.17..
 */

public class MasterFragment extends Fragment {

   AdapterView.OnItemSelectedListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Toast.makeText(getActivity() , "MasterFragment.onCreate()" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        Toast.makeText(getActivity(), "MasterFragment.onActivityCreated()" , Toast.LENGTH_SHORT).show();


        final List<String> jeloNaziv = JeloProvider.getJeloNaziv();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, jeloNaziv);
        ListView listView = (ListView) getActivity().findViewById(R.id.listofJelo);



        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(parent, view, position, id);
            }

        });
    }


    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle saveddInstanceState ) {

        Toast.makeText(getActivity(), "MasterFragment.onCreateView()" , Toast.LENGTH_SHORT).show();

        if(container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_master,container, false);

        return view;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();


        Toast.makeText(getActivity(), "MasterFragment.onDestroyView()" , Toast.LENGTH_SHORT).show();

    }

    @Override

    public void onAttach(Activity activity) {

        super.onAttach(activity);

        Toast.makeText(getActivity(), "MasterFragment.onAttach()" , Toast.LENGTH_SHORT).show();

        try{
            listener = (AdapterView.OnItemSelectedListener) activity;
        } catch (ClassCastException e ) {
            throw new ClassCastException(activity.toString() + "must implement onItemSelectedListener");

        }
    }

    public interface OnItemSelectedListener {
        public void onItemSelected(int position);
    }
}
