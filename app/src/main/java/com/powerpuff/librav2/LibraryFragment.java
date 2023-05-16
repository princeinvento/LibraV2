package com.powerpuff.librav2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class LibraryFragment extends Fragment {

    ArrayList<Books> book;
    ArrayList<BooksLastRead> books;
    Context context;
    RecyclerView recycler;

    public LibraryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        context = container.getContext();
        recycler = view.findViewById(R.id.recycler_lib);
        createListsmall();
        buildRecyclersmall(view);



        return view;
    }

    public void createListbig(){
        book = new ArrayList<>();
        book.add(new Books("Fantasy","A young girl named Alice wanders into wonder land a Place of magic","Alice's Adventures in Wonder Land","https://media1.popsugar-assets.com/files/thumbor/U0XLaxoZ5O74EC08J-GyWYAztXo/fit-in/728xorig/filters:format_auto-!!-:strip_icc-!!-/2016/07/01/927/n/3019466/892014696a0dca0b_9781447279990Alice-s_Adventures_in_Wonderland/i/Alice-Adventures-Wonderland-Lewis-Carroll.jpg","alice.pdf"));
        book.add(new Books("Science","Cell Biology delivers comprehensive\n" +
                "clearly written, and richly...","Molecular Cell Biology","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1315623087l/781645.jpg","mcb.pdf"));
        book.add(new Books("Technology","Design and Build Websites with the\n" +
                "Power of HTML and CSS","HTML & CSS","https://th.bing.com/th/id/R.3ce6089db71fc309e0b093a9613070a1?rik=pdXZ0bpEHVsDZg&riu=http%3a%2f%2fbilder.buecher.de%2fprodukte%2f37%2f37344%2f37344139z.jpg&ehk=b1Jsp6EiAmGAwmW%2bh9syzqZFKyEv7hG3noj8mNI1U7Q%3d&risl=&pid=ImgRaw&r=0","htmlandcss.pdf"));
        book.add(new Books("Math","The analysis of time series applies to many fields.","Introduction To Statistical Time Series","https://cv01.studmed.ru/be275ccf858/72f69d7.jpg","introtimeseries.pdf"));
    }

    public void buildRecyclerbig(View view){
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        recycler.setAdapter(new BookAdapter(context,book));

    }

    private void createListsmall(){
        books = new ArrayList<>();
        books.add(new BooksLastRead("Alice's Adventures in Wonder Land","Fantasy","https://media1.popsugar-assets.com/files/thumbor/U0XLaxoZ5O74EC08J-GyWYAztXo/fit-in/728xorig/filters:format_auto-!!-:strip_icc-!!-/2016/07/01/927/n/3019466/892014696a0dca0b_9781447279990Alice-s_Adventures_in_Wonderland/i/Alice-Adventures-Wonderland-Lewis-Carroll.jpg","alice.pdf"));
        books.add(new BooksLastRead("Python Programming","Technology","https://th.bing.com/th/id/OIP.JXjuklYZy7LPt_wYRR0sLgHaKc?pid=ImgDet&rs=1","pp.pdf"));
        books.add(new BooksLastRead("Javascript & JQuery:The Missing Manual","Technology","https://th.bing.com/th/id/OIP.l0aFX6ZjvZH8yueu9FXOTwHaJ4?pid=ImgDet&rs=1","jj.pdf"));
        books.add(new BooksLastRead("Effective Modern C++","Technology","https://th.bing.com/th/id/OIP.nJ5DleT7XcWYx8zn2qGQdAHaJu?pid=ImgDet&rs=1","c==.pdf"));
        books.add(new BooksLastRead("Hacking:Beginner To Expert Guide","Technology","https://th.bing.com/th/id/R.7b39e76bc211cd0961ed98e94db7aad6?rik=HAY2m2Dt0mPsGA&riu=http%3a%2f%2fwww.payvand.com%2fnews%2f17%2ffeb%2fHacking-Beginner-to-Expert-Guide.jpg&ehk=3Tb8TXyDw8psZuqEslBnriTGL4rRsZBdQ3qr%2bk7O%2bAw%3d&risl=&pid=ImgRaw&r=0","hack.pdf"));
        books.add(new BooksLastRead("Introduction To Statistical Time Series","Math","https://cv01.studmed.ru/be275ccf858/72f69d7.jpg","introtimeseries.pdf"));
        books.add(new BooksLastRead("HTML & CSS","Technology","https://th.bing.com/th/id/R.3ce6089db71fc309e0b093a9613070a1?rik=pdXZ0bpEHVsDZg&riu=http%3a%2f%2fbilder.buecher.de%2fprodukte%2f37%2f37344%2f37344139z.jpg&ehk=b1Jsp6EiAmGAwmW%2bh9syzqZFKyEv7hG3noj8mNI1U7Q%3d&risl=&pid=ImgRaw&r=0","htmlandcss.pdf"));
        books.add(new BooksLastRead("Molecular Cell Biology","Science","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1315623087l/781645.jpg","mcb.pdf"));

    }

    private void buildRecyclersmall(View view){
        recycler.setLayoutManager(new GridLayoutManager(view.getContext(),3,RecyclerView.VERTICAL,false));
        recycler.setAdapter(new LastReadAdapter(context,books));
    }
}