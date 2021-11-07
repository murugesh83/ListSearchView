package com.paak.sidenavigationapp.ui.gallery;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.Lifecycle;

import com.paak.sidenavigationapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SearchListFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{


    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> mylist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        setHasOptionsMenu(true);
        // initialise ListView with id
        listView = view.findViewById(R.id.listView);

        // Add items to Array List
        mylist = new ArrayList<>();
        mylist.add("Phyton");
        mylist.add("C++");
        mylist.add("C#");
        mylist.add("Java");
        mylist.add("Advanced java");
        mylist.add("Interview prep with c++");
        mylist.add("Interview prep with java");
        mylist.add("data structures with c");
        mylist.add("data structures with java");

        // Set adapter to ListView
        adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                mylist);
        listView.setAdapter(adapter);

        return view;
    }


     @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       //  MenuInflater inflater1 = getMenuInflater();
         inflater.inflate(R.menu.main, menu);
         MenuItem searchList = menu.findItem(R.id.search_bar);
         //SearchManager searchManager = (SearchManager) getContext().getSystemService(getContext().SEARCH_SERVICE);
         SearchView searchView = (SearchView) searchList.getActionView();
         searchView.setOnQueryTextListener(this);
         searchView.setQueryHint("Search");
          super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // If the list contains the search query
        // than filter the adapter
        // using the filter method
        // with the query as its argument
       /* if (mylist.contains(query)) {
            adapter.getFilter().filter(query);
        }
        else {
            // Search query not found in List View
            Toast.makeText(getActivity(),
                    "Not found",
                    Toast.LENGTH_LONG)
                    .show();
        }*/
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        // If the list contains the search query
        // than filter the adapter
        // using the filter method
        // with the query as its argument
        if (mylist.contains(newText)) {
            adapter.getFilter().filter(newText);
        }
        else {
            // Search query not found in List View
            Toast.makeText(getActivity(),
                    "Not found",
                    Toast.LENGTH_LONG)
                    .show();
        }
        adapter.getFilter().filter(newText);
        return false;
    }
}