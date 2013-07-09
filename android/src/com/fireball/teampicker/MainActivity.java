package com.fireball.teampicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

	// Sample message.
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * This method is setup to be called from the activity_main.xml to be fired when
     * the submit button is clicked.
     * @param view is the view you must pass in (the current view).
     */
    public void submitInfo(View view) {
    	// Make intent to transfer data to the next activity.
    	Intent intent = new Intent(this, TeamDisplayActivity.class);
    	
    	// Grab the data out of the edittext field when the user press submit
    	
    	// 1. Get access to the edittext field.
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	
    	// 2. Grab the data from that edittext field and store in a String (for this scenario)
    	// Ultimately you should have some error handling here to check for a valid response from user.
    	String message = editText.getText().toString();
    	
    	// 3. Once we have the data, add it into the intent as a dictionary to pass onto the next Activity (view).
    	intent.putExtra(EXTRA_MESSAGE, message);
    	
    	// Start the next activity with your intent and dictionary!
    	startActivity(intent);
    }
    
}
