package com.github.cschen1205.navigator.minefield;

import com.github.cschen1205.falcon.FalconConfig;
import com.github.cschen1205.navigator.minefield.agents.FalconNavAgent;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by cschen1205 on 4/6/17.
 */
public class MineFieldSimulatorUnitTest {

    private MineFieldSimulator createSimulator(String falconMode, MineFieldSimulatorConfig simConfig, FalconConfig aiConfig){
        int numSims = simConfig.getNumRuns();
        int startSim = simConfig.getStartRun();

        String name="minefield";




        System.out.println("Start: " + startSim + "\tNo. of runs: "+numSims);
        simConfig.setName(name);


        if(falconMode.equalsIgnoreCase("sarsa")) {
            return new MineFieldSimulatorSarsa(simConfig, aiConfig);
        } else if(falconMode.equalsIgnoreCase("qlearn")) {
            return new MineFieldSimulatorSarsa(simConfig, aiConfig);
        } else if(falconMode.equalsIgnoreCase("sarsalambda")) {
            return new MineFieldSimulatorSarsaLambda(simConfig, aiConfig);
        } else if(falconMode.equalsIgnoreCase("r")) {
            return new MineFieldSimulatorR(simConfig, aiConfig);
        } else {
            return new MineFieldSimulatorQLambda(simConfig, aiConfig);
        }
    }

    @Test
    public void test(){
        MineFieldSimulatorConfig config = new MineFieldSimulatorConfig();
        config.setImmediateRewardProvided(false);
        config.setNumRuns(1);
        config.setMaxTrial(300);


        FalconConfig falconConfig = new FalconConfig();
        falconConfig.numAction = FalconNavAgent.numAction;
        falconConfig.numState = config.numState();
        falconConfig.numReward = 2;
        falconConfig.isBounded = false;

        String falconMode = "qlearn";


        MineFieldSimulator simulator = createSimulator(falconMode, config, falconConfig);
        simulator.runSims();
    }

}