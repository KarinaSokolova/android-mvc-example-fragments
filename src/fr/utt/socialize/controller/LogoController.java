package fr.utt.socialize.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import fr.utt.socialize.R;
import fr.utt.socialize.activity.CopyrightActivity;

public class LogoController extends Fragment implements OnClickListener
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.logo_bar, container, false);
		view.findViewById(R.id.copyright).setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onClick(View view)
	{
		Intent intent = new Intent(this.getActivity(), CopyrightActivity.class);
		this.startActivity(intent);
	}
}
