package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private int  resourceId;
    public ContactAdapter (Context context, int textViewResourceId, List<Contact> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView contactName = (TextView) view.findViewById(R.id.contact_name);
        TextView contactPhone = (TextView) view.findViewById(R.id.contact_phone);
        contactName.setText(contact.getName());
        contactPhone.setText(contact.getPhone());
        return view;

    }
}
