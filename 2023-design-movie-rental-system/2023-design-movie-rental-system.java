import java.util.*;

class MovieRentingSystem {
    // Map movieId -> TreeSet of unrented shops (ordered by price, then shop)
    private Map<Integer, TreeSet<ShopEntry>> unrented;
    // Global TreeSet of rented entries (ordered by price, then shop, then movie)
    private TreeSet<RentedEntry> rented;
    // Map (shop,movie) encoded -> price
    private Map<Long, Integer> priceMap;
    
    public MovieRentingSystem(int n, int[][] entries) {
        unrented = new HashMap<>();
        rented = new TreeSet<>();
        priceMap = new HashMap<>();
        
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            long key = encode(shop, movie);
            priceMap.put(key, price);
            unrented
                .computeIfAbsent(movie, k -> new TreeSet<>())
                .add(new ShopEntry(price, shop));
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<ShopEntry> set = unrented.get(movie);
        if (set == null) return ans;
        Iterator<ShopEntry> it = set.iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            ans.add(it.next().shop);
            cnt++;
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        long key = encode(shop, movie);
        int price = priceMap.get(key);
        // remove from unrented
        TreeSet<ShopEntry> set = unrented.get(movie);
        set.remove(new ShopEntry(price, shop));
        // add to rented
        rented.add(new RentedEntry(price, shop, movie));
    }
    
    public void drop(int shop, int movie) {
        long key = encode(shop, movie);
        int price = priceMap.get(key);
        // remove from rented
        rented.remove(new RentedEntry(price, shop, movie));
        // add back to unrented
        unrented.get(movie).add(new ShopEntry(price, shop));
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<RentedEntry> it = rented.iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            RentedEntry re = it.next();
            ans.add(Arrays.asList(re.shop, re.movie));
            cnt++;
        }
        return ans;
    }
    
    // Encode (shop,movie) into a single long
    private long encode(int shop, int movie) {
        return ((long)shop << 32) | (movie & 0xffffffffL);
    }
    
    // Helper class for unrented shops
    private static class ShopEntry implements Comparable<ShopEntry> {
        int price, shop;
        ShopEntry(int p, int s) {
            price = p; shop = s;
        }
        public int compareTo(ShopEntry o) {
            if (price != o.price) return price - o.price;
            return shop - o.shop;
        }
        public boolean equals(Object o) {
            if (!(o instanceof ShopEntry)) return false;
            ShopEntry other = (ShopEntry)o;
            return price == other.price && shop == other.shop;
        }
        public int hashCode() {
            return Objects.hash(price, shop);
        }
    }
    
    // Helper class for rented entries
    private static class RentedEntry implements Comparable<RentedEntry> {
        int price, shop, movie;
        RentedEntry(int p, int s, int m) {
            price = p; shop = s; movie = m;
        }
        public int compareTo(RentedEntry o) {
            if (price != o.price) return price - o.price;
            if (shop != o.shop)   return shop - o.shop;
            return movie - o.movie;
        }
        public boolean equals(Object o) {
            if (!(o instanceof RentedEntry)) return false;
            RentedEntry other = (RentedEntry)o;
            return price==other.price && shop==other.shop && movie==other.movie;
        }
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }
}
