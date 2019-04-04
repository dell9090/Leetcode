class Sort {
    public quickSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    public qSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            qSort(nums, low, pivot - 1);
            qSort(nums, pivot + 1, high);
        }
    }
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                --high;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] <= pivot) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;    
        return low;
    }
}

