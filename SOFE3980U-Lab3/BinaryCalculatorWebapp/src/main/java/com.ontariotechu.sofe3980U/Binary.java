package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) 
	{

		for (int i = 0; i < number.length(); i++) 
		{
			//Check if character for conditions if not 1 or 0
			char ch = number.charAt(i);
			if(ch!='0' && ch!='1') 
			{
				number ="0"; //If not 1 or 0, store 0
				return;
			}
		}
		// Removing trailing zeros
		int trail;
		for (trail = 0; trail < number.length(); trail++) 
		{
			if (number.charAt(trail)!='0')
				break;
		}
		// Excluding trailing zeros, if are.
		this.number=number.substring(trail); 

		// uncomment the following code
		if(this.number =="") { // replace empty strings with a single zero
			this.number ="0";
		}

    }

	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}

	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The fians addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		
		int index1 = num1.number.length()-1;
		int index2 = num2.number.length()-1;
		
		int carry = 0;
		String num3 = "";  //Binary sum

		//Looping until everything has been processed
		while(index1>=0 ||  index2>=0 || carry!=0)
		{
			int sum = carry; //Setting Carry

			if(index1>=0){
				sum += (num1.number.charAt(index1)=='1')? 1:0; //Converts digits to sums.
				index1--; //Update
			}

			if(index2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(index2)=='1')? 1:0; //Converts digits to sums.
				index2--; //Update
			}

			carry = sum/2; //Setting NEW Carry
			sum = sum%2;  //Result
			num3 = ((sum==0)? "0":"1") + num3; //Converting the sum into String + num3
		}

		Binary ans = new Binary(num3); //Giving an object the sum value
		return ans;
	}

	public static Binary OR(Binary num1,Binary num2)
	{
		
		int length1 = num1.number.length();
		int length2 = num2.number.length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < Math.max(length1, length2); i++) {
			char ind1, ind2, orResult;

			if (i < length1) 
    			ind1 = num1.number.charAt(length1 - 1 - i);
			else 
    			ind1 = '0';

			if (i < length2) 
    			ind2 = num2.number.charAt(length2 - 1 - i);
			else 
    			ind2 ='0';
			
			if (ind1 == '1' || ind2 == '1') 
    			orResult = '1';
 			else 
    			orResult = '0';

			result.insert(0, orResult);
		}

		return new Binary(result.toString());
	}

	public static Binary AND(Binary num1, Binary num2) 
	{
		int length1 = num1.number.length();
		int length2 = num2.number.length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < Math.max(length1, length2); i++) {
			char ind1, ind2, andResult;

			if (i < length1) 
    			ind1 = num1.number.charAt(length1 - 1 - i);
			else 
    			ind1 = '0';

			if (i < length2) 
    			ind2 = num2.number.charAt(length2 - 1 - i);
			else 
    		ind2 ='0';

			if (ind1 == '1' && ind2 == '1') 
    			andResult = '1';
 			else 
    			andResult = '0';
				
			result.insert(0, andResult);
		}
		return new Binary(result.toString());
	}

	public static Binary Multiply(Binary num1, Binary num2) {

		Binary result = new Binary("0");

		for (int i = 0; i < num2.number.length(); i++) {
			char currentIndex = num2.number.charAt(num2.number.length() - 1 - i);
			if (currentIndex == '1') {

				Binary partialProduct = new Binary(num1.number);

				for (int j = 0; j < i; j++) {
					partialProduct = Binary.add(partialProduct, partialProduct);
				}
				result = Binary.add(result, partialProduct);
			}
		}
		return result;
    }

}