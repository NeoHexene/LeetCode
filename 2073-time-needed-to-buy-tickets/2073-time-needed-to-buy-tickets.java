class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int not = tickets[k];
        int total = 0;
        int pointer = k - 1;
        while (pointer >= 0) {
            total += Math.min(tickets[pointer], not); 
            pointer--;
        }
        pointer = k + 1;
        while (pointer < tickets.length) {
            if (tickets[pointer] >= not) {
                total += not - 1;
            } else {
                total += tickets[pointer];
            }
            pointer++;
        }
        total += not;
        return total;
    }
}