package net.dulatello08.medorg;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectToServer extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... args) {

        try {
            connect();
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String file_url)
    {

    }
}

public void connect(){
        Log.e("Android", "SQL Connection start");

        Connection conn = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String ip = "185.27.70.206";
            String dbName = "medorg";
            String user = "dulat";
            String password = "dulat";

            String connString = "jdbc:mysql://" + ip + "/" + dbName +
                    "";

            conn = DriverManager.getConnection(connString, user, password);

            Log.e("Connection", "Open");
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery("Select * from [table]");
            statement.setQueryTimeout(0);

            while(set.next())
            {
                Log.e("Data:", set.getString("[column_name]"));
            }
        }catch(Exception e)
        {
            Log.e("Error connection", e.toString());
        }

}//end method