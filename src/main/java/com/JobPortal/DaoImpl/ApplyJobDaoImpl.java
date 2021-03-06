package com.JobPortal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.ApplyJobInterface;
import com.JobPortal.Model.ApplyJob;
import com.JobPortal.Model.PostJobModel;

public class ApplyJobDaoImpl implements ApplyJobInterface {

	public void applyJob(ApplyJob str3) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnection();
			String query = " insert into Apply_Job( post_id,  applicant_name,qualification,skill, age, email, password,address,"
					+ "phone_number)values (?,?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, str3.getPostId());
			stmt.setString(2, str3.getApplicantName());
			stmt.setString(3, str3.getQualification());
			stmt.setString(4, str3.getSkill());
			stmt.setInt(5, str3.getAge());
			stmt.setString(6, str3.getEmail());
			stmt.setString(7, str3.getPassword());
			stmt.setString(8, str3.getAddress());
			stmt.setLong(9, str3.getPhoneNumber());
			stmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt);
		}
	}

	public List<ApplyJob> showApplicant(String email) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ApplyJob> showApplicants = null;
		try {
			String query = "select a.applicant_id,a.post_id,a.applicant_name,a.qualification,a.age,a.email,a.address,a.phone_number,"
					+ "a.skill,a.apply_date from apply_job a join posting_job p on a.post_id=p.post_id join Company_login c on"
					+ " p.company_id=c.company_id  where c.email=? order by a.apply_date desc";
			ApplyJob applicants = null;
			showApplicants = new ArrayList<ApplyJob>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);

			ps.setString(1, email);

			rs = ps.executeQuery();

			while (rs.next()) {
				applicants = new ApplyJob();
				applicants.setApplicantId(rs.getInt(2));
				applicants.setPostId(rs.getInt(1));
				applicants.setApplicantName(rs.getString(3));
				applicants.setQualification(rs.getString(4));
				applicants.setAge(rs.getInt(5));
				applicants.setEmail(rs.getNString(6));
				applicants.setAddress(rs.getString(7));
				applicants.setPhoneNumber(rs.getLong(8));
				applicants.setSkill(rs.getString(9));
				applicants.setDate(rs.getDate(10));

				showApplicants.add(applicants);

			}

		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return showApplicants;
	}

	public void viewAppliedJobStatus() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "select post_id,applicant_id,status from job_status";

			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println("\n" + "PostId :   " + rs.getInt(1) + "\n" + "Applicant ID :  " + rs.getInt(2) + "\n"
						+ "job status : " + rs.getString(3));
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
	}

	public List<ApplyJob> viewStatusApplicant(String email) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ApplyJob> viewStatus = null;
		try {
			String Query = "select a.post_id,a.applicant_name,a.email,a.phone_number,a.applicant_id,a.apply_date,j.status "
					+ "from apply_job a,job_status j where a.applicant_id = j.applicant_id and a.email=? ";
			ApplyJob showStatus;
			viewStatus = new ArrayList<ApplyJob>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(Query);

			ps.setString(1, email);
			rs = ps.executeQuery();

			while (rs.next()) {
				showStatus = new ApplyJob(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getInt(5),
						rs.getDate(6), rs.getString(7));

				viewStatus.add(showStatus);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return viewStatus;

	}

	@Override
	public List<ApplyJob> showApplicant() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}