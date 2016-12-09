package com.example.helloworld.fragments.inputcells;

import com.example.helloworld.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleTextInputCellFragment extends BaseInputCellFragment {
	
		
	TextView label;
	private EditText edit;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_inputcell_simpletext, container);
		label = (TextView) view.findViewById(R.id.label);
		setEdit((EditText)view.findViewById(R.id.edit));
		
		return view;
	}
	
	public void setLabelText(String labelText)
	{
		label.setText(labelText);
	}
	
	public void setHintText(String HintText)
	{
		getEdit().setHint(HintText);
	}
	
	public void setIsPassword(boolean isPassword)
	{
		if(isPassword)
		{
			getEdit().setInputType(EditorInfo.TYPE_CLASS_TEXT|EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);	
		}
		else
		{
			getEdit().setInputType(EditorInfo.TYPE_CLASS_TEXT);
		}		
}

	public EditText getEdit() {
		return edit;
	}

	public void setEdit(EditText edit) {
		this.edit = edit;
	}
}
