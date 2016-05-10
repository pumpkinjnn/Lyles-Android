package grinnell.appdev.edu.lyles.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import grinnell.appdev.edu.lyles.Model.Event;
import grinnell.appdev.edu.lyles.R;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    List<Event> events;

    public EventsAdapter(List<Event> events, Context context) {
        this.events = events;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;

        public EventViewHolder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_row, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(v);
        System.out.println(viewHolder.getItemId());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventsAdapter.EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.text.setText(event.getTitle());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

}