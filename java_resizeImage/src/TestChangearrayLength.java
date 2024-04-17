public class TestChangearrayLength {
	
	public static void main(String[] args) {
		int[] array = new int[10];
		int[] newArray = new int[20];
		System.out.println("1. array length = " +  array.length);
		array = newArray;
		System.out.println("2. array length = " +  array.length);
		System.out.println("array = " +  array[0]);
		
	}

}
