package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by JUSTIN on 3/22/18.
 */

public class dumpTruck {
    public DcMotor squishyLeft;
    public DcMotor squishyRight;
    public DcMotor DUMPER;
    public static final int TICKS_PER_ROTATION = 1120;
    public dumpTruck (DcMotor squishyLeft, DcMotor squishyRight, DcMotor DUMPER) {
        this.squishyLeft = squishyLeft;
        this.squishyRight = squishyRight;
        this.DUMPER = DUMPER;
    }
    public void a_la_basura() {
        DUMPER.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DUMPER.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double ninety = 1120 / 4;
        DUMPER.setTargetPosition((int) (ninety));
        DUMPER.setPower(.5);
        while (DUMPER.isBusy()) {

        }
    }
    public void devolver_a_la_basura() {
        DUMPER.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DUMPER.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double ninety = 1120 / 4;
        DUMPER.setTargetPosition((int) (-ninety));
        DUMPER.setPower(.5);
        while (DUMPER.isBusy()) {

        }
    }
}
