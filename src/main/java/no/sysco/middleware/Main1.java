package no.sysco.middleware;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 *
 * @author 100tsa
 */
@Measurement(iterations = 10)
@Warmup(iterations = 5)
@Fork(value = 3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class Main1 {
    
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + Main1.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }   
    /**
     * iterative approach
     * @param sen
     * @return 
     */
    public static String longestWordA(String sen) {
        String[] split = sen.split(" ");
        int tempLength = 0;
        String tempStr = null;
        for (String s : split) {
            String alphaOnly = s.replaceAll("[^a-zA-Z0-9]+", "");
            if (alphaOnly.length() > tempLength) {
                tempLength = alphaOnly.length();
                tempStr = alphaOnly;
            }
        }
        return tempStr;
    }
    /**
     * Stream approach
     * @param sen
     * @return 
     */
    public static String longestWordB(String sen) {
        return Arrays.asList(sen.split(" ")).stream().map((t)
                -> {
            return t.replaceAll("[^a-zA-Z0-9]+", "");

        }).collect(java.util.stream.Collectors.groupingBy(String::length)).entrySet().stream().sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed()).map(Map.Entry::getValue).findFirst().get().get(0);
    }
    /**
     * Parallel stream approach
     * @param sen
     * @return 
     */
    public static String longestWordC(String sen) {
        return Arrays.asList(sen.split(" ")).stream().parallel().map((t)
                -> {
            return t.replaceAll("[^a-zA-Z0-9]+", "");

        }).collect(java.util.stream.Collectors.groupingBy(String::length)).entrySet().stream().sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed()).map(Map.Entry::getValue).findFirst().get().get(0);
    }

    @Benchmark
    public static void testLongestWordA(Blackhole b) {
        String result = Main1.longestWordA("There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone");
        b.consume(result);
    }

    @Benchmark
    public static void testLongestWordB(Blackhole b) {
        String result = Main1.longestWordB("There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone");
        b.consume(result);
    }
    @Benchmark
    public static void testLongestWordC(Blackhole b) {
        String result = Main1.longestWordC("There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone There is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestoneThere is a sentence with some words where we want tofindalongestone");
        b.consume(result);
    }
}
