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
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        Book book = cartRepositoryObj.cartBooks.get(position);

        switch (book.id) {
            case "BOOK1234":
                holder.bookImage.setImageResource(R.drawable.book11);
                break;
            case "BOOK1235":
                holder.bookImage.setImageResource(R.drawable.book21);
                break;
            case "BOOK1236":
                holder.bookImage.setImageResource(R.drawable.book31);
                break;
            case "BOOK1237":
                holder.bookImage.setImageResource(R.drawable.book41);
                break;
        }

        holder.bookTitle.setText(book.name);
        holder.bookPrice.setText(Integer.toString(book.price));
        holder.bookCheckBox.setChecked(book.isChecked);
        holder.bookQuantity.setText(Integer.toString(book.quantity));
        holder.bookSum.setText(Integer.toString(book.price * book.quantity));

        holder.bookCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book.isChecked = holder.bookCheckBox.isChecked();
                selectChangedListener.onSelectChanged(cartRepositoryObj.cartBooks);
            }
        });

        holder.bookDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("도서 상품 삭제");
                alertDialog.setMessage("선택한 도서 상품을 삭제하겠습니까?");
                alertDialog.setIcon(R.drawable.dialog_cat);

                alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Book book = cartRepositoryObj.cartBooks.get(which);
                        cartRepositoryObj.cartBooks.remove(book);

                        cartUpdate();
                        notifyItemRemoved(which);
                        notifyItemRangeChanged(which, cartRepositoryObj.cartBooks.size());
                        dialog.cancel();
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
        ImageView bookImage;
        TextView bookTitle, bookPrice, bookQuantity, bookSum;

        CheckBox bookCheckBox;
        ImageButton bookDeleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.bookImage);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookPrice = itemView.findViewById(R.id.bookPrice);
            bookQuantity = itemView.findViewById(R.id.bookQuantity);
            bookSum = itemView.findViewById(R.id.bookSum);

            bookCheckBox = itemView.findViewById(R.id.bookCheckBox);
            bookDeleteBtn = itemView.findViewById(R.id.bookDeleteBtn);
        }
    }
}