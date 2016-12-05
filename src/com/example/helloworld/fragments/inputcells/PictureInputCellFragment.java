package com.example.helloworld.fragments.inputcells;

import com.example.helloworld.R;

import android.app.Fragment;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureInputCellFragment extends BaseInputCellFragment {
	
	ImageView imageView;
	TextView labelText;
	TextView hintText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_inputcell_picture, container);
		
		imageView  = (ImageView)view.findViewById(R.id.image);
		labelText = (TextView)view.findViewById(R.id.labelText);
		hintText = (TextView)view.findViewById(R.id.hint);
		
		imageView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onImageViewClicked();
				
			}
		});
		
		return view;
	}
	
	void onImageViewClicked()
	{
	}
	
	public void setLabelText(String labelText)
	{
		this.labelText.setText(labelText);
	}
	
	public void setHintText(String hintText)
	{
		this.hintText.setText(hintText);
	}
	
	
}
