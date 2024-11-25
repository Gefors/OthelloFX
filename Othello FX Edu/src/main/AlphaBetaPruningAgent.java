package main;

import com.eudycontreras.othello.capsules.AgentMove;
import com.eudycontreras.othello.capsules.MoveWrapper;
import com.eudycontreras.othello.controllers.AgentController;
import com.eudycontreras.othello.controllers.Agent;
import com.eudycontreras.othello.enumerations.PlayerTurn;
import com.eudycontreras.othello.models.GameBoardState;
import com.eudycontreras.othello.threading.ThreadManager;
import com.eudycontreras.othello.threading.TimeSpan;
import com.eudycontreras.othello.utilities.GameTreeUtility;
import com.eudycontreras.othello.utilities.TraversalUtility;

/**
 * <H2>Created by</h2> Eudy Contreras
 * <h4> Mozilla Public License 2.0 </h4>
 * Licensed under the Mozilla Public License 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <a href="https://www.mozilla.org/en-US/MPL/2.0/">visit Mozilla Public Lincense Version 2.0</a>
 * <H2>Class description</H2>
 *
 * @author Eudy Contreras
 */
public class AlphaBetaPruningAgent extends Agent{

    public AlphaBetaPruningAgent() {
        super(PlayerTurn.PLAYER_ONE);
        // TODO Auto-generated constructor stub
    }

    private AlphaBetaPruningAgent(PlayerTurn playerTurn) {
        super(playerTurn);
        // TODO Auto-generated constructor stub
    }

    /**
     * Delete the content of this method and Implement your logic here!
     */
    @Override
    public AgentMove getMove(GameBoardState gameState) {
        return getAplhaBetaMove(gameState);
    }

    /**
     * Default template move which serves as an example of how to implement move
     * making logic. Note that this method does not use Alpha beta pruning and
     * the use of this method can disqualify you
     *
     * @param gameState
     * @return
     */
    private AgentMove getAplhaBetaMove(GameBoardState gameState){


        int depth = GameTreeUtility.TRAVERSAL_DEPTH; // Maximum depth for the Alpha-Beta search
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        boolean isMaximizingPlayer = playerTurn == PlayerTurn.PLAYER_ONE;

        // Return the selected move
        MoveWrapper bestMove = AgentController.findBestMoveAlphaBeta(
                gameState,
                playerTurn,
                depth,
                alpha,
                beta,
                isMaximizingPlayer,
                System.currentTimeMillis(),
                UserSettings.MIN_SEARCH_TIME
        );
        System.out.println("Move: " + bestMove.getMoveReward());
        return bestMove;

    }

}
