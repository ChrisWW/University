import java.util.stream.Collectors
import java.util.stream.Stream

class WIEWIORs23694_5_4 {

    static void main(String[] args) {
        def inputText = new URL('https://www.fuw.edu.pl/~werner/files/englishWords.txt').text
        findProperAnagrams(inputText)

    }

    static void findProperAnagrams(String[] words) {
        List<String> list = Arrays.stream(words)
                .map({ element ->
                    Stream.of(element.split(""))
                            .sorted()
                            .collect(Collectors.joining())
                })
                .collect(Collectors.toList())

        Map<String, List<Integer>> myMap = new HashMap<>()
        for (int i = 0; i < list.size(); i++) {
            myMap.putIfAbsent(list[i], new ArrayList<>())
            myMap[list[i]].add(i)
        }

        for (Map.Entry<String, List<Integer>> output : myMap.entrySet()) {
            output.getValue().stream()
                    .forEach({ index -> if(words[index].size() > 2) {println(words[index] + " ") } })

            System.out.println()
        }

        println(" b) ")
        for (Map.Entry<String, List<Integer>> output : myMap.entrySet()) {
            output.getValue().stream()
                    .forEach({ index -> println(initiate(words[index]) + " ") })

            System.out.println()

        }
    }

    static void combo(String prefix, String s)
    {
        int N = s.length()

        System.out.println(prefix)

        for (int i = 0 ; i < N ; i++){
            combo(prefix + s.charAt(i), s.substring(i+1))}
    }
    static void permute(String prefix, String s)
    {
        int N = s.length()

        if (N == 0)
            System.out.println(" " + prefix)

        for (int i = 0 ; i < N ; i++) {
            permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N))}
    }
    static void initiate(String s)
    {
        permute("", s)
        System.out.println("----------------------------------------- ")
        combo("", s)
        System.out.println("----------------------------------------- ")
    }
}
