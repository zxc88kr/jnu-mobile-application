package com.example.project03.adapter;

import static com.example.project03.MainActivity.cartRepositoryObj;
import static com.example.project03.CartActivity.cartUpdate;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project03.R;
import com.example.project03.model.Book;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;

    public CartAdapter(Context context) {
        this.context = context;
    }

    private CartAdapter.OnSelectChangedListener selectChangedListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book item = cartRepositoryObj.cartBooks.get(position);

        switch (item.id) {
            case "BOOK1234":
                holder.itemImage.setImageResource(R.drawable.book11);
                break;
            case "BOOK1235":
                holder.itemImage.setImageResource(R.drawable.book21);
                break;
            case "BOOK1236":
                holder.itemImage.setImageResource(R.drawable.book31);
                break;
            case "BOOK1237":
                holder.itemImage.setImageResource(R.drawable.book41);
                break;
        }

        holder.itemTitle.setText(item.name);
        holder.itemPrice.setText(Integer.toString(item.price));
        holder.itemCheckBox.setChecked(item.isChecked);
        holder.itemQuantity.setText(Integer.toString(item.quantity));
        holder.itemSum.setText(Integer.toString(item.price * item.quantity));

        holder.itemCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.isChecked = holder.itemCheckBox.isChecked();
                selectChangedListener.onSelectChanged(cartRepositoryObj.cartBooks);
            }
        });

        holder.itemDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("도서 상품 삭제");
                alertDialog.setMessage("선택한 도서 상품을 삭제하겠습니까?");
                alertDialog.setIcon(R.drawable.dialog_cat);

                alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Book item = cartRepositoryObj.cartBooks.get(holder.getAdapterPosition());
                        cartRepositoryObj.cartBooks.remove(item);
                        notifyItemRemoved(holder.getAdapterPosition());
                        cartUpdate();
                        dialog.dismiss();
                    }
                });
                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartRepositoryObj.cartBooks.size();
    }

    public interface OnSelectChangedListener {
        void onSelectChanged(ArrayList<Book> item);
    }

    public void setOnSelectChangedListener(OnSelectChangedListener listener) {
        selectChangedListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle, itemPrice, itemQuantity, itemSum;

        CheckBox itemCheckBox;
        ImageButton itemDeleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImage);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemSum = itemView.findViewById(R.id.itemSum);

            itemCheckBox = itemView.findViewById(R.id.itemCheckBox);
            itemDeleteBtn = itemView.findViewById(R.id.itemDeleteBtn);
        }
    }
}