package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IBudgetService;
import com.example.demo.interfaces.IBudget;
import com.example.demo.modelo.Budget;



@Service
public class BudgetService implements IBudgetService{
	
	@Autowired
	private IBudget data;
	
	
	@Override
	public Optional<Budget> listNrotrans(int nrotrans) {
		return data.findById(nrotrans);
	}

	@Override
	public int save(Budget b) {
		int res=0;
		Budget budget = data.save(b);
		if (!budget.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int nrotrans) {
		data.deleteById(nrotrans);		
	}

	@Override
	public String sum() {
		String res = "0";
		if(data.sum() != null) {
			res = data.sum();
		}		
		return res;
	}

	@Override
	public List<Budget> lastTen() {
		return (List<Budget>)data.lasTen();
	}
}