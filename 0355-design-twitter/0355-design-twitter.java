class Tweet {
    int tweetId;
    int time;

    public Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Twitter {
    private int time = 0;
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add own tweets
        if (tweets.containsKey(userId)) {
            for (Tweet t : tweets.get(userId)) heap.offer(t);
        }

        // Add followees' tweets
        for (int followeeId : follows.getOrDefault(userId, new HashSet<>())) {
            if (tweets.containsKey(followeeId)) {
                for (Tweet t : tweets.get(followeeId)) heap.offer(t);
            }
        }

        List<Integer> result = new ArrayList<>();
        int k = 0;
        while (!heap.isEmpty() && k++ < 10) {
            result.add(heap.poll().tweetId);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // can't unfollow self
        follows.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */