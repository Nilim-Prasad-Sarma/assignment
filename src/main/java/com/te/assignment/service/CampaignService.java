package com.te.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.assignment.pojo.Campaign;
import com.te.assignment.repo.CampaignRepo;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepo repo;

	public List<Campaign> getCampaign(){
		return repo.findAll();
	}
}
