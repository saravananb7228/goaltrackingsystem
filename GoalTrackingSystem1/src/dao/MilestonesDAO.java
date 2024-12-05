package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Milestones;
import utility.DBConnection;

public class MilestonesDAO {

	public void FixMilestones(Milestones milestones) throws SQLException{
		String query = "INSERT INTO milestones(goal_id,milestone_description,due_date,is_completed) VALUES(?,?,?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, milestones.getGoal_id());
			ps.setString(2, milestones.getMilestone_description());
			ps.setTimestamp(3,new Timestamp(milestones.getDue_date().getTime()));
			ps.setString(4, milestones.getIs_completed());
			ps.executeUpdate();
		}
		
	}

	public List<Milestones> getAllMilestones() throws SQLException{
		List<Milestones> milestones = new ArrayList<>();
		String query ="SELECT * FROM milestones";
		try(Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
				ResultSet result = s.executeQuery(query))
		{
			while(result.next())
			{
				Milestones obj= new Milestones();
				obj.setMilestone_id(result.getInt("milestone_id"));
				obj.setGoal_id(result.getInt("goal_id"));
				obj.setMilestone_description(result.getString("milestone_description"));
				obj.setDue_date(result.getTimestamp("due_date"));
				obj.setIs_completed(result.getString("is_completed"));
				milestones.add(obj);
			}
		}
		return milestones;
	}

	public void UpdateMilestones(Milestones milestones) throws SQLException {
		String query = "update milestones set goal_id=?,milestone_description =?,due_date=?,is_completed=? where milestone_id=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setInt(1, milestones.getGoal_id());
			ps.setString(2, milestones.getMilestone_description());
			ps.setTimestamp(3,new Timestamp(milestones.getDue_date().getTime()));
			ps.setString(4, milestones.getIs_completed());
			ps.setInt(5,milestones.getMilestone_id());
			ps.executeUpdate();
		}
		
	}

	public List<Milestones> getProgress() throws SQLException{
		List<Milestones> milestones = new ArrayList<>();
		String query ="SELECT milestone_id,is_completed FROM milestones";
		try(Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
				ResultSet result = s.executeQuery(query))
		{
			while(result.next())
			{
				Milestones obj= new Milestones();
				obj.setMilestone_id(result.getInt("milestone_id"));
				obj.setIs_completed(result.getString("is_completed"));
				milestones.add(obj);
			}
		}
		return milestones;
	}

}
