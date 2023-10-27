package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.Set;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;


@TeleOp(name = "MrWellingtonTribute2")
public class MrWellingtonTribute extends LinearOpMode {

      private DcMotor FrontRight;
      private DcMotor BackRight;
      private DcMotor BackLeft;
      private DcMotor FrontLeft;
      private CRServo Alice_Sucks;
      private Servo Johns_Ucket;
      private DcMotor Ed_Carries;
    
      //private DcMotor Alice_Sucks;
  @Override
  public void runOpMode() {
    
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        Alice_Sucks = hardwareMap.get(CRServo.class, "Alice_Sucks");
        Ed_Carries = hardwareMap.get(DcMotor.class, "Ed_Carries");
        Johns_Ucket = hardwareMap.get(Servo.class, "Johns_Ucket");
      //  Alice_Sucks = hardwareMap.get(DcMotor.class, "Alice_Sucks");
        
        
        Johns_Ucket.scaleRange(-1,.7);
        
    
  
    waitForStart();
    if (opModeIsActive()) {
      
      
      Ed_Carries.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      
      
      FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
      BackRight.setDirection(DcMotorSimple.Direction.REVERSE);

      while (opModeIsActive()) {
        
        
        //Tank drive
         
         
          FrontLeft.setPower(gamepad1.right_stick_y * .9);
          BackLeft.setPower(gamepad1.right_stick_y * .9);
          FrontRight.setPower(gamepad1.left_stick_y * .9);
          BackRight.setPower(gamepad1.left_stick_y * .9);
          
          
          //Mechanim 
          
              //left
              
          if (gamepad1.dpad_left)
          {
            FrontLeft.setPower(-1);
            BackLeft.setPower(1);
            FrontRight.setPower(1);
            BackRight.setPower(-1);
          }
            //Right
          if (gamepad1.dpad_right)
          {
            FrontLeft.setPower(1);
            BackLeft.setPower(-1);
            FrontRight.setPower(-1);
            BackRight.setPower(1);
          }
            
      //Intake
    
    
      if (gamepad1.x)
            {
              Alice_Sucks.setPower(1);
              
            }
      if (gamepad1.b)
      {
        Alice_Sucks.setPower(-1);
        
      }
        if (gamepad1.a)
        {
          Alice_Sucks.setPower(0);
        }

 //Ucket
 
 
 
 if (gamepad1.right_bumper)
 {
   Johns_Ucket.setPosition(.3);
   
 }
 
 
 if (gamepad1.left_bumper)
 
    {
 Johns_Ucket.setPosition(0);
    }
 
 // Lift
 
    Ed_Carries.setPower(gamepad1.right_trigger);
    Ed_Carries.setPower(-gamepad1.left_trigger);
    
  
        telemetry.update();
      }
    }
}
}
