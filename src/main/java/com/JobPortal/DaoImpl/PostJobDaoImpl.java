package com.JobPortal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.PostJobInterface;
import com.JobPortal.Model.CompanyModel;
import com.JobPortal.Model.PostJobModel;

public class PostJobDaoImpl implements PostJobInterface {

	Scanner sc = new Scanner(System.in);

	public void postJobs(PostJobModel str2) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnection();
			String queries = " insert into posting_job( company_id,  job_title, salary,experience , category)values (?,?,?,?,?)";
			stmt = con.prepareStatement(queries);
			stmt.setInt(1, str2.getCompanyId());
			stmt.setString(2, str2.getJobTitle());
			stmt.setInt(3, str2.getIncome());
			stmt.setString(4, str2.getService());
			stmt.setString(5, str2.getCategories());
			stmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt);
		}
	}

	public List<PostJobModel> showJobs() {

		List<PostJobModel> viewJobs = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select company_id,post_id,job_title,salary,experience,category,post_date from posting_job"
					+ " order by post_date desc ";
			PostJobModel showJobs;
			viewJobs = new ArrayList<PostJobModel>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				showJobs = new PostJobModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDate(7));
				viewJobs.add(showJobs);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return viewJobs;
	}

	public List<PostJobModel> viewJobs(String email) {
		List<PostJobModel> view = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select p.company_id,p.post_id,p.job_title,p.salary,p.experience,p.category,p.post_date,c.email "
					+ "from posting_job p,Company_login c where p.company_id=c.company_id and c.email=? order by post_date desc ";
			PostJobModel showJobs = null;
			view = new ArrayList<PostJobModel>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				showJobs = new PostJobModel();
				showJobs.setCompanyId(rs.getInt(1));
				showJobs.setPostId(rs.getInt(2));
				showJobs.setJobTitle(rs.getString(3));
				showJobs.setIncome(rs.getInt(4));
				showJobs.setService(rs.getString(5));
				showJobs.setCategories(rs.getString(6));
				showJobs.setPostDate(rs.getDate(7));
				showJobs.setEmail(rs.getString(8));
				view.add(showJobs);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return view;
	}

	public void deletePostJob(int postId) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getDBconnection();
			String Query = "delete from posting_job where post_id =" + postId;
			ps = con.prepareStatement(Query);
			System.out.println(ps.executeUpdate() + "post job row deleted");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	public void insertPostJobDao(PostJobModel str21) {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnection();
			String update = "update posting_job set job_title=?,salary=?,experience=?,category=? where company_id=? ";
			stmt = con.prepareStatement(update);
			stmt.setString(1, str21.getJobTitle());
			stmt.setInt(2, str21.getIncome());
			stmt.setString(3, str21.getService());
			stmt.setString(4, str21.getCategories());
			stmt.setInt(5, str21.getCompanyId());
			int res = stmt.executeUpdate();
			System.out.println(res + " is updated !!");
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt);
		}
	}

	public List<PostJobModel> SearchJobs(String Location) {

		List<PostJobModel> viewJobs = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience  "
					+ "from posting_job p ,Company_login c where c.company_id=p.company_id and c.location = ?";
			PostJobModel showJobs;
			viewJobs = new ArrayList<PostJobModel>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);
			ps.setString(1, Location);
			rs = ps.executeQuery();
			while (rs.next()) {
				showJobs = new PostJobModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				viewJobs.add(showJobs);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return viewJobs;
	}

	public List<PostJobModel> SearchExp(String Experience) {

		List<PostJobModel> viewJobs = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience "
					+ " from posting_job p ,Company_login c where c.company_id=p.company_id and p.experience = ?";

			PostJobModel showJobs;
			viewJobs = new ArrayList<PostJobModel>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);
			ps.setString(1, Experience);
			rs = ps.executeQuery();
			while (rs.next()) {
				showJobs = new PostJobModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				viewJobs.add(showJobs);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return viewJobs;
	}

	public List<PostJobModel> SearchSal(int salary) {

		List<PostJobModel> viewJobs = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String query = "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience  "
					+ "from posting_job p ,Company_login c	where c.company_id=p.company_id and p.salary = ?";
			PostJobModel showJobs;
			viewJobs = new ArrayList<PostJobModel>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, salary);
			rs = ps.executeQuery();

			while (rs.next()) {
				showJobs = new PostJobModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				viewJobs.add(showJobs);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return viewJobs;
	}

	public List<PostJobModel> SearchCom(String company) {

		List<PostJobModel> viewJobs = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience "
					+ " from posting_job p ,Company_login c	where c.company_id=p.company_id and c.company_name = ?";

			PostJobModel showJobs;
			viewJobs = new ArrayList<PostJobModel>();
			con = ConnectionUtil.getDBconnection();
			ps = con.prepareStatement(query);
			ps.setString(1, company);
			rs = ps.executeQuery();
			while (rs.next()) {
				showJobs = new PostJobModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				viewJobs.add(showJobs);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return viewJobs;
	}

	@Override
	public void postJob() throws ClassNotFoundException, SQLException {

	}

	@Override
	public void searchByExperience(String experience) throws ClassNotFoundException, SQLException {

	}

	@Override
	public void searchByLocation(String location1) throws ClassNotFoundException, SQLException {

	}

	@Override
	public void searchBySalary(int salary) throws ClassNotFoundException, SQLException {

	}

	@Override
	public void searchByCompany(String CompanyName) throws ClassNotFoundException, SQLException {

	}

	@Override
	public void deleteJob(PostJobModel st) throws ClassNotFoundException, SQLException {

	}
}