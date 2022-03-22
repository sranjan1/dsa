package com.sranjan.dsa.facebook;

public abstract class Direction {
	
	abstract boolean canMoveRight();
	abstract boolean canMoveLeft();
	abstract boolean canMoveUp();
	abstract boolean canMoveDown();
	abstract boolean isLastPosition();
}
