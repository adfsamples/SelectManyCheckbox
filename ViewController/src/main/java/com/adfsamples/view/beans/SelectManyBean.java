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

    private static final List<SelectItem> selectItems;
    static {
        selectItems = new ArrayList<SelectItem>();
        for (Weekday weekday : Weekday.values()) {
            selectItems.add(new SelectItem(weekday, weekday.toString()));
        }
    }

    // initialize the value to an array of Weekday
    private Object value = new Weekday[] { Weekday.Sunday, Weekday.Saturday };

    // output message
    private String output = "";

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getOutput() {
        return output;
    }

    public void actionListener(ActionEvent actionEvent) {
        System.out.println("value: " + (value == null ? "null" : value.getClass().getName()));

        // The value attribute of the selectManyCheckbox, like any other selectMany component,
        // must be a List or an Array.
        if (value == null) {
            output += "no item selected.\n";
        } else if (value instanceof List) {
            List list = (List) value;
            output += list.size() + " item(s) selected: " + Arrays.toString(list.toArray()) + "\n";
        } else if (value.getClass().isArray()) {
            Object[] arr = (Object[]) value;
            output += arr.length + " item(s) selected: " + Arrays.toString(arr) + "\n";
        }
    }
}
