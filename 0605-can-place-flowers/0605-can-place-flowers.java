class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;

            if ((i > 0 && flowerbed[i - 1] == 1) || 
                (i < flowerbed.length - 1 && flowerbed[i + 1] == 1)) 
                continue;

            flowerbed[i] = 1;
            n--;

            if (n <= 0) return true;
        }

        return n <= 0;
    }
}