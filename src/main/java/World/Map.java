package World;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {


    public static void map() {

        Objects.room.add(new Room(0));
        Objects.room.get(0).name = "Floating in Space";
        Objects.room.get(0).desc.add("Desc Line");
        Objects.room.get(0).exits.add("Exits");

        File inputFile = new File("rooms.txt");
        List<String> roomInfo = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                roomInfo.add(scanner.nextLine()); }

            for(int j = 0; j < roomInfo.size(); j++){

                String[] firstWord = roomInfo.get(j).split(" ");
                String[] everythingElse = roomInfo.get(j).split(":");

                if(firstWord[0].equals("RoomName:")){
                    int currentRoomSize = Objects.room.size();
                    Objects.room.add(new Room(currentRoomSize));
                    Objects.room.get(Objects.room.size()-1).name = everythingElse[1];
                    Objects.room.get(Objects.room.size()-1).number = currentRoomSize;

                    int roomcount = 0;
                    for(int i = 0; i < roomInfo.size(); i++){
                        String[] nextFirstWord = roomInfo.get(i).split(" ");
                        if(nextFirstWord[0].equals("RoomName:")){
                            roomcount++;
                        }
                        if (roomcount == currentRoomSize){
                            if(nextFirstWord[0].equals("Desc:")){
                                String[] nextEverythingElse = roomInfo.get(i).split(":");
                                Objects.room.get(Objects.room.size() - 1).desc.add(nextEverythingElse[1]);
                            }
                        }
                    }
                    roomcount = 0;
                    for(int i = 0; i <roomInfo.size(); i++){
                        String[] nextFirstWord = roomInfo.get(i).split(" ");
                        if(nextFirstWord[0].equals("RoomName:")){
                            roomcount++;
                        }
                        if (roomcount == currentRoomSize){
                            if(nextFirstWord[0].equals("Exit:")){
                                String[] nextEverythingElse = roomInfo.get(i).split(":");
                                Objects.room.get(Objects.room.size() - 1).exits.add(nextEverythingElse[1]);
                            }
                        }
                    }

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("World does not exist.");
        }

    }
}
