package Doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dto.TrackingDto;

@Service
public interface ITrackingService {
	@Autowired
	public List<TrackingDto> GetDataTracking();
}
