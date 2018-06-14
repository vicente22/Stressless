package cl.vicentepc.stressless.views.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import cl.vicentepc.stressless.PendingClickListener;
import cl.vicentepc.stressless.R;
import cl.vicentepc.stressless.adapters.PendingsAdapter;
import cl.vicentepc.stressless.models.Pending;
import cl.vicentepc.stressless.views.details.DetailsActivity;

public class PendingsFragment extends Fragment implements PendingClickListener {

    private PendingsAdapter adapter;

    public static final String PENDING_ID = "cl.vicentepc.stressless.views.main.KEY.PENDING_ID";

    public PendingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.pendingRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        /*for (int i = 0; i < 20; i++) {
            Pending pending = new Pending();
            pending.setName(String.valueOf(i));
            pending.setDone(false);
            pending.save();
        }*/

        adapter = new PendingsAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateSearch(String name){

    }

    public void updateList(Pending pending) {
        adapter.update(pending);
        Log.e("PENDING", pending.getName());
    }

    @Override
    public void clickedID(long id) {

        //Toast.makeText(getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(getActivity(), DetailsActivity.class);
        myIntent.putExtra(PENDING_ID, id);
        startActivity(myIntent);

    }
}