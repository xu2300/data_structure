package backtracking;

public class ndimensionarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

public static void sum(MultiDimArray mArray, int[] dim) {
        return loopSum(dim, 0, mArray, new Stack<Integer> stackIndices);
}

private static int loopSum(int[] dim, int dimIndex, MultiDimArray mArray, Stack<Integer> stackIndices) {
        if (dimIndex >= dim.length) {
                        int[] indices = new int[stackIndices.size()];
                        int i = 0;
                        for (int index : stackIndices)
                                indices[i++] = index;
                        return mArray.get(indices); // get data from mArray
                } 
        int sum = 0;
        for (int index = 0; index < dim[dimIndex]; ++index)
                stackIndices.push(index);
                sum += loopSum(dim, dimIndex + 1, mArray, stackIndices);
                                stackIndices.pop();
        return sum;
}
}
