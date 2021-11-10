package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.lib.DataServer.Annotations.Signal;

public class DriverInterface {

    XboxController driverController;

    @Signal
    double curFwdRevCmd;
    @Signal
    double curRotCmd;

    public DriverInterface(){

        driverController = new XboxController(0);

    }

    public void update(){
        curFwdRevCmd = -1.0 * driverController.getY(Hand.kLeft);
        curRotCmd = -1.0 * driverController.getX(Hand.kRight);
    }

    /**
     * Gets the driver command for fwd/rev
     * 1.0 means "fast as possible forward"
     * 0.0 means stop
     * -1.0 means "fast as possible reverse"
     * @return 
     */
    double getFwdRevCmd(){
        if(curFwdRevCmd > -0.5 && curFwdRevCmd < 0.5){
            return 0;
        }
        else return curFwdRevCmd;
    }

    /**
     * Gets the driver command for rotate
     * 1.0 means "fast as possible to the left"
     * 0.0 means stop
     * -1.0 means "fast as possible to the right"
     * @return 
     */
    double getRotateCmd(){
        if(curRotCmd > -0.5 && curRotCmd < 0.5){
            return 0;
        }
        
        
        else return curRotCmd;
    }
    
}
