package com.strong.java2struct;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;


public class MainActivity extends AppCompatActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.button1:
			String datastr = "I am a student!";
			byte[] data = datastr.getBytes();
			Student student1 = new Student(1234, "PXW", data);
			System.out.println("Student info: " + student1.toString());
			JNIUtils.passJava2Native(student1);
			break;
		case R.id.button2:
			Student student2 = null;
			student2 = JNIUtils.getJavaFromNative();
			System.out.println("Student2 info: " + student2.toString());
			break;

		default:
			break;
		}

	}
}
