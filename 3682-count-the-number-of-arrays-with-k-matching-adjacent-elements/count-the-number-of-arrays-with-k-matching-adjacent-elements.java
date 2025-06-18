class Solution {
    static final int MOD = 1_000_000_007;

    long modInverse(long a, long mod) {
        long res = 1;
        long power = mod - 2;

        while (power > 0) {
            if ((power & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            power >>= 1;
        }

        return res;
    }

    int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) % MOD;
            res = res * modInverse(i, MOD) % MOD;
        }

        return (int)res;
    }

    long binExpo(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                result = result * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }

    public int countGoodArrays(int n, int m, int k) {
        long formula = m * binExpo(m - 1, n - (k + 1)) % MOD;
        long updatedFormula = formula * nCr(n - 1, k) % MOD;
        return (int)updatedFormula;
    }
}
// 1ere version → MLE Memory Limit Exceeded
//    public int countGoodArrays(int n, int m, int k) {
//        final int MOD = 1_000_000_007;
//
//        int[][] dp = new int[n + 1][k + 1];
//        dp[1][0] = m;
//
//        // i = 2 car liste de 1 elt == m
//        for (int i = 2; i <= n; i++) {
//            // génère chaque nombre de tableaux selon le nombre de k liste avec arr[i - 1] == arr[i]
//            for (int j = 0; j <= k; j++) {
//                // Si le nombre ajouté est différent, alors i,j à les mêmes possibilités que i-1,j, le tout * (m-1) car on choisit un autre nombre que le dernier choisi.
//                dp[i][j] = (int)((1L * dp[i - 1][j] * (m - 1)) % MOD);
//
//                // Si le nombre ajouté est le même que le précédent, alors 
//                if (j > 0) {
//                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
//                }
//            }
//        }
//
//        return dp[n][k];
//    }


// 2eme version : utiliser une simple liste → TLE Time Limit Exceeded
//    public int countGoodArrays(int n, int m, int k) {
//        final int MOD = 1_000_000_007;
//
//        // dp[j] : nombre de tableaux de longueur i avec exactement j paires égales consécutives (arr[x] == arr[x-1])
//        int[] dp = new int[k + 1];
//        dp[0] = m; // Cas de base : pour une liste de taille 1, il y a m possibilités et aucune paire consécutive
//
//        // On construit les tableaux de taille 2 à n
//        for (int i = 2; i <= n; i++) {
//            // newDp : tableau temporaire pour stocker les valeurs de dp à la ligne i
//            int[] newDp = new int[k + 1];
//
//            for (int j = 0; j <= k; j++) {
//                // Cas 1 : on ajoute un nombre différent du précédent
//                // On reste au même niveau de paires consécutives (j)
//                // On a (m - 1) choix différents du précédent
//                newDp[j] = (int) ((1L * dp[j] * (m - 1)) % MOD);
//
//                // Cas 2 : on ajoute le même nombre que le précédent
//                // Donc, on augmente le nombre de paires égales de 1 (j -> j+1)
//                // Cela ne s’applique que si j > 0 (sinon dp[j - 1] serait hors limites)
//                if (j > 0) {
//                    newDp[j] = (newDp[j] + dp[j - 1]) % MOD;
//                }
//            }
//
//            // On met à jour dp avec les nouvelles valeurs calculées
//            dp = newDp;
//        }
//
//        // Le résultat est le nombre de tableaux de longueur n avec exactement k paires égales consécutives
//        return dp[k];
//    }