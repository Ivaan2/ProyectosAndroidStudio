package com.example.agendageo.ui.recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendageo.R;

import java.util.ArrayList;
import java.util.List;

;

public class EventosFragment extends Fragment {

    private RecyclerView recyclerEventos;
    private EventoAdapter eventoAdapter;
    private List<Evento> eventoList = new ArrayList<>();
    //11
    private EventViewModel mWordViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerEventos = view.findViewById(R.id.lista);


        meterDatos();
        mostrarDatos();

        // Get a handle to the RecyclerView.
        recyclerEventos = (RecyclerView) view.findViewById(R.id.lista);
        // Create an adapter and supply the data to be displayed.
        eventoAdapter = new EventoAdapter(getContext());
        // Connect the adapter with the RecyclerView.
        recyclerEventos.setAdapter(eventoAdapter);
        // Give the RecyclerView a default layout manager.
        recyclerEventos.setLayoutManager(new LinearLayoutManager(getContext()));

        //11
        mWordViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        //11
        mWordViewModel.getAllWords().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            eventoAdapter.setWords(words);
        });

        return view;
    }

    private void mostrarDatos() {
        recyclerEventos.setLayoutManager(new LinearLayoutManager(getContext()));
        eventoAdapter = new EventoAdapter(getContext());
        recyclerEventos.setAdapter(eventoAdapter);
    }

    private void meterDatos() {
        for(int i = 0; i < 10; i++){
            this.eventoList.add(new Evento("Hola"+i, "He saludado", 10, 45, 0));
        }
    }
}