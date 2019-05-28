package com.JDBC.Impl;

import com.JDBC.DoMain.GaragePosition;

public interface IGaragePosition {
	public GaragePosition get(String country, String area, int num);
	public void upDateEmpty(int isEmpty, String country, String area, int num);
}
