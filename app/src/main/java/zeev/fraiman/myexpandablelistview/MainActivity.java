package zeev.fraiman.myexpandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Context context;
    HashMap<String, ArrayList<String>> countryCityMap;
    ArrayList<String> countries_list, citiesInUSA, citiesInUK, citiesInPoland;
    ExpandableListView elvCountryCity;
    CountryCityListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        elvCountryCity.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(context, ""+countries_list.get(groupPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        elvCountryCity.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(context,
                        ""+countryCityMap.get(countries_list.get(groupPosition)).get(childPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initElements() {
        context=this;
        elvCountryCity = (ExpandableListView) findViewById(R.id.elvCountryCity);
        if (elvCountryCity!=null) {
            adapter = new CountryCityListAdapter(this, countryCityMap);
            elvCountryCity.setAdapter(adapter);
        }
        else
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        countries_list=new ArrayList<>();
        countries_list.add("USA");
        countries_list.add("Great Britain");
        countries_list.add("Poland");

        countryCityMap = new HashMap<>();

        citiesInUSA = new ArrayList<>();
        citiesInUSA.add("New York");
        citiesInUSA.add("Los Angeles");
        citiesInUSA.add("Chicago");
        citiesInUSA.add("Washington");
        countryCityMap.put(countries_list.get(0), citiesInUSA);

        citiesInUK = new ArrayList<>();
        citiesInUK.add("London");
        citiesInUK.add("Manchester");
        citiesInUK.add("Birmingham");
        countryCityMap.put(countries_list.get(1), citiesInUK);

        citiesInPoland = new ArrayList<>();
        citiesInPoland.add("Warszaw");
        citiesInPoland.add("Krakow");
        citiesInPoland.add("Lodz");
        citiesInPoland.add("Gdansk");
        citiesInPoland.add("Lublin");
        citiesInPoland.add("Wroclaw");
        countryCityMap.put(countries_list.get(2), citiesInPoland);

        initElements();
    }
}