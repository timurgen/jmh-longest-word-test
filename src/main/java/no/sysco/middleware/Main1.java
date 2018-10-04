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
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 *
 * @author 100tsa
 */
@Measurement(iterations = 10, time = 1)
@Warmup(iterations = 5, time = 1)
@Fork(value = 3)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class Main1 {
    

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + Main1.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

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

    public static String longestWordB(String sen) {
        return Arrays.asList(sen.split(" ")).stream().map((t)
                -> {
            return t.replaceAll("[^a-zA-Z0-9]+", "");

        }).collect(java.util.stream.Collectors.groupingBy(String::length)).entrySet().stream().sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed()).map(Map.Entry::getValue).findFirst().get().get(0);
    }

    @Benchmark
    public static void testLongestWordA() {
        Main1.longestWordA("There is a sentence with some words where we want tofindalongestone");
    }

    @Benchmark
    public static void testLongestWordB() {
        Main1.longestWordB("There is a sentence with some words where we want tofindalongestone");
    }
}
