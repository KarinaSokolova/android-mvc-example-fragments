package fr.utt.socialize.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import fr.utt.socialize.R;

public class GroupsListController extends Fragment implements OnItemClickListener
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.list, container, false);
		return view;
	}
	

	public void getGroups()
	{
		//Get data list from the Data Access Objects
		String[] items = this.getActivity().getResources().getStringArray(R.array.groups_list);
		
		if(this.getActivity() == null)
		{
			return;
		}
		
		//Populate the list with data
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity().getApplicationContext(), R.layout.simple_row, items);      
        ((ListView) this.getView().findViewById(R.id.list)).setAdapter(adapter);
		
		//Set the event listener
		((ListView) this.getView().findViewById(R.id.list)).setOnItemClickListener(this);
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		//Do smth		
		Toast.makeText(this.getActivity().getApplicationContext(), "Nice group click on " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
	}
}