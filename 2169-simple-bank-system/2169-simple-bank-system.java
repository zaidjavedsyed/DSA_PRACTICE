class Bank {
    private final long[] bal;
    private final int n;
    
    public Bank(long[] balance) {
        this.n = balance.length;
        // copy to avoid external mutation
        this.bal = Arrays.copyOf(balance, n);
    }
    
    public boolean transfer(int account1, int account2, long money) {
        // validate accounts and funds
        if (!valid(account1) || !valid(account2) || bal[account1-1] < money) {
            return false;
        }
        // perform transfer
        bal[account1-1] -= money;
        bal[account2-1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        bal[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!valid(account) || bal[account-1] < money) {
            return false;
        }
        bal[account-1] -= money;
        return true;
    }
    
    // helper to check 1 <= account <= n
    private boolean valid(int account) {
        return account >= 1 && account <= n;
    }
}
