class Cashier {

    int n, discount, customerNumber = 0;

    HashMap<Integer, Integer> prod_id;

    int[] prices;

    public Cashier(int n, int discount, int[] products, int[] prices) {

        this.prices = prices;
        this.n = n;
        this.discount = discount;

        prod_id = new HashMap<>();

        for (int i = 0; i < products.length; i++) {
            prod_id.put(products[i], i);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        double bill = 0.0;

        for (int i = 0; i < product.length; i++) {
            bill += (prices[prod_id.get(product[i])] * amount[i]);
        }

        if (++customerNumber % n == 0) {
            return ((100.0 - discount) / 100.0) * bill;
        }

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */