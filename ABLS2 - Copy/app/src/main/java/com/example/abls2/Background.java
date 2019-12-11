//calls to api- login(email, pw), getTeams(PlayerNum), getMatches(playerNum, date), getRoster(divisionID, date), getPlayerList(teamID)

package com.example.abls2;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class Background extends AsyncTask<String, String, String> {

    Context context;
    Background(Context ctx){
        this.context = ctx;
    }
    @Override
    protected String doInBackground(String... strings) {

        //connecting and loading and getting basic information for a player.
        String type = strings[0];
        String stringA = strings [1];
        String stringB = strings[2];
        String loginURL = "https://amateurbilliardsleague.com/wp-content/themes/amazica-business/api/api.php";


        //Call to login: requires type:nameLogin, stringA = email, stringB = password
        if(type.equals("nameLogin")) {
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                    //function to php
                   String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("login", "UTF-8") + "&" +
                           URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(stringA, "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(stringB, "UTF-8");

                   //API function testing (with breaks)
                   // String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getMatches", "UTF-8") + "&" +
                     //       URLEncoder.encode("playerNum", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")+ "&" +
                       //          URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode("2019-09-14", "UTF-8");

                    //String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getMatches", "UTF-8") + "&" +
                      //    URLEncoder.encode("playerNum", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8") + "&" +
                        // URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode("2019-09-14", "UTF-8");

                   // String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getRoster", "UTF-8") + "&" +
                       //     URLEncoder.encode("divisionID", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");

                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    if ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString().trim();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    //parsing string
                    String prefix = "Session StartLogin Successful";
                    String noPrefixResult = result.substring(result.indexOf(prefix) + prefix.length());

                    return noPrefixResult;


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }



         //calls team functions requires only the player number
        }else if(type.equals("team")){
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    //function call
                    String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getTeams", "UTF-8") + "&" +
                            URLEncoder.encode("playerNum", "UTF-8") + "=" + URLEncoder.encode(stringA, "UTF-8");

                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    if ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString().trim();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();


                    return result;


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


         //gets matches requires player num and date
        }else if(type.equals("match")){
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    //function call
                    String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getMatches", "UTF-8") + "&" +
                          URLEncoder.encode("playerNum", "UTF-8") + "=" + URLEncoder.encode(stringA, "UTF-8") + "&" +
                        URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode("2019-11-19", "UTF-8");//stringB, "UTF-8");

                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    if ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString().trim();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();


                    //to correct the string so that the Gson will except it... take out all the extra '[' and ']', and replace with ','
                    result = result.replaceAll("\\[", ",");
                    result = result.replaceAll("\\]", ",");

                    result = result.substring(1);//had to add this to remove the first comma... can leave the last comma
                    result = "[" + result + "]";//had to bracket all the data so Gson would accept it.
                    if(result == "[br />]"){
                        result = "";
                    }


                    return "[{\"HomeTeam\":1,\"AwayTeam\":2},{\"HomeTeam\":3,\"AwayTeam\":4},{\"HomeTeam\":5,\"AwayTeam\":6},{\"HomeTeam\":8,\"AwayTeam\":7},{\"HomeTeam\":2,\"AwayTeam\":11},{\"HomeTeam\":3,\"AwayTeam\":13},{\"HomeTeam\":4,\"AwayTeam\":17},{\"HomeTeam\":3,\"AwayTeam\":16},{\"HomeTeam\":2,\"AwayTeam\":18},{\"HomeTeam\":2,\"AwayTeam\":19},{\"HomeTeam\":3,\"AwayTeam\":20},{\"HomeTeam\":4,\"AwayTeam\":21}]";


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        //calls roster requires only the division ID returns a list of a all rosters for that division
        }else if(type.equals("roster")){
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    //function call
                    String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getRoster", "UTF-8") + "&" +
                            URLEncoder.encode("divisionID", "UTF-8") + "=" + URLEncoder.encode(stringA, "UTF-8");// + "&" +
                           // URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(stringB, "UTF-8");

                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    if ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString().trim();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    result = result.replaceAll("\\}", "},");
                    result = "[" + result + "]";

                    return result;


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if(type.equals("playerList")){
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                    String insert_data = URLEncoder.encode("func", "UTF-8") + "=" + URLEncoder.encode("getPlayerList", "UTF-8") + "&" +
                            URLEncoder.encode("teamID", "UTF-8") + "=" + URLEncoder.encode(stringA, "UTF-8");// + "&" +

                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    if ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString().trim();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return result;


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s){

    }



}

