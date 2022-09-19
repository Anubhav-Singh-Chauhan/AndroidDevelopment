package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>
{
    Context context;
    ArrayList <ContactModel> arrContacts;

    RecyclerContactAdapter(Context context, ArrayList <ContactModel> arrContacts)
    {
        this.context = context;
        this.arrContacts = arrContacts;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtname.setText(arrContacts.get(position).name);
        holder.txtnumber.setText(arrContacts.get(position).number);
    }

    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
      TextView txtname,txtnumber;
      ImageView imgContact;
        public ViewHolder(View a) {
            super(a);
            txtname = itemView.findViewById(R.id.txtName);
            txtnumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.ContactImg);
        }
    }
}
