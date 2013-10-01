package fr.utt.socialize.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import fr.utt.socialize.R;
import fr.utt.socialize.controller.GroupsListController;
import fr.utt.socialize.controller.MainMenuController;

public class GroupsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);
		
		// Main menu
		MainMenuController mainMenu = (MainMenuController) getSupportFragmentManager().findFragmentById(R.id.main_menu_fragment);
		mainMenu.setActive(MainMenuController.ABOUT);
		
		// Set the screen title
		((TextView) this.findViewById(R.id.name_bar)).setText(getResources().getString(R.string.name_bar_groups));
					
		// Ask the corresponding list controller the data
		GroupsListController groupsListController = (GroupsListController) getSupportFragmentManager().findFragmentById(R.id.list_fragment);
		groupsListController.getGroups();
	}
}
