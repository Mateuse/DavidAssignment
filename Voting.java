import java.util.Scanner;
import java.util.Arrays;


//11, jaNE DoE; 12,JohN Doe ; 10,  TanGO    ZULu  ;   15,sierra romeo
class Voting {
    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Electronic Voting System (SEVS)\n**************************************************************\n");
        
        Scanner reader = new Scanner(System.in);

        String[][] candidateList = addCandidates(reader);

        String userChoice = userSelections(reader);
        
        while(!userChoice.equals("0")){            

            switch (userChoice) {
                case "0":            
                    break;
                case "1": {
                    displayCandidates(candidateList);
                    break;
                }
                case "2": {
                    voteCandidate(reader, candidateList);
                    break;
                }
                case "3":{
                    candidateList = addArrays(candidateList, addCandidates(reader));         
                    break;
                }                  
            
                default:
                    System.out.println("Invalid, Try again");
            }

            System.out.println();
            userChoice = userSelections(reader);
        }
    }

    public static String userSelections(Scanner reader){

        System.out.println("**********************************");
        System.out.println("| Code >> Description");
        System.out.println("**********************************");
        System.out.println("| 1 >> Display Candidates");
        System.out.println("| 2 >> Vote a candidate");
        System.out.println("| 3 >> Add new candidate(s)");
        System.out.println("| 4 >> Display results");
        System.out.println("| 0 >> End SEVS");
        
        return reader.nextLine();
    }
    
    public static void displayCandidates(String[][] candidateList) {        
        System.out.println("********************************");
        System.out.println("| ID >> Candidate's Name");
        System.out.println("********************************");

        for(String[] candidate : candidateList){            
            System.out.println("| " + candidate[0] + " >> " + candidate[1]);
        }

        System.out.println("********************************");
    }

    public static String[][] addCandidates(Scanner reader){
        System.out.println("Please enter a String collection of electoral candidates below:");
        String candidates = reader.nextLine();

        String[] addedCandidates = candidates.split(";");
        String[][] candidateList = new String[addedCandidates.length][3];
        int pos = 0;
        for(String candidate: addedCandidates){
            String[] candidateInfoList = candidate.split(",");
            candidateList[pos][0] = candidateInfoList[0].trim(); candidateList[pos][1] = candidateInfoList[1].trim(); candidateList[pos][2] = "0";
            pos += 1;
        }

        return candidateList;
    }

    public static String[][] addArrays(String[][] array1, String[][] array2){
        int length = array1.length + array2.length;

        String[][] result = new String[length][3];
        int pos = 0;
        
        for(String[] candidate: array1){            
            result[pos] = candidate;
            pos += 1;
        }

        for(String[] candidate: array2){
            result[pos] = candidate;
            pos += 1;
        }

        return result;
    }

    public static void voteCandidate(Scanner reader, String[][] candidates){
        System.out.println("Id of candidate to vote: ");
        String candidateId = reader.nextLine();
        for(String[] candidate : candidates){
            if(candidate[0].toString().equals(candidateId.toString())){
                candidate[2] = Integer.toString(Integer.parseInt(candidate[2]) + 1);
                return;
            }
        }

        System.out.println("Candidate not found");
    }
}