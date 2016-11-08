package com.android.lynkmieu.listviewnangcao.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.lynkmieu.listviewnangcao.Model.Book;
import com.android.lynkmieu.listviewnangcao.R;

import java.util.List;

/**
 * Created by LynkMieu on 7/6/2016.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    Activity context; //Màn hình sử dụng Layout này (G)
    int resource;     //Layout cho từng dòng muốn hiện thị (item)
    List<Book> objects; //Danh sách nguồn dữ liệu muốn hiển thị
    public BookAdapter(Activity context, int resource, List<Book> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtTitle = (TextView) row.findViewById(R.id.title);
        TextView txtAuthor = (TextView) row.findViewById(R.id.author);
        TextView txtPrice = (TextView) row.findViewById(R.id.price);
        ImageView btnLike = (ImageView) row.findViewById(R.id.btnLike);
        final Book book = this.objects.get(position);
        txtTitle.setText(book.getTitle());
        txtAuthor.setText(book.getAuthor());
        txtPrice.setText(book.getPrice());

        /**Set Event Onclick*/
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage(book);
            }
        });
        return row;
    }
    /** Show mesage*/
    private void showMessage(Book book) {
        Toast.makeText(this.context,book.toString(),Toast.LENGTH_LONG).show();
    }
}
