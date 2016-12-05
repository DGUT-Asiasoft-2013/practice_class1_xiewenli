package com.example.helloworld.fragments.inputcells;

import java.lang.ref.WeakReference;

import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleTextInputCellFragment extends BaseInputCellFragment {
	
	final int REQUESTCODE_CAMERA = 1;
	final int REQUESTCODE_ALBUM = 2;
	
	TextView labelText;
	TextView hintText;
	ImageView imageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_inputcell_simpletext, container);
		labelText = (TextView) view.findViewById(R.id.label);
		hintText = (EditText)view.findViewById(R.id.text);
		
		return view;
	}
	
	public void setLabelText(String labelText)
	{
		labelText.setText(labelText);
	}
	
	public void setHintText(String HintText)
	{
		labelText.setText(HintText);;
	}
	
	public void setIsPassword(boolean isPassword)
	{
		//if (isPassword)
			
		
	}
}
