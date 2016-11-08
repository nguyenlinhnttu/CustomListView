package com.android.lynkmieu.listviewnangcao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.lynkmieu.listviewnangcao.Adapter.BookAdapter;
import com.android.lynkmieu.listviewnangcao.Model.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhBa;
    ArrayList<Book> bookList;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addControls() {

        lvDanhBa = (ListView) findViewById(R.id.lvBookList);
        bookList = new ArrayList<>();
        /**
         * @param MainActivity.this
         * @param R.layout.item
         * @param bookList
         * */
        bookAdapter = new BookAdapter(MainActivity.this,R.layout.item,bookList);
        lvDanhBa.setAdapter(bookAdapter);
    }

    private void addEvent() {
        createData();
    }

    /** Add data to bookList*/
    public void createData() {
        Book book = new Book("Kỳ Án Ánh Trăng","Xác treo trong nhà gỗ","100.000");
        bookList.add(book);
        book = new Book("Tuyết Đoạt Hồn","Qủy Cổ Nữ","100.000");
        bookList.add(book);
        book = new Book("Tơ Đòng Rỏ Máu","Xác treo trong nhà gỗ","100.000");
        bookList.add(book);
        book = new Book("Hồ Tuyệt Mệnh","Qủy Cổ Nữ","100.000");
        bookList.add(book);
        book = new Book("Nỗi Đau Của Đom Đóm","Qủy Cổ Nữ","100.000");
        bookList.add(book);
        bookAdapter.notifyDataSetChanged();
    }
}
