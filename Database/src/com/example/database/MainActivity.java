package com.example.database;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
	private MySQLiteHelper mySQLiteHelper;

	private EditText title, author;
	private TextView bookname;
	private Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mySQLiteHelper = new MySQLiteHelper(this);
		
		title = (EditText) findViewById(R.id.title);
		author = (EditText) findViewById(R.id.author);
		bookname = (TextView) findViewById(R.id.bookname);
		submit = (Button) findViewById(R.id.submit);
		
		submit.setOnClickListener( this );
		
		List<Book> books = mySQLiteHelper.getAllBooks();
		if( books != null )
		{
			bookname.setText("Title: " + books.get(0).getTitle() + ", Author: " + books.get(0).getAuthor());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.submit:
			{
				String title = (this.title.getText() == null ? null : this.title.getText().toString()) ;
				String author = (this.author.getText() == null ? null : this.author.getText().toString());
				
				//bookname.setText("Title: " + title + ", Author: " + author);
				
				mySQLiteHelper.addBook(new Book(title, author));
			}
			break;
		}
	}
}
