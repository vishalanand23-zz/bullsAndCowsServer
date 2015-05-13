package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import model.PlayResult;
 
public class QueryHandler {
    private static final String TABLE_NAME = "play_results";
    private static final String ID = "_id";
    private static final String DEVICE_ID = "device" + ID;
    private static final String NUM_OF_DIGITS = "num_of_digits";
    private static final String PLAYING_NUMBER = "playing_number";
    private static final String NUMBER_OF_GUESSES = "number_of_guesses";
    private static final String WIN_GAME = "win_game";
	private static final String TIME = "time";
    private static final String TIME_IN_MILLIS = "time_in_millis";
    
 
	public boolean insert(PlayResult result, Connection conn) {
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(" + DEVICE_ID + ", " + NUM_OF_DIGITS
					+ ", " + PLAYING_NUMBER + ", " + NUMBER_OF_GUESSES + ", " + WIN_GAME + ", " + TIME_IN_MILLIS
					+ ", " + TIME + ") VALUES(?,?,?,?,?,?,?);");
			statement.setString(1, result.getDeviceId());
			statement.setInt(2, result.getNumberOfDigits());
			statement.setString(3, result.getPlayingNumber());
			statement.setInt(4, result.getNumberOfGuesses());
			statement.setInt(5, result.getWinGame());
			statement.setInt(6, result.getTimeInMillis());
			statement.setTimestamp(7, new Timestamp(new Date().getTime()));
			statement.execute();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
