package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        int N = 1000, M = 10000;
        AList Ns = new AList();
        AList times = new AList();
        AList opCounts = new AList();
        while (N <= 128000){
            SLList testList = new SLList(0);
            for (int i = 1; i < N; i++) {
                testList.addLast(0);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < M; j++){
                testList.getLast();
            }
            double timeCount = sw.elapsedTime();
            Ns.addLast(N);
            times.addLast(timeCount);
            opCounts.addLast(M);
            N *= 2;
        }
        printTimingTable(Ns, times, opCounts);
    }

}
