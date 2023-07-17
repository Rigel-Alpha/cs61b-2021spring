package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList Ns = new AList();
        AList times = new AList();
        AList opCounts = new AList();
        int N0 = 1000;
        while (N0 <= 12800){
            Ns.addLast(N0);
            Stopwatch sw = new Stopwatch();
            AList test = new AList();
            for (int i = 0; i < N0; i++){
                test.addLast(0);
            }
            double timeInSeconds = sw.elapsedTime();
            opCounts.addLast(N0);
            times.addLast(timeInSeconds);
            N0 *= 2;
        }
        printTimingTable(Ns, times, opCounts);
    }
}
