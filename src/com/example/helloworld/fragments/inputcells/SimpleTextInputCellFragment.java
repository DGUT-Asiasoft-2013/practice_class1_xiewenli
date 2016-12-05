package com.example.helloworld.fragments.inputcells;

import java.lang.ref.WeakReference;

import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleTextInputCellFragment extends Fragment {
	
	TextView label;
	EditText edit;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_inputcell_simpletext, container);
		label = (TextView) view.findViewById(R.id.label);
		edit = (EditText)view.findViewById(R.id.text);
		
		return view;
	}
	
	public void setLabelText(String labelText)
	{
		label.setText(labelText);
	}
	
	public void setHintText(String HintText)
	{
		edit.setText(HintText);;
	}
	
	public void setIsPassword(boolean isPassword)
	{
		//if (isPassword)
			
		
	}
}
