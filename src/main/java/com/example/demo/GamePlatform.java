package com.example.demo;

public class GamePlatform {

	public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
		for (int inclination : inclinations) {
			if (inclination == 0) {
				continue;
			}

			double speed = Math.abs(inclination);

			if (inclination < 0) {
				initialSpeed = initialSpeed + speed;
				continue;
			}

			initialSpeed = initialSpeed - speed;
		}
		return Math.abs(initialSpeed);
	}

	public static void main(String[] args) {
		System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 45, 0 })); // should print 45
	}

}