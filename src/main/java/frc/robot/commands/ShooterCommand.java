// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Shooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import frc.robot.RobotContainer;

/**
 *
 */
public class ShooterCommand extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Shooter m_shooter;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // private XboxController manipulatorXbox =
    // RobotContainer.getInstance().getManipulatorXbox();

    double triggerThreshold = 0.5;
    double highSpeed = 0.95;
    double lowSpeed = 0.9;
    double boostIncrease = 1.05;
    double boostDecrease = 0.95;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public ShooterCommand(Shooter subsystem) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_shooter = subsystem;
        addRequirements(m_shooter);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.print("Shooter Command Init");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double speed = 0;
        if (RobotContainer.getInstance().getManipulatorXbox().getLeftTriggerAxis() > triggerThreshold) {
            speed = lowSpeed;
        }
        if (RobotContainer.getInstance().getManipulatorXbox().getRightTriggerAxis() > triggerThreshold) {
            speed = highSpeed;
        }
        if (RobotContainer.getInstance().getManipulatorXbox().getRawButton(3))
        {
            speed = speed * boostDecrease; //If X button, Decrease
        }
        if (RobotContainer.getInstance().getManipulatorXbox().getRawButton(2))
        {
            speed = speed * boostIncrease; //If B button, Increase
        }
        m_shooter.setSpeed(speed);
        System.out.print("Shooter Command Exec " + speed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
