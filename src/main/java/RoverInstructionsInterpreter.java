import exceptions.InvalidMarsInstructionsFileException;

import java.io.*;
import java.util.ArrayList;

public class RoverInstructionsInterpreter {
    private String plateauSize;
    private ArrayList<String> instructions = new ArrayList();
    private ArrayList<String> originCoordinates = new ArrayList();


    public String getPlateauSize() {
        return plateauSize;
    }

    public void setPlateauSize(String plateauSize) {
        this.plateauSize = plateauSize;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    public ArrayList<String> getOriginCoordinates() {
        return originCoordinates;
    }

    public void setOriginCoordinates(ArrayList<String> originCoordinates) {
        this.originCoordinates = originCoordinates;
    }


    public void read(String fileName) throws InvalidMarsInstructionsFileException {

        try {
            InputStream is = getClass().getResourceAsStream(fileName);
            InputStreamReader streamReader = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(streamReader);

            plateauSize = reader.readLine();

            while (true) {
                String originCoords = reader.readLine();
                String instr = reader.readLine();
                if (originCoords != null && instr != null) {
                    originCoordinates.add(originCoords);
                    instructions.add(instr);
                } else {
                    break;
                }

            }

        } catch (Exception e) {
            throw new InvalidMarsInstructionsFileException("The Rover Instruction loader cannot find the specified instructions file " + fileName);
        }
        String [] plateauStr = plateauSize.split(" ");

        if (plateauSize == null || plateauStr.length != 2 || originCoordinates.size() != instructions.size()) {
            throw new InvalidMarsInstructionsFileException("The instructions file provided its not following the Mars standards");
        }

    }
}
