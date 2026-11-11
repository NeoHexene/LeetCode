class Pair {

    String s;
    int d;

    Pair(String s, int d) {
        this.s = s;
        this.d = d;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();

        for (String word : wordList) {
            set.add(word);
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            String word = curr.s;
            int step = curr.d;

            if (endWord.equals(word)) {
                return step;
            }

            char[] replaceArray = word.toCharArray();
            
            for (int i = 0; i < word.length(); i++) {
                
                char original = replaceArray[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    replaceArray[i] = ch;
                    String replaced = new String(replaceArray);

                    if (set.contains(replaced)) {
                        set.remove(replaced);
                        q.offer(new Pair(replaced, step + 1));
                    }
                }

                replaceArray[i] = original;
            }
        }

        return 0;
    }
}