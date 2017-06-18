# java-ai-minefield-navigator

Package provides java implementation of a multi-agent learning simulator based on FALCON ANN and RL

# Introduction 

TD-FALCON is a fusion architecture that incorporates temporal difference methods and self-organizing neural networks for reinforcement learning with delayed rewards. It learns by creating cognitive codes across sensory input, actions, and rewards.

The implementation of TD-FALCON can be found in the minefield navigation simulator in this java project, alongside with its reactive version R-FALCON, and a backpropagation network based Q-learning system.

# Install

Add the following dependency to your POM file:

```java

```



# Usage: Invoke GUI-based Simulator

The sample code below shows how to invoke the Q-Learn TD-FALCON MineField Navigator GUI:

```java
MineFieldSimulatorConfig config = new MineFieldSimulatorConfig();
config.setImmediateRewardProvided(true);
config.setNumAgents(1);

FalconConfig falconConfig = new FalconConfig();
falconConfig.numAction = FalconNavAgent.numAction;
falconConfig.numState = config.numState();
falconConfig.numReward = 2;

MineFieldSimulatorGUI gui = new MineFieldSimulatorGUI(config, falconConfig);

```

# Usage: Invoke Command-line based Simulator

The sample code below shows show to run the TD-FALCON MineField Navigator simulation in console mode:



```java
MineFieldSimulatorConfig config = new MineFieldSimulatorConfig();
config.setImmediateRewardProvided(false);
config.setNumRuns(1);
config.setMaxTrial(300);


FalconConfig falconConfig = new FalconConfig();
falconConfig.numAction = FalconNavAgent.numAction;
falconConfig.numState = config.numState();
falconConfig.numReward = 2;
falconConfig.isBounded = false;


MineFieldSimulator simulator = new MineFieldSimulatorQ(config, falconConfig);
simulator.runSims();
```

The above codes invoke the Q-Learn TD-FALCON simulator, to switch to other learning paradigms, change the 

"MineFieldSimulatorQ" to one of the following:

* MineFieldSimulatorSARSA: state-action-reward-state-action
* MineFieldSimulatorQLambda: Q-Learning with lambda trails
* MineFieldSimulatorSARSALambda: SARSA with lambda trails
* MineFieldSimulatorR: R-Learning



