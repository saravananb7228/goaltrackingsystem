package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Goals;
import utility.DBConnection;
public class GoalsDAO {
	public void addGoal(Goals goals) throws SQLException{
		String query = "INSERT INTO goals(goal_name,goal_description,target_date) VALUES(?,?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, goals.getGoal_name());
			ps.setString(2, goals.getGoal_description());
			ps.setTimestamp(3,new Timestamp(goals.getTarget_date().getTime()));
			ps.executeUpdate();
		}
		
	}

	public void updateGoals(Goals goals) throws SQLException {
		String query = "update goals set goal_name=?,goal_description =?,target_date=? where goal_id=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query))
		{
			ps.setString(1, goals.getGoal_name());
			ps.setString(2, goals.getGoal_description());
			ps.setTimestamp(3,new Timestamp(goals.getTarget_date().getTime()));
			ps.setInt(4,goals.getGoal_id());
			ps.executeUpdate();
		}
	}

	public List<Goals> getAllGoals()throws SQLException {
		List<Goals> goals = new ArrayList<>();
		String query = "SELECT * FROM goals";
		try(Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
				ResultSet result = s.executeQuery(query))
		{
			while(result.next())
			{
				Goals obj= new Goals();
				obj.setGoal_id(result.getInt("goal_id"));
				obj.setGoal_name(result.getString("goal_name"));
				obj.setGoal_description(result.getString("goal_description"));
				obj.setTarget_date(result.getTimestamp("target_date"));
				goals.add(obj);
			}
		}
		return goals;
	}

	public void deleteGoal(int deleteGoalId)throws SQLException {
		String query = "delete from goals where goal_id =?;";
		try {
			Connection co = DBConnection.getConnection();
			PreparedStatement p = co.prepareStatement(query);
			p.setInt(1, deleteGoalId);
			p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
