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

		// TODO: will need later once player names are in.
		// playerNames =
		// intent.getStringArrayExtra(MainActivity.EXTRA_PLAYER_NAMES);
		// Player[] players =
		// this.makePlayerObjectFromStringOfNames(playerNames);

		// TODO: hardcoded team names until added to MainActivity.
		String[] teamNames = { "Team1", "Team2" };

		// TODO: hardcoded players until added to MainActivity.
		ArrayList<Player> players = this.makePlayerObject();

		// Randomize it.
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

	// TODO: hardcoded number of players.
	// Left this method because I may use it again in the future.
	public Player[] makePlayerObjectFromStringOfNames(String[] names) {
		Player[] players = new Player[4];

		for (int i = 0; i < 4; i++) {
			players[i] = new Player(names[i], i);
		}

		return players;
	}

	/**
	 * This is hard-coded until the MainActivity View takes Players names.
	 * 
	 * @return playerList - list of all players
	 */
	public ArrayList<Player> makePlayerObject() {
		Player tom = new Player("Tom", 1);
		Player patty = new Player("Patty", 1);
		Player john = new Player("John", 2);
		Player ian = new Player("Ian", 3);

		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(patty);
		playerList.add(john);
		playerList.add(ian);
		playerList.add(tom);

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
		Log.d(TAG, "teams: " + teams.toString());
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

		/* For GUI testing only. TODO: remove */
		ArrayList<Team> teamList = new ArrayList<Team>();

		int teamIndex = 0, playerIndex = 0;

		Team tempTeam = new Team("Team 1", teamIndex++);
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		teamList.add(tempTeam);

		tempTeam = new Team("Team 2", teamIndex++);
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		teamList.add(tempTeam);

		tempTeam = new Team("Team 3", teamIndex++);
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		teamList.add(tempTeam);

		tempTeam = new Team("Team 4", teamIndex++);
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		teamList.add(tempTeam);

		tempTeam = new Team("Team 5", teamIndex++);
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		tempTeam.addPlayer(new Player("Player" + playerIndex++));
		teamList.add(tempTeam);
		/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */

		LayoutInflater inflater = getLayoutInflater();

		//get the scroll view from the activity XML
		ScrollView sv = (ScrollView) inflater.inflate(
				R.layout.activity_team_display, null);

		//get the table from inside the scroll view
		TableLayout table = (TableLayout) sv.findViewById(R.id.Team_Table_View);

		//iterate through all teams and players and generate the table
		for (Team aTeam : teamList) {
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
