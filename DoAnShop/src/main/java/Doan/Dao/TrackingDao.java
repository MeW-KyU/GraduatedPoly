package Doan.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Doan.Dto.TrackingDto;
import Doan.Dto.TrackingDtoMapper;

@Repository
public class TrackingDao extends BaseDao {
	
	
	
	private String sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT I.Invoice_Code, I.Date_Sale, P.Name_Product, DI.Amount, DI.Total, I.Status, I.Customer_Code, I.Note ");
		sql.append("FROM DetailInvoice AS DI ");
		sql.append("INNER JOIN Invoice AS I ON I.Invoice_Code = DI.Invoice_Code ");
		sql.append("INNER JOIN Product AS P ON P.Product_Code = DI.Product_Code ");
		return sql.toString();
	}
	
	public List<TrackingDto> GetDataTracking() {
		String sql = sqlString();
		List<TrackingDto> trackingList = _jdbcTemplate.query(sql, new TrackingDtoMapper());
				return trackingList;
	}
}
