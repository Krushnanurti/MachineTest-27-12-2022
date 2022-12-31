package com.example.mahadev;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

public class CustomDialogForColorPicker extends Dialog {
    String [] colors;
    ArrayAdapter<String> arrayAdapter;
    ListView view;

    public CustomDialogForColorPicker(@NonNull Context context, int themeResId, String[] colors) {
        super(context, themeResId);
        this.colors = colors;
    }

    public void initViews()
    {
        view=findViewById(R.id.ListViewId);
    }

}
