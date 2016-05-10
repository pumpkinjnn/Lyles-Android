package grinnell.appdev.edu.lyles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grinnell.appdev.edu.lyles.Adapters.EventsAdapter;
import grinnell.appdev.edu.lyles.Model.Event;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Event> events = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup colors and title


        // Initialize events and pass them to adapter
        events.add(new Event("Pub Talk", new Date(), new Date(), "", 0));
        recyclerView = (RecyclerView) findViewById(R.id.schedule_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new EventsAdapter(events, getApplicationContext());
        System.out.println(adapter.getItemCount());
        recyclerView.setAdapter(adapter);

    }
}
