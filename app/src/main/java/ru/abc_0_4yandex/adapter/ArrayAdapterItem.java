package ru.abc_0_4yandex.adapter;

/**
 * Created by Миша on 14.10.2014.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// here's our beautiful adapter
public class ArrayAdapterItem extends ArrayAdapter<ObjectItem> {

    int layoutResourceId;
    public ArrayAdapterItem(Context mContext, int layoutResourceId, ObjectItem[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.mTextView = (TextView)convertView.findViewById(R.id.textViewItem);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();

        }
        holder.mTextView.setText(getItem(position).itemName);


        return convertView;

    }


    public static class ViewHolder {
        public TextView mTextView;
    }

}

