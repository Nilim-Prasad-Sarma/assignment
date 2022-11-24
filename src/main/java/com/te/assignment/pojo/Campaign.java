package com.te.assignment.pojo;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Campaign {

	@Id
	private Integer userId;
	private String campaignId;
	private String campaignMetaData;

}
