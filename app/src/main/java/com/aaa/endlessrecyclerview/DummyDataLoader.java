package com.aaa.endlessrecyclerview;

import android.os.AsyncTask;

import java.util.concurrent.TimeUnit;

/**
 * Created by Abbas on 2/12/2018.
 */

public class DummyDataLoader extends AsyncTask<Void, Void, Integer> {

    private ResponseCallback mCallback = null;

    public void setDataLoaderCallback(ResponseCallback callback)
    {
        mCallback = callback;
    }

    @Override
    protected Integer doInBackground(Void... voids)
    {
        try {
            TimeUnit.SECONDS.sleep(0);
        }
        catch (InterruptedException iEx) {
            iEx.printStackTrace();
        }

        return 20;
    }

    @Override
    public void onPostExecute(Integer result)
    {
        if (!isCancelled() && mCallback != null) {
            mCallback.onResponse(result);
        }
    }
}
