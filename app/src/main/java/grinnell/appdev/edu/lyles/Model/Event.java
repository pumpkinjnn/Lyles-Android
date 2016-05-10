package grinnell.appdev.edu.lyles.Model;

import java.util.Date;

public class Event {
        private String title;
        private Date startTime;
        private Date endTime;
        private String description;
        private int tab;

    public Event(String title, Date startTime, Date endTime, String description, int tab) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.tab = tab;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public int getTab() {
        return tab;
    }
}