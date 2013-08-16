package com.fireball.teampicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Sample message.
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	public final static String EXTRA_NUMBER_OF_TEAMS = "com.example.myfirstapp.NUMBER_OF_TEAMS";
	public final static String EXTRA_NUMBER_OF_PLAYERS = "com.example.myfirstapp.NUMBER_OF_PLAYERS";
	public final static String EXTRA_PLAYER_NAMES = "com.example.myfirstapp.PLAYER_NAMES";

	public final static String MIN_TEAMS = "2";
	public final static String MIN_PLAYERS = "2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// get reference to GUI image button
		configureGoButton();
	}

	private void configureGoButton() {
		ImageButton goButton = (ImageButton) findViewById(R.id.submitImageButton);
		goButton.setOnTouchListener(new ButtonHighlighterOnTouchListener(goButton));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * This method is setup to be called from the activity_main.xml to be fired
	 * when the submit button is clicked.
	 * 
	 * @param view
	 *            is the view you must pass in (the current view).
	 */
	public void submitInfo(View view) {

		// Make intent to transfer data to the next activity.
		Intent intent = new Intent(this, TeamDisplayActivity.class);

		// give teams and players default initial values
		String teamOfTeams = MIN_TEAMS;
		String amountOfPlayers = MIN_PLAYERS;

		// Grab the data out of the edittext field when the user press submit

		// 1. Get access to the edittext field.
		// EditText editText = (EditText) findViewById(R.id.edit_message);
		EditText teamText = (EditText) findViewById(R.id.amount_of_teams);
		EditText playerText = (EditText) findViewById(R.id.amount_of_players);

		// 2. Grab the data from that edittext field and store in a String (for
		// this scenario)
		// Ultimately you should have some error handling here to check for a
		// valid response from user.
		// String message = editText.getText().toString();
		if (teamText.getText().length() != 0) {
			teamOfTeams = "" + teamText.getText();
		}
		if (playerText.getText().length() != 0) {
			amountOfPlayers = "" + playerText.getText();
		}

		int numTeams = Integer.parseInt(teamOfTeams);
		int numPlayers = Integer.parseInt(amountOfPlayers);

		if (numPlayers < numTeams) {
			numPlayers = numTeams;
			Toast.makeText(getApplicationContext(), "You need at least as many players as teams!  (added players)",
					Toast.LENGTH_SHORT).show();
		} else {

			// 3. Once we have the data, add it into the intent as a dictionary
			// to
			// pass onto the next Activity (view).
			// intent.putExtra(EXTRA_MESSAGE, message);
			intent.putExtra(EXTRA_NUMBER_OF_TEAMS, numTeams);
			intent.putExtra(EXTRA_NUMBER_OF_PLAYERS, numPlayers);

			// 4. Start the next activity with your intent and dictionary!
			startActivity(intent);
		}
	}

}
