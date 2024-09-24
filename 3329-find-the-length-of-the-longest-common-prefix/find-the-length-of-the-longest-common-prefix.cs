public class Solution {
    public int LongestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<string> uniquePrefix = new HashSet<string>();
        for (int i = 0; i < arr1.Length; i++) 
        {
            var value = arr1[i].ToString();
            for(int k = 0; k < value.Length; k++) 
            {
                uniquePrefix.Add(value.Substring(0, k + 1));
            }
        }

        int result = 0;
        for (int i = 0; i < arr2.Length; i++) 
        {
            var value = arr2[i].ToString();
            for (int k = 0; k < value.Length; k++)
            {
                if (!uniquePrefix.Contains(value.Substring(0, k + 1)))
                    break;
                result = Math.Max(result, k + 1);
            }
        }

        return result;
    }
}