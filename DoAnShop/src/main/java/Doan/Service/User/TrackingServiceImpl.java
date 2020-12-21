package Doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.TrackingDao;
import Doan.Dto.TrackingDto;

@Service
public class TrackingServiceImpl implements ITrackingService {
	@Autowired
	private TrackingDao trackingDao;

	public List<TrackingDto> GetDataTracking() {
		List<TrackingDto> trackingList = trackingDao.GetDataTracking();
		return trackingList;
	}

}
