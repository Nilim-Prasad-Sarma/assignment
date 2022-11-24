package com.te.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.assignment.pojo.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign, Integer> {

	public List<Campaign> findAll();
}
