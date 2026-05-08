import java.util.*;

class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;

        // prime -> indices divisible by that prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> factors = getPrimeFactors(nums[i]);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1)
                    return jumps;

                // move left
                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // move right
                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // teleport
                if (isPrime(nums[idx])) {

                    int p = nums[idx];

                    if (map.containsKey(p)) {

                        for (int next : map.get(p)) {

                            if (!vis[next]) {
                                vis[next] = true;
                                q.offer(next);
                            }
                        }

                        // important optimization
                        map.remove(p);
                    }
                }
            }

            jumps++;
        }

        return -1;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;

        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    private Set<Integer> getPrimeFactors(int n) {

        Set<Integer> set = new HashSet<>();

        for (int i = 2; i * i <= n; i++) {

            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        if (n > 1)
            set.add(n);

        return set;
    }
}