package com.example.time3.DBASE;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parser extends AsyncTask<Void,Integer,Integer> {

    @SuppressLint("StaticFieldLeak")
    Context c;
    @SuppressLint("StaticFieldLeak")
    ListView lv;
    String data;

    ProgressDialog pd;

    ArrayList<Subject> players=new ArrayList<>();

    public Parser(Context c, ListView lv, String data) {
        this.c = c;
        this.lv = lv;
        this.data = data;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Fetching");
        pd.setMessage("Parsing...Pls Wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if (integer == 1){

            lv.setAdapter(new ItemAdapter(c,players));

            //    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //        @Override
            //        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //            // Snackbar.make(view,players.get(position),Snackbar.LENGTH_SHORT).show();
            //        }
            //    });

        }
        else {
            Toast.makeText(c,"Unable to download",Toast.LENGTH_SHORT).show();
        }

        pd.dismiss();

    }

    private int parse(){
        try {
            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            players.clear();
            Subject subject;

            for (int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);

                String time = jo.getString("Time");
                String code = jo.getString("Code");
                String module = jo.getString("Module");
                String staff = jo.getString("Staff");

                subject=new Subject();
                subject.setTime(time);
                subject.setCode(code);
                subject.setModule(module);
                subject.setStaff(staff);

                players.add(subject);

            }
            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
