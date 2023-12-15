import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        challengeOne("inputOneTwo.txt");
        challengeTwo("inputOneTwo.txt");
        challengeThree("inputThreeFour.txt");


    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int[] fileData = new int[2002];
        int count = 0;
        int index = 0;

        while (scanner.hasNextLine()) {
            fileData[index] = scanner.nextInt();
            index++;
        }
        index = 0;
        while(index<2001){
            int a = fileData[index];
            int b = fileData[index+1];
            if(b>a){
                count++;
            }
            index++;
        }
        System.out.println(count);
        return count;

    }


    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int[] fileData = new int[2002];
        int count = 0;
        int index = 0;

        while (scanner.hasNextLine()) {
            fileData[index] = scanner.nextInt();
            index++;
        }
        index=0;
        while(index<1999){
            int a = fileData[index];
            int b = fileData[index+1];
            int c = fileData[index+2];
            int d = fileData[index+3];

            int firstSum = a+b+c;
            int secondSum = b+c+d;

            if(secondSum > firstSum){
                count++;
            }
            index++;
        }
        System.out.println(count);
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String[] fileData = new String[1000];
        int horizontal = 0;
        int vertical = 0;
        int index = 0;

        while (scanner.hasNextLine()) {
            fileData[index] = scanner.nextLine();
            index++;
        }
        index=0;
        while(index<1000){
            String a = fileData[index];
            String[] b = a.trim().split("//s+");



            if(a.substring(0,3).equals("for")){
                String front = a.substring(8,9);
                int f = Integer.parseInt(front);
                horizontal += f;
            }
            if(a.substring(0,3).equals("dow")){
                String frontTwo = a.substring(5,6);
                int ft = Integer.parseInt(frontTwo);
                vertical+=ft;
            }

            if(a.substring(0,1).equals("u")){
                String upOne = a.substring(3,4);
                int upTwo = Integer.parseInt(upOne);
                vertical-=upTwo;
            }
            index++;
        }
        System.out.println(horizontal*vertical);
        return (horizontal*vertical);
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String[] fileData = new String[1000];
        int horizontal = 0;
        int vertical = 0;
        int aim = 0;
        int index = 0;

        while (scanner.hasNextLine()) {
            fileData[index] = scanner.nextLine();
            index++;
        }
        index = 0;
        while (index < 1000) {
            String a = fileData[index];
            String[] b = a.trim().split("//s+");

            if (a.substring(0, 3).equals("dow")) {
                String frontTwo = a.substring(5, 6);
                int ft = Integer.parseInt(frontTwo);
                aim += ft;
                vertical += ft;
            }

            if (a.substring(0, 1).equals("u")) {
                String upOne = a.substring(3, 4);
                int upTwo = Integer.parseInt(upOne);
                aim -= upTwo;
                vertical -= upTwo;
            }
            if (a.substring(0, 3).equals("for")) {
                String front = a.substring(8, 9);
                int f = Integer.parseInt(front);
                horizontal += f;
                vertical += (aim * f);
            }
            index++;


        }
        System.out.println(horizontal * vertical);
        return horizontal*vertical;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}
