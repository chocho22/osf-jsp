package com.osf.test.dao;

import java.util.List;

import com.osf.test.vo.Food;

public interface FoodDAO {
	public List<Food> selectFoodList();
	public Food selectFood(Integer foodNum);
	public int insertFood(Food food);
	public int updateFood(Food food);
	public int deleteFood(Integer foodNum);
	
}
