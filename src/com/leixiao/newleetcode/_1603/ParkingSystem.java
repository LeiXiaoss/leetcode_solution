package com.leixiao.newleetcode._1603;

public class ParkingSystem {

	private int bigSize;
	private int mediumSize;
	private int smallSize;

	public ParkingSystem(int big, int medium, int small) {
		this.bigSize = big;
		this.smallSize = small;
		this.mediumSize = medium;
	}

	public boolean addCar(int carType) {
		switch (carType) {
			case 1:
				if (bigSize > 0) {
					bigSize--;
					return true;
				} else {
					return false;
				}
			case 2:
				if (mediumSize > 0) {
					mediumSize--;
					return true;
				} else {
					return false;
				}
			case 3:
				if (smallSize > 0) {
					smallSize--;
					return true;
				} else {
					return false;
				}
		}
		return false;
	}
}
