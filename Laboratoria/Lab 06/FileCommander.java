package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCommander {
    private Path path;

    public FileCommander() {
        this.path = Path.of(System.getProperty("user.home"));
    }
    public String pwd(){
        return path.toString();
    }
    public void cd(String path){
        this.path=this.path.resolve(path);
    }
    public static String formatDirBraces(String text) {
        return "[" + text + "]";
    }
    public static String formatDirColor(String text) {
        return ConsoleColors.BLUE + text + ConsoleColors.RESET;
    }

    public static String formatFiltered(String text, String substring) {
        String result = "";
        int begin = text.indexOf(substring);
        int end = begin + substring.length();

        String endMarker = text.startsWith(ConsoleColors.BLUE) ? ConsoleColors.BLUE : ConsoleColors.RESET;

        result += text.substring(0, begin);
        result += ConsoleColors.RED_BOLD;
        result += text.substring(begin, end);
        result += endMarker;
        result += text.substring(end);

        return result;
    }

    public List<String> ls(Function<String, String> formatDir, String substring){
        Comparator<Path> c = (p1, p2) ->
                Boolean.compare(Files.isDirectory(p2),Files.isDirectory(p1));
        c = c.thenComparing(p -> p.getFileName().toString());

        boolean isFiltered = substring!=null;

        try (Stream<Path> stream = Files.list(path)) {
            return stream
                    .filter(isFiltered ? currentPath -> currentPath.getFileName().toString().contains(substring) : currentPath -> true)
                    .sorted(c)
                    .map(path -> {
                        String spath = path.getFileName().toString();
                        if(Files.isDirectory(path)) {
                            return formatDir.apply(spath);
                        }
                        else return spath;
                    })
                    .map(isFiltered ? spath -> formatFiltered(spath, substring) : spath -> spath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // Zadanie 3
    public List<String> find(String s) {
        try(Stream<Path> stream = Files.walk(path)){
            return stream.filter(currentPath -> currentPath.getFileName().toString().contains(s))
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
