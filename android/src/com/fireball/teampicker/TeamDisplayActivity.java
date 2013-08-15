package com.fireball.teampicker;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

@SuppressWarnings("unused")
public class TeamDisplayActivity extends Activity {

	private String[] playerNames;
	private int numberOfTeams;
	private int numberOfPlayers;
	private static final String TAG = "TeamDisplayActivity";

	/**
	 * Remember the onCreate is where you start when the new activity gets
	 * initialized. You must add setContentView() here to set up the view. Also
	 * grab the intent's data from previous view.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Show the Up button in the action bar.
		setupActionBar();

		// Set up intent to get the data from last activity.
		Intent intent = getIntent();

		// Check default numbers for numberOfTeams/Players and make sure we set
		// them correctly.
		numberOfTeams = intent.getIntExtra(MainActivity.EXTRA_NUMBER_OF_TEAMS,
				2);
		numberOfPlayers = intent.getIntExtra(
				MainActivity.EXTRA_NUMBER_OF_PLAYERS, 4);

		String[] teamNames = new String[numberOfTeams];
		for (int teamIndex = 0; teamIndex < numberOfTeams; teamIndex++) {
			teamNames[teamIndex] = "Team " + (teamIndex + 1);
		}

		ArrayList<Player> players = this.createPlayerList(numberOfPlayers);

		// Randomize it
		Team[] teams = TeamCalculator.Randomize(teamNames, players);

		// Spit out the last activity's data.
		this.printTeams(teams, this);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Generates a list of players for a single team
	 * 
	 * @return playerList - list of all players
	 */
	public ArrayList<Player> createPlayerList(int numPlayers) {
		ArrayList<Player> playerList = new ArrayList<Player>();
		Player tempPlayer;
		for (int playerIndex = 0; playerIndex < numPlayers; playerIndex++) {
			tempPlayer = new Player("Player " + (playerIndex + 1), playerIndex);
			playerList.add(tempPlayer);
		}

		return playerList;
	}

	/**
	 * Prints out the team to a string that is displayed in a textView to the
	 * user.
	 * 
	 * @param teams
	 *            - Array of teams from Randomize function.
	 * @param ctx
	 *            - Current Context needed for setting text to textView.
	 */
	private void printTeams(Team[] teams, Context ctx) {
		String message = "";
		for (int i = 0; i < teams.length; i++) {
			message += teams[i].getName();
			message += "\n\n";
			ArrayList<Player> Players = teams[i].getPlayers();
			Log.d(TAG,
					"players for " + teams[i].getName() + " : "
							+ Players.toString());
			for (int j = 0; j < Players.size(); j++) {
				message += Players.get(j).getName();
				message += "\n";
			}
			message += "\n";
		}

		int teamIndex = 0, playerIndex = 0;
		LayoutInflater inflater = getLayoutInflater();

		// get the scroll view from the activity XML
		ScrollView sv = (ScrollView) inflater.inflate(
				R.layout.activity_team_display, null);

		// get the table from inside the scroll view
		TableLayout table = (TableLayout) sv.findViewById(R.id.Team_Table_View);

		// iterate through all teams and players and generate the table
		for (Team aTeam : teams) {
			TableRow teamRow = (TableRow) inflater.inflate(
					R.layout.attrib_team_row, null);

			TextView teamTV = (TextView) teamRow.findViewById(R.id.team_name);

			teamTV.setText(aTeam.getName());
			table.addView(teamRow);

			for (Player aPlayer : aTeam.getPlayers()) {
				TableRow playerRow = (TableRow) inflater.inflate(
						R.layout.attrib_player_row, null);

				TextView playerTV = (TextView) playerRow
						.findViewById(R.id.player_name);

				playerTV.setText('\t' + aPlayer.getName());
				table.addView(playerRow);
			}
		}

		setContentView(sv);
	}

}
