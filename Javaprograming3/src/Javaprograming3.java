///////////////////////////////////////////////////////////////////////////////
// Title : Javaprograming3
// Files : Javaprograming3.java
// Semester : 2019-1학기
//
// Author : 김태우/ twinvest@naver.com
// Class : 월123
//// 작성일 : 2019-03-23 
// 키워드: 벼열과 함수형프로그래밍 그리고 for each문
//
// 과제설명 : 배열의 이해와 함수형 프로그래밍의 연습. 그리고 for each문을 활용하였습니다. 
// 과제완성여부 : 완성
// 미완성기능 : 없음
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.util.Scanner;

public class Javaprograming3 {
	
	public static void main(String[] args) 
	{
		Matrix mat = new Matrix();
		mat.mymain();
	}
}
class Matrix {
	int lower, upper;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	void mymain() 
	{
		int[] array = null;
		System.out.print(">> ");
		int sz = scan.nextInt();
		System.out.print("범위: ");
    	lower = scan.nextInt();
    	upper = scan.nextInt();
		
    	array = generateRand(make(sz));
    	print(array);
		
		
		int n = maxIndex(array);
		System.out.printf("(1) 제일 큰 값은 array[%d] = %d%n", n, array[n]);
		
		double avg = getRefreeAvg(array);
		System.out.printf("(2) 최대 최소 제외 평균은 %.2f%n", avg);
		
		int k = rand.nextInt(5)+5;  // 5~9 사이의 랜덤값
		n = countMulti(array, k);
		System.out.printf("(3) %d의 배수의 개수는 %d개%n", k, n);
		System.out.println("(4) 두 배열의 합은...");
		print(array);
		System.out.println("+");
		int[] newArray = generateRand(make(sz));
		print(newArray);
		System.out.println("=");
		print(sumArray(array, newArray));
	}
	
	int[] make(int size)
	{
		int[] array = new int[size];
		return array;
	}
	
	int[] generateRand(int[] array)
	{
		Random rand = new Random();
		for(int i=0; i<array.length; i++)
		{
			int random = (int)(Math.random() * (upper-lower))+lower;
			array[i] = random;
		}
		return array;
	}
	void print(int[] arr)
	{
		System.out.print("[");
		for(int e : arr)
		{
			System.out.print("    "+e);
		}
		System.out.println("]");
	}
	int maxIndex(int[] array)
	{
		
		int index=0;
		int max=0;
		int tmp;
		for(int i=0; i<array.length; i++)
		{
			tmp = array[i];
			if(tmp>max)
			{
				max=tmp;
				index = i;
			}	
		}
		return index; 
	}
	
	double getRefreeAvg(int[] arr)
	{
		int maxindex=0;
		int minindex=0;
		int size = arr.length-2;
		int max = arr[0];
	    int min = arr[0];
	    int sum=0;
	    double avg;
	    for (int i = 0; i < arr.length; i++) 
	    {
	        if (arr[i] > max) {
	            max = arr[i];
	            maxindex=i;
	        }
	        if (arr[i] < min) {
	            min = arr[i];
	            minindex=i;
	        }
	    }
		
	    for(int i=0; i<arr.length; i++)
		{
			if(maxindex == i || minindex==i)	continue;
			sum = sum + arr[i];
		}
		avg = sum / (double)size;
		return avg;
	}
	
	int countMulti(int[] array, int random)
	{
		int count=0;
		for(int i=0; i<array.length; i++)		
			if(array[i] != 0 && array[i] % random == 0) //0은 배수로 치지 않는다.
				count++;
		return count;
	}
	int[] sumArray(int[] a, int[] b)
	{
		int size = a.length;
		int[] arr = new int[size];
		for(int i=0; i<size; i++)
			arr[i] = a[i] + b[i];
		return arr;
	}
}