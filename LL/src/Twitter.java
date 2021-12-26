import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Twitter
 */
public class Twitter {
    static HashMap<Integer, ArrayList<Integer>> tweets = new HashMap<>();
    static HashMap<Integer, LinkedList<Integer>> followee = new HashMap<>();

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        // obj.postTweet(1, 1);
        List<Integer> li = obj.getNewsFeed(1);
        System.out.println("feed" + li);
        // obj.follow(2, 1);
        // List<Integer> li1 = obj.getNewsFeed(2);
        // System.out.println("feed" + li1);
        // obj.unfollow(2, 1);
        // List<Integer> li2 = obj.getNewsFeed(2);
        // System.out.println("feed" + li2);
        System.out.println("Tweets Map:- " + tweets);
        System.out.println("Followers Map :- " + followee);
        // System.out.println(li);

    }

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        ArrayList<Integer> tweetsIds = tweets.get(userId);

        if (tweetsIds == null) {
            ArrayList<Integer> newTweetsId = new ArrayList<>();
            newTweetsId.add(tweetId);
            tweets.put(userId, newTweetsId);
        } else {
            tweetsIds.add(tweetId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> folList = followee.get(userId);
        if (folList == null) {
            List<Integer> feeds = tweets.get(userId);
            if (feeds == null) {
                return new ArrayList<>();
            }
            List<Integer> recent10feeds = new ArrayList<>(10);
            int count = 10;
            int index = feeds.size();
            while (count > 0 && index > 0) {
                recent10feeds.add(tweets.get(userId).get(index - 1));
                index--;
                count--;
            }
            return recent10feeds;
        } else {

            HashMap<Integer, Integer> indexes = new HashMap<>(folList.size());
            for (Integer integer : folList) {
                if (tweets.get(integer) == null) {
                    indexes.put(integer, -1);
                    continue;
                }
                // int index = tweets.get(integer).size() - 1;
                indexes.put(integer, tweets.get(integer).size() - 1);
            }

            System.out.println("Fol indexes :- " + indexes);
            List<Integer> recent10feeds = new ArrayList<>(10);
            int count = 10;

            while (count > 0) {
                int max = Integer.MIN_VALUE;
                int key = 0;
                for (Integer integer : folList) {
                    if (indexes.get(integer) < 0) {
                        continue;
                    }
                    int elem = tweets.get(integer).get(indexes.get(integer));
                    if (elem > max) {
                        max = elem;
                        key = integer;
                    }
                }

                if (max == -2147483648) {
                    return recent10feeds;
                }
                if (indexes.get(key) != null && indexes.get(key) >= 0) {
                    indexes.put(key, indexes.get(key) - 1);
                }
                recent10feeds.add(max);
                count--;
            }
            return recent10feeds;
        }

    }

    public void follow(int followerId, int followeeId) {
        LinkedList<Integer> followeeIds = followee.get(followerId);
        if (followeeIds == null) {
            LinkedList<Integer> newfolloweeId = new LinkedList<>();
            newfolloweeId.add(followerId);
            newfolloweeId.add(followeeId);
            followee.put(followerId, newfolloweeId);
        } else {
            followeeIds.add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        LinkedList<Integer> followeeIds = followee.get(followerId);
        if (followeeIds != null) {
            followeeIds.remove(followeeIds.indexOf(followeeId));
        }
        System.out.println(followeeIds);

    }
}