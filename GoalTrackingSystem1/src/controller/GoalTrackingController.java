package controller;
import java.sql.SQLException;
import java.util.List;

import dao.GoalsDAO;
import dao.MilestonesDAO;
import model.Goals;
import model.Milestones;

public class GoalTrackingController {
	private final GoalsDAO goalsDAO;
	private final MilestonesDAO milestonesDAO;
	public GoalTrackingController() {
		super();
		this.goalsDAO = new GoalsDAO();
		this.milestonesDAO= new MilestonesDAO();
	}
	public void addGoal(Goals goals) throws SQLException{
		goalsDAO.addGoal(goals);
		
	}
	public void updateGoals(Goals goals)throws SQLException {
		goalsDAO.updateGoals(goals);
		
	}
	public List<Goals> getAllGoals() throws SQLException {
		// TODO Auto-generated method stub
		return goalsDAO.getAllGoals();
	}
	public void deleteGoal(int deleteGoalId)throws SQLException {
		goalsDAO.deleteGoal(deleteGoalId);
		
	}
	public void FixMilestones(Milestones milestones) throws SQLException{
		milestonesDAO.FixMilestones(milestones);
		
	}
	public List<Milestones> getAllMilestones()throws SQLException {
		// TODO Auto-generated method stub
		return milestonesDAO.getAllMilestones();
	}
	public void UpdateMilestones(Milestones milestones)throws SQLException{
		// TODO Auto-generated method stub
		milestonesDAO.UpdateMilestones(milestones);
	}
	public List<Milestones> getProgress() throws SQLException{
		// TODO Auto-generated method stub
		return milestonesDAO.getProgress();
	}
	
}
