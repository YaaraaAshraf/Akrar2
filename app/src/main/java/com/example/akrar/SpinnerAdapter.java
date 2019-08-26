package com.example.akrar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class SpinnerAdapter<T> extends ArrayAdapter<T> {
    enum ViewType {
        HEADER(0),
        ITEM(1);
        int value;

        ViewType(int value) {
            this.value = value;
        }
    }

    protected List<T> mData;
    private int mResource;
    protected String defaultValueTitle;
//    protected String  locale;

    public SpinnerAdapter(Context context, int resource, List data, String defaultValueTitle) {
        super(context, resource, data);
        this.mData = data;
        this.mResource = resource;
        this.defaultValueTitle = defaultValueTitle;
    }

    public SpinnerAdapter(Context context, int resource, String defaultValueTitle) {
        this(context, resource,new ArrayList(),defaultValueTitle);

    }

    public void setData(List<T> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return this.mData;
    }


    @Override
    public int getCount() {
        // +1 for default value
        return this.mData.size() ;
    }

    @Override
    public int getItemViewType(int position) {
        return ViewType.ITEM.value;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(mResource, parent, false);

        TextView itemTextView = convertView.findViewById(R.id.textspinner);
        itemTextView.setText(getItemViewType(position) == ViewType.HEADER.value ? defaultValueTitle : getTitle(position));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);


    }

    protected abstract String getTitle(int position);

    @Nullable
    @Override
    public T getItem(int position) {
//        if (position == 0)
//            return null;

        return mData.get(position);
    }
}
