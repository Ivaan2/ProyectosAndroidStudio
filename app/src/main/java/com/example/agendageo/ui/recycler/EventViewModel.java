package com.example.agendageo.ui.recycler;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private EventRepository mRepository;

    private LiveData<List<Evento>> mAllEvents;

    public EventViewModel (Application application) {
        super(application);
        mRepository = new EventRepository(application);
        mAllEvents = mRepository.getAllWords();
    }

    public LiveData<List<Evento>> getAllWords() { return mAllEvents; }

    public void insert(Evento e) { mRepository.insert(e); }
}
