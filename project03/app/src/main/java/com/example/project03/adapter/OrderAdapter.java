package com.example.project03.adapter;

import static com.example.project03.MainActivity.cartRepositoryObj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project03.R;
import com.example.project03.model.Book;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    Context context;

    public OrderAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book item = cartRepositoryObj.cartBooks.get(position);
        String id;

        if (item.name.length() > 20) {
            id = item.name.substring(20) + "...";
        } else {
            id = item.name;
        }

        holder.orderTitle.setText(id);
        holder.orderPrice.setText(Integer.toString(item.price));
        holder.orderQuantity.setText(Integer.toString(item.quantity));
        holder.orderSum.setText(Integer.toString(item.price * item.quantity));
    }

    @Override
    public int getItemCount() {
        return cartRepositoryObj.cartBooks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderTitle, orderPrice, orderQuantity, orderSum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderTitle = itemView.findViewById(R.id.orderTitle);
            orderPrice = itemView.findViewById(R.id.orderPrice);
            orderQuantity = itemView.findViewById(R.id.orderQuantity);
            orderSum = itemView.findViewById(R.id.orderSum);
        }
    }
}