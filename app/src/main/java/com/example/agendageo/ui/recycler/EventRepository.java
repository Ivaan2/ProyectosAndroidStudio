package com.example.agendageo.ui.recycler;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EventRepository {

    private dao eventDao;
    private LiveData<List<Evento>> mAllWords;

    EventRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        eventDao = db.eventDao();
        mAllWords = eventDao.getAllEvents();
    }

    LiveData<List<Evento>> getAllWords() {
        return mAllWords;
    }

    public void insert (Evento e) {
        new insertAsyncTask(eventDao).execute(e);
    }

    private static class insertAsyncTask extends AsyncTask<Evento, Void, Void> {

        private dao mAsyncTaskDao;

        insertAsyncTask(dao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Evento... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
