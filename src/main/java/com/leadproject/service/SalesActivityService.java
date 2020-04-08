package com.leadproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadproject.model.SalesActivity;
import com.leadproject.repository.SalesActivityRepository;

@Service
public class SalesActivityService {
	@Autowired
	private SalesActivityRepository salesRepository;

	public SalesActivity create(SalesActivity activity) {
		return salesRepository.save(activity);
	}

	public SalesActivity get(Long id) {
		Optional<SalesActivity> activity = salesRepository.findById(id);
		if (activity.isPresent()) {
			return activity.get();
		} else {
			return null;
		}

	}
	
	public SalesActivity getByLeadIdAndId(Long lead_id, Long id) {
		Optional<SalesActivity> salesActivity = salesRepository.findByIdAndLeadId(id, lead_id);
		if (salesActivity.isPresent()) {
			return salesActivity.get();
		} else {
			return null;
		}
	}

	public List<SalesActivity> findByLeadId(Long lead_id) {
		return salesRepository.findByLeadId(lead_id);
	}

	public SalesActivity update(final SalesActivity salesActivity, final Long id) {
		Optional<SalesActivity> activity = salesRepository.findById(id);
		if (null != activity.get()) {
			SalesActivity activityEntity = activity.get();			
			activityEntity.setOwner(salesActivity.getOwner());
			activityEntity.setProduct(salesActivity.getProduct());
			activityEntity.setSalesDate(salesActivity.getSalesDate());
			activityEntity.setStatus(salesActivity.getStatus());

			return salesRepository.save(activityEntity);
		}
		return salesActivity;
	}

	public void delete(Long id) {
		Optional<SalesActivity> activity = salesRepository.findById(id);
		if (activity.isPresent()) {
			salesRepository.delete(activity.get());
		}
	}
}
