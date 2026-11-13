class Solution {

    private void dfs(String currWord, List<String> path, Map<String, Integer> map, List<List<String>> res, String beginWord) {
        
        if (currWord.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        char[] arr = currWord.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            
            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                
                arr[i] = ch;
                String newWord = new String(arr);
                
                if (map.containsKey(newWord) && map.get(newWord) + 1 == map.get(currWord)) {
                    
                    path.add(newWord);
                    dfs(newWord, path, map, res, beginWord);
                    path.remove(path.size() - 1);
                }
            }

            arr[i] = original;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord, 0);
        set.remove(beginWord);

        while (!q.isEmpty()) {

            String word = q.poll();

            if (word.equals(endWord)) {
                break;
            }

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String replacedWord = new String(arr);

                    if (set.contains(replacedWord)) {
                        q.offer(replacedWord);
                        map.put(replacedWord, map.get(word) + 1);
                        set.remove(replacedWord);
                    }
                }

                arr[i] = original;
            }
        }

        if (!map.containsKey(endWord)) {
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, path, map, res, beginWord);

        return res;
    }
}