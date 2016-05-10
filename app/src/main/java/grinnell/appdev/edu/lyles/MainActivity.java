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
        setTitle(R.string.schedule_title);

        // Initialize events and pass them to adapter
        events.add(new Event("Political Science SEPC Pub Night", new Date(), new Date(), "", 100));
        events.add(new Event("Computer Science SEPC Pub Talk", new Date(), new Date(), "", 90));
        events.add(new Event("Marcel Champagne Pub Speech", new Date(), new Date(), "", 15));
        recyclerView = (RecyclerView) findViewById(R.id.schedule_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Set up adapter
        adapter = new EventsAdapter(events, getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
