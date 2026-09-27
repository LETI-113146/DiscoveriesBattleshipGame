/**
 * Provides command-driven tasks for exercising the main features of the
 * Battleship application.
 *
 * <p>The tasks read commands and game data from standard input and report
 * their results through the application logger.</p>
 */
package iscteiul.ista.battleship;

import java.util.Scanner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tasks {
    /** Logger used to report task results and user messages. */
    private static final Logger LOGGER = LogManager.getLogger();

    /** Number of shots fired during each firing round. */
    private static final int NUMBER_SHOTS = 3;

    /** Message displayed when the user ends a task. */
    private static final String GOODBYE_MESSAGE = "Bons ventos!";

    /** Command used to create a new fleet. */
    private static final String NOVAFROTA = "nova";
    /** Command used to end the current task. */
    private static final String DESISTIR = "desisto";
    /** Command used to fire a round of shots. */
    private static final String RAJADA = "rajada";
    /** Command used to display the valid shots made in the game. */
    private static final String VERTIROS = "ver";
    /** Command used to reveal the fleet map. */
    private static final String BATOTA = "mapa";
    /** Command used to display the fleet status. */
    private static final String STATUS = "estado";


    /////////////////////////////////////////////////////////////////////////////
    // The following tasks demonstrate behavior that can be converted into
    // automated tests after suitable changes. They also illustrate incremental
    // development, beginning with ships and fleets and progressing to rule
    // validation and firing.
    /////////////////////////////////////////////////////////////////////////////

    /**
     * Tests ship creation by reading a ship followed by three positions and
     * reporting whether the ship occupies each position.
     */
    public static void taskA() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Ship s = readShip(in);
            if (s != null)
                for (int i = 0; i < NUMBER_SHOTS; i++) {
                    Position p = readPosition(in);
                    LOGGER.info("{} {}", p, s.occupies(p));
                }
        }
    }

    /**
     * Tests fleet creation and status reporting by processing commands read
     * from standard input.
     */
    public static void taskB() {
        Scanner in = new Scanner(System.in);
        IFleet fleet = null;
        String command = in.next();
        while (!command.equals(DESISTIR)) {
            switch (command) {
                case NOVAFROTA:
                    fleet = buildFleet(in);
                    break;
                case STATUS:
                    if (fleet != null)
                        fleet.printStatus();
                    break;
                default:
                    LOGGER.info("Que comando é esse??? Repete lá ...");
            }
            // The other commands are unknown in this task
            command = in.next();
        }
        LOGGER.info(GOODBYE_MESSAGE);
    }

    /**
     * Tests fleet creation and status reporting, including the command that
     * reveals the fleet map.
     */
    public static void taskC() {
        Scanner in = new Scanner(System.in);
        IFleet fleet = null;
        String command = in.next();
        while (!command.equals(DESISTIR)) {
            switch (command) {
                case NOVAFROTA:
                    fleet = buildFleet(in);
                    break;
                case STATUS:
                    if (fleet != null)
                        fleet.printStatus();
                    break;
                case BATOTA:
                    LOGGER.info(fleet);
                    break;
                default:
                    LOGGER.info("Que comando é esse??? Repete lá ...");
            }
            // The other commands are unknown in this task
            command = in.next();
        }
        LOGGER.info(GOODBYE_MESSAGE);
    }

    /**
     * Tests fleet creation and combat by processing commands for status
     * reporting, map display, shot history, and three-shot firing rounds.
     */
    public static void taskD() {

        Scanner in = new Scanner(System.in);
        IFleet fleet = null;
        IGame game = null;
        String command = in.next();
        while (!command.equals(DESISTIR)) {
            switch (command) {
                case NOVAFROTA:
                    fleet = buildFleet(in);
                    game = new Game(fleet);
                    break;
                case STATUS:
                    if (fleet != null)
                        fleet.printStatus();
                    break;
                case BATOTA:
                    if (fleet != null)
                        game.printFleet();
                    break;
                case RAJADA:
                    if (game != null) {
                        firingRound(in, game);

                        LOGGER.info("Hits: {} Inv: {} Rep: {} Restam {} navios.", game.getHits(), game.getInvalidShots(),
                                game.getRepeatedShots(), game.getRemainingShips());
                        if (game.getRemainingShips() == 0)
                            LOGGER.info("Maldito sejas, Java Sparrow, eu voltarei, glub glub glub...");
                    }
                    break;
                case VERTIROS:
                    if (game != null)
                        game.printValidShots();
                    break;
                default:
                    LOGGER.info("Que comando é esse??? Repete ...");
            }
            command = in.next();
        }
        LOGGER.info(GOODBYE_MESSAGE);
    }

    /**
     * Builds a fleet using ship data read from the supplied scanner.
     *
     * @param in the scanner from which ship data is read
     * @return the fleet built from the input data
     */
    static Fleet buildFleet(Scanner in) {
        assert in != null;

        Fleet fleet = new Fleet();
        int i = 0; // i represents the total of successfully created ships

        while (i <= Fleet.FLEET_SIZE) {
            IShip s = readShip(in);
            if (s != null) {
                boolean success = fleet.addShip(s);
                if (success)
                    i++;
                else
                    LOGGER.info("Falha na criacao de {} {} {}", s.getCategory(), s.getBearing(), s.getPosition());
            } else {
                LOGGER.info("Navio desconhecido!");
            }
        }
        LOGGER.info("{} navios adicionados com sucesso!", i);
        return fleet;
    }

/**