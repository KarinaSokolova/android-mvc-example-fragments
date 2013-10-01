package fr.utt.socialize.controller;
/**
 * Controlls main menu actions
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import fr.utt.socialize.R;
import fr.utt.socialize.activity.GroupsActivity;
import fr.utt.socialize.activity.GroupsActivity;
import fr.utt.socialize.activity.MainActivity;

public class MainMenuController extends Fragment implements OnClickListener
{
	public static final int NEWS = 0;
	public static final int ABOUT = 1;
	public static final int MEDIA = 2;
	public static final int HOBBY = 3;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.main_menu_bar, container, false);
		//Set click event listeners
		view.findViewById(R.id.news).setOnClickListener(this);
		view.findViewById(R.id.about).setOnClickListener(this);
		view.findViewById(R.id.media).setOnClickListener(this);
		view.findViewById(R.id.hobby).setOnClickListener(this);
		return view;
	}

    //In case of more complex presentation logic this type of code
    //manipulating the visualisation should be placed into the apart class
    //dedicated to the view (MainMenuView)

	public void setActive(int tab)
	{
		this.getView().findViewById(R.id.news).setBackgroundResource(R.drawable.main_menu_button);
		this.getView().findViewById(R.id.about).setBackgroundResource(R.drawable.main_menu_button);
		this.getView().findViewById(R.id.media).setBackgroundResource(R.drawable.main_menu_button);
		this.getView().findViewById(R.id.hobby).setBackgroundResource(R.drawable.main_menu_button);
		switch(tab)
		{
			case NEWS:
				this.getView().findViewById(R.id.news).setBackgroundResource(R.drawable.main_menu_button_active);
			break;
			case ABOUT:
				this.getView().findViewById(R.id.about).setBackgroundResource(R.drawable.main_menu_button_active);
			break;
			case MEDIA:
				this.getView().findViewById(R.id.media).setBackgroundResource(R.drawable.main_menu_button_active);
			break;
			case HOBBY:
				this.getView().findViewById(R.id.hobby).setBackgroundResource(R.drawable.main_menu_button_active);
			break;
		}
	}
	
	@Override
	public void onClick(View view)
	{
		int tab = -1;
		Intent intent = null;
		switch(view.getId())
		{
			case R.id.news:
				//If the targeted screen is not active open it
				if(!(this.getActivity() instanceof MainActivity))
				{
					tab = NEWS;
					intent = new Intent(this.getActivity(), MainActivity.class);
				}
			break;
			case R.id.about:
				if(!(this.getActivity() instanceof GroupsActivity))
				{
					tab = ABOUT;
					intent = new Intent(this.getActivity(), GroupsActivity.class);
				}
			break;
			case R.id.media:
				//Manage third tab
			break;
			case R.id.hobby:
				//Manage fourth tab
			break;
		}
		if(intent != null && tab != -1)
		{
			this.setActive(tab);
			this.startActivity(intent);
			// No animation
			this.getActivity().overridePendingTransition(0, 0);
			this.getActivity().finish();
		}
	}
}