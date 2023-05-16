package com.powerpuff.librav2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.util.ArrayList;



public class PDFactivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);

        PDFView pdf = findViewById(R.id.pdfView);
        Intent intent = getIntent();
        String book_path = intent.getStringExtra("path");

        pdf.fromAsset(book_path).load();
    }
}
