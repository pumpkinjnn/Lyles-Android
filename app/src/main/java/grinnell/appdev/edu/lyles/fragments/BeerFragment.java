package grinnell.appdev.edu.lyles.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import grinnell.appdev.edu.lyles.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BeerFragment extends Fragment{

    ArrayList<Beers> beersList;
    private static final String BEER_DATA_URL ="http://www.cs.grinnell.edu/~birnbaum/appdev/lyles/beer.json";
    BeersAdapter mBeerAdapter;
    RecyclerView rvBeers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final String TAG = BeerFragment.this.getTag();

        View view = inflater.inflate(R.layout.beer_layout,container,false);
        // ...
        // Lookup the recyclerview in activity layout
        rvBeers = (RecyclerView) view.findViewById(R.id.rvBeers);

        // Initialize contacts
        beersList =new ArrayList<Beers>();

        new BeersAsyncTask(this).execute(BEER_DATA_URL);
        // Create adapter passing in the sample user data
        mBeerAdapter = new BeersAdapter(this, beersList);
        // Attach the adapter to the recyclerview to populate items
        mBeerAdapter.notifyDataSetChanged();
        rvBeers.setAdapter(mBeerAdapter);
        // Set layout manager to position the items
        rvBeers.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        // That's all!
        return view;
    }

    public class BeersAsyncTask extends AsyncTask<String, Void, Boolean> {
        ArrayList<Beers> mBeerList;
        private BeerFragment mParent;

        public BeersAsyncTask(BeerFragment parent) {
            mParent = parent;
        }

        @Override
        protected Boolean doInBackground(String... params) {
                mBeerList = new ArrayList<Beers>();
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(BEER_DATA_URL)
                        .build();
                Response response = null;

                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            try  {
                String jsonData = null;
                try {
                    jsonData = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject Jobject = new JSONObject(jsonData);
                JSONArray beers = Jobject.getJSONArray("beer");

                for (int i=0;i<beers.length();i++){
                    Beers beer = new Beers();

                    JSONObject aBeer = beers.getJSONObject(i);

                    beer.setTitle(aBeer.getString("title"));
                    beer.setSubtitle(aBeer.getString("subtitle"));
                    beer.setPrice(aBeer.getDouble("price"));
                    beer.setImage(aBeer.getString("image"));
                    beer.setDetails(aBeer.getString("details"));

                    mBeerList.add(beer);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if(!result){
                // print message
            }else {
              // Log.d("Larry", mBeerList.get(0).getDetails().toString());
                beersList = mBeerList;
                mBeerAdapter = new BeersAdapter(mParent, mBeerList);
                rvBeers.swapAdapter(mBeerAdapter, true);
            }
        }
    }
}




