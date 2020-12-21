package Doan.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrackingDtoMapper implements RowMapper<TrackingDto> {

	public TrackingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrackingDto track = new TrackingDto();
		track.setInvoice_Code(rs.getLong("Invoice_Code"));
		track.setDate_Sale(rs.getDate("Date_Sale"));
		track.setName_Product(rs.getString("Name_Product"));
		track.setAmount(rs.getInt("Amount"));
		track.setTotal(rs.getDouble("Total"));
		track.setStatus(rs.getInt("Status"));
		track.setCustomer_Code(rs.getString("Customer_Code"));
		return track;
	}

}
