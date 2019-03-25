package com.osf.test.service.impl;

import java.util.List;

import com.osf.test.dao.FoodDAO;
import com.osf.test.dao.impl.FoodDAOImpl;
import com.osf.test.service.FoodService;
import com.osf.test.vo.Food;

public class FoodServiceImpl implements FoodService {
	private FoodDAO fdao = new FoodDAOImpl();
	@Override
	public List<Food> selectFoodList() {
		return fdao.selectFoodList();
	}

	@Override
	public Food selectFood(Integer foodNum) {
		return fdao.selectFood(foodNum);
	}

	@Override
	public int insertFood(Food food) {
		return fdao.insertFood(food);
	}

	@Override
	public int updateFood(Food food) {
		return fdao.updateFood(food);
	}

	@Override
	public int deleteFood(Integer foodNum) {
		return fdao.deleteFood(foodNum);
	}

}
