package com.te.assignment.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.assignment.pojo.Campaign;
import com.te.assignment.pojo.MapDetails;
import com.te.assignment.service.CampaignService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CampaignController {
	@Autowired
	private CampaignService campaignService;
	ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUser() throws JsonMappingException, JsonProcessingException {
		List<Campaign> campaign = campaignService.getCampaign();
		List<Object> list = new ArrayList<>();
		for (Campaign campaign2 : campaign) {

			List<MapDetails> readValue = mapper.readValue(campaign2.getCampaignMetaData(),
					new TypeReference<List<MapDetails>>() {
					});
			list.add(readValue);
		}
		CampaignController.formObject(list);
		//log.info(list + "");
		return new ResponseEntity<List<Campaign>>(campaign, HttpStatus.OK);
	}

	private static void formObject(List<Object> userListData) throws NumberFormatException {
		for (int i = 0; i < userListData.size(); i++) {
			List<MapDetails> array_element = (List<MapDetails>) userListData.get(i);
			for (MapDetails mapDetails : array_element) {
				log.info(mapDetails.getTimeValue());
				long val= Long.parseLong(mapDetails.getTimeValue());
				DateFormat simple = new SimpleDateFormat(
			            "dd MMM yyyy");
			        Date result = new Date(val);
				log.error(simple.format(result)+"");
			}
		}
	}
}
