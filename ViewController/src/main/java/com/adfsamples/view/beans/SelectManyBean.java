package com.adfsamples.view.beans;

import java.io.Serializable;

import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.Collection;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class SelectManyBean {

    private static final SelectItem[] selectItems;
    static {
        selectItems = new SelectItem[7];
        selectItems[0] = new SelectItem("Sunday");
        selectItems[1] = new SelectItem("Monday");
        selectItems[2] = new SelectItem("Tuesday");
        selectItems[3] = new SelectItem("Wednesday");
        selectItems[4] = new SelectItem("Thursday");
        selectItems[5] = new SelectItem("Friday");
        selectItems[6] = new SelectItem("Saturday");
    }

    private Object value;
    private String output = "";

    public SelectItem[] getSelectItems() {
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
