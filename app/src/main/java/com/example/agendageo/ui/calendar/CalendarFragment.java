package com.example.agendageo.ui.calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.agendageo.R;
import com.example.agendageo.databinding.FragmentCalendarBinding;
import com.example.agendageo.ui.recycler.EventViewModel;
import com.example.agendageo.ui.recycler.Evento;

import java.util.Calendar;

public class CalendarFragment extends Fragment {

    CalendarView calFecha;
    public FragmentCalendarBinding binding;
    EditText titulo, latitud, longitud, descripcion, fecha;
    Button button;

    //12
    public static final String EXTRA_REPLY =
            "com.example.android.roomwordssample.REPLY";

    private EditText mEditWordView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        calFecha = root.findViewById(R.id.calendarView);

        final long[] nuevaFecha = {0};
        calFecha.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);

                nuevaFecha[0] = c.getTimeInMillis(); //esto es lo que usaremos luego
            }
        });

        //12
        button = root.findViewById(R.id.button);
        EventViewModel eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                titulo = root.findViewById(R.id.titulo);
                latitud = root.findViewById(R.id.latitud);
                longitud = root.findViewById(R.id.longitud);
                descripcion = root.findViewById(R.id.descripcion);

                Evento evento = new Evento(titulo.getText().toString(), descripcion.getText().toString(), Double.parseDouble(String.valueOf(latitud.getText())), Double.parseDouble(String.valueOf(longitud.getText())), nuevaFecha[0]);

                eventViewModel.insert(evento);
                titulo.setText(null);
                latitud.setText(null);
                longitud.setText(null);
                descripcion.setText(null);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}