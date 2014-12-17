package com.adfsamples.view.beans;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

public class SelectManyBean implements Serializable {

    public enum Weekday {
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }

    public enum Sport {
        Jogging,
        Running,
        Tennis,
    }

    private static final List<SelectItem> daysSelectItems;
    static {
        daysSelectItems = new ArrayList<SelectItem>();
        for (Weekday weekday : Weekday.values()) {
            daysSelectItems.add(new SelectItem(weekday, weekday.toString()));
        }
    }

    private static final SelectItem[] sportsSelectItems;
    static {
        sportsSelectItems = new SelectItem[3];
        sportsSelectItems[0] = new SelectItem(Sport.Jogging, Sport.Jogging.toString());
        sportsSelectItems[1] = new SelectItem(Sport.Running, Sport.Running.toString());
        sportsSelectItems[2] = new SelectItem(Sport.Tennis, Sport.Tennis.toString());
    }
    // output message
    private String output = "";

    // initialize the value to an array of Weekday
    private Weekday[] days = new Weekday[] { Weekday.Sunday, Weekday.Saturday };
    private Object sports;


    public List<SelectItem> getDaysSelectItems() {
        return daysSelectItems;
    }

    public SelectItem[] getSportsSelectItems() {
        return sportsSelectItems;
    }

    public void setDays(Weekday[] value) {
        this.days = value;
    }

    public Weekday[] getDays() {
        return days;
    }

    public void setSports(Object sports) {
        this.sports = sports;
    }

    public Object getSports() {
        return sports;
    }

    public String getOutput() {
        return output;
    }

    public void actionListener(ActionEvent actionEvent) {
        System.out.println(">>> days: " + (days == null ? "null" : days.getClass().getName()));
        System.out.println(">>> sports: " + (sports == null ? "null" : sports.getClass().getName()));

        // The value attribute of the selectManyCheckbox, like any other selectMany component,
        // must be a List or an Array.
        if (days == null) {
            output += "days: no item selected.\n";
        } else {
            Object[] arr = (Object[]) days;
            output += "days: " + arr.length + " item(s) selected: " + Arrays.toString(arr) + "\n";
        }

        if (sports == null) {
            output += "sports: no item selected.\n";
        } else if (sports instanceof List) {
            List list = (List) sports;
            output += "sports: " + list.size() + " item(s) selected: " + Arrays.toString(list.toArray()) + "\n";
        } else if (sports.getClass().isArray()) {
            Object[] arr = (Object[]) sports;
            output += "sports: " + arr.length + " item(s) selected: " + Arrays.toString(arr) + "\n";
        }
        
        output += "\n";
    }
}
