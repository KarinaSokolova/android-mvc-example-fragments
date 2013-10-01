package fr.utt.socialize.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import fr.utt.socialize.R;
import fr.utt.socialize.controller.ContactsListController;
import fr.utt.socialize.controller.MainMenuController;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set active main menu tab
		MainMenuController mainMenu = (MainMenuController) getSupportFragmentManager().findFragmentById(R.id.main_menu_fragment);
		mainMenu.setActive(MainMenuController.NEWS);
		
		// Set the screen title
        // For more complex screen set up the View should be created apart
		((TextView) this.findViewById(R.id.name_bar)).setText(getResources().getString(R.string.name_bar_contacts));
				
		// Ask ContactsListController to populate the contacts list
		ContactsListController contactsListController = (ContactsListController) getSupportFragmentManager().findFragmentById(R.id.list_fragment);
		contactsListController.getContacts();
	}
}
