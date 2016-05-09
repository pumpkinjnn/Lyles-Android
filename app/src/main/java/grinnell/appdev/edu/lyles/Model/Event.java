package grinnell.appdev.edu.lyles.Model;

import java.util.Date;

public class Event {
        private String id;
        private String title;
        private Date startTime;
        private Date endTime;
        private String[] hosts;
        private String description;

    public Event(String id, String title, Date startTime, Date endTime, String description, String[] hosts) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.hosts = hosts;

    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String[] getHosts() {
        return hosts;
    }

    public String getDescription() {
        return description;
    }

}