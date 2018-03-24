package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.subsystem.drivetrain;
import org.firstinspires.ftc.teamcode.subsystem.dumpTruck;

import static android.R.attr.name;
import static android.R.attr.right;

/**
 * Created by JOSEPH STALIN on 3/19/18.
 */
@TeleOp(name= "KV-1_TELEOP", group= "communism")
public class tele_op extends OpMode{
    public drivetrain robot;
    public dumpTruck dumpTruck;
    public static final int TICKS_PER_ROTATION = 1440;
    public static final int WHEEL_DIAMETER     = 4   ;
    public double           rotations                ;
    public double           position                 ;
    public MediaPlayer      DJ_Stalin_YEET           ;


    @Override
    public void init() {
         robot = new drivetrain(hardwareMap.dcMotor.get("right_top"), hardwareMap.dcMotor.get("right_bottom"), hardwareMap.dcMotor.get("left_bottom"), hardwareMap.dcMotor.get("left_top"));
        dumpTruck = new dumpTruck(hardwareMap.dcMotor.get("squishyRight"), hardwareMap.dcMotor.get("squishyLeft"), hardwareMap.dcMotor.get("DUMPER"));
    }
    @Override
    public void start() {
    }
    @Override
    public void loop() {
        if(gamepad1.left_trigger > 0) {
            robot.mechanumDrive(-Math.pow(gamepad1.left_stick_x, 3), -Math.pow(gamepad1.left_stick_y, 3), Math.pow(gamepad1.right_stick_x, 3));
        }
        else {
            robot.mechanumDrive(-Math.pow(gamepad1.left_stick_x, 9), -Math.pow(gamepad1.left_stick_y, 9), Math.pow(gamepad1.right_stick_x, 9));
        }
        if (gamepad1.dpad_down) {
            DJ_Stalin_YEET = MediaPlayer.create(hardwareMap.appContext,R.raw.AJP);
            DJ_Stalin_YEET.start();
        }
        if (gamepad1.left_bumper) {
            dumpTruck.a_la_basura();
        }
        if (gamepad2.right_bumper) {
            dumpTruck.devolver_a_la_basura();
        }
        DcMotor rightmotor;
    }
}
