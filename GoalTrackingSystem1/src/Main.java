import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import controller.GoalTrackingController;
import model.Goals;
import model.Milestones;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		GoalTrackingController controller = new GoalTrackingController();
		while(true)
		{
			System.out.println("Goal Tracking System");
			System.out.println("1.Add Goal");
			System.out.println("2.Update Goal");
			System.out.println("3.List All Goals");
			System.out.println("4.Delete Goals");
			System.out.println("5.set milestones");
			System.out.println("6. Update the milestone");
			System.out.println("7. Track the progress of goal");
			System.out.println("8. List all milestones");
			System.out.println("9. exit");
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:System.out.println("Enter Goal Name: ");
			String name = br.readLine();
			System.out.println("Enter Goal Description: ");
			String goal_desc = br.readLine();
			System.out.println("Enter the Target Date (yyyy-mm-dd hh:mm:ss):");
			String targetDate = br.readLine();
			Timestamp targetDate1 = targetDate.isEmpty() ? (Timestamp) new Date() : Timestamp.valueOf(targetDate);
			controller.addGoal(new Goals(0,name,goal_desc,targetDate1));
			break;
			case 2:System.out.println("Enter Goal ID");
			int updateGoalId = Integer.parseInt(br.readLine());
			System.out.println("Enter New Goal Name");
			String Updatename = br.readLine();
			System.out.println("Enter New Goal description");
			String Updatedesc = br.readLine();
			System.out.println("Enter New target date");
			String Updatetargetdate=br.readLine();
			Timestamp targetDate2 = Updatetargetdate.isEmpty() ? (Timestamp) new Date() : Timestamp.valueOf(Updatetargetdate);
			controller.updateGoals(new Goals(updateGoalId,Updatename,Updatedesc,targetDate2));
			break;
			case 3: List<Goals> goals = controller.getAllGoals();
			for(Goals goal: goals)
			{
				System.out.println
				("ID: "+goal.getGoal_id()+" Name: "
				+goal.getGoal_name()+" Description     "
				+goal.getGoal_description()+" Target Date"
				+goal.getTarget_date());
			}
			break;
			case 4:System.out.println("Enter Goal ID to be Deleted");
			int deleteGoalId = Integer.parseInt(br.readLine());
			controller.deleteGoal(deleteGoalId);
			break;
			case 5:System.out.println("Enter Goal ID");
			int GoalId = Integer.parseInt(br.readLine());
			System.out.println("Enter the Milestone description");
			String Milestones_desc=br.readLine();
			System.out.println("Enter the due date");
			String duedate=br.readLine();
			Timestamp dueDate = duedate.isEmpty()? (Timestamp) new Date() : Timestamp.valueOf(duedate);
			controller.FixMilestones(new Milestones(0,GoalId,Milestones_desc,dueDate,"Not completed"));
			break;
			case 6: System.out.println("Enter the milestone ID:");
			int milestone_id=Integer.parseInt(br.readLine());
			System.out.println("Enter new Goal ID");
			int Goal_Id = Integer.parseInt(br.readLine());
			System.out.println("Update the new milestone description:");
			String milestone_description=br.readLine();
			System.out.println("Update the new due date in the format(yyyy-mm-dd hh:mm:ss:");
			String due_date=br.readLine();
			Timestamp due_Date=due_date.isEmpty()?(Timestamp) new Date():Timestamp.valueOf(due_date);
			System.out.println("Enter the new completion Ststus:");
			String completionStatus=br.readLine();
			controller.UpdateMilestones(new Milestones(milestone_id,Goal_Id,milestone_description,due_Date,completionStatus));
			break;
			case 7: List<Milestones> milestones = controller.getProgress();
			for(Milestones milestone: milestones)
			{
				System.out.println
			("Milestones ID: "+milestone.getMilestone_id()
//				+" Goal ID: "
//				+milestone.getGoal_id()+" Description "
//				+milestone.getMilestone_description()+" Due Date "
//				+milestone.getDue_date()
			+" Completion Status "
				+milestone.getIs_completed());
			}
			break;
			case 8: List<Milestones> milestone = controller.getAllMilestones();
			for(Milestones Milestone: milestone)
			{
				System.out.println
			("Milestones ID: "+Milestone.getMilestone_id()
				+" Goal ID: "
				+Milestone.getGoal_id()+" Description "
				+Milestone.getMilestone_description()+" Due Date "
				+Milestone.getDue_date()
			+" Completion Status "
				+Milestone.getIs_completed());
			}
			break;
			case 9: System.out.println("Exiting.....");
			return;
			}
		}


	}

}
