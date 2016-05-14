/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   //System.out.println(urlVal.isValid("http://www.amazon.com"));
	   
	   assertTrue(urlVal.isValid("http://www.amazon.com"));
	   assertTrue(urlVal.isValid("HTTP://WWW.AMAZON.COM"));
	   assertTrue(urlVal.isValid("http://amazon.com"));
	   assertTrue(urlVal.isValid("HTTP://AMAZON.COM"));
	   assertTrue(urlVal.isValid("https://amazon.com"));
	   assertTrue(urlVal.isValid("HTTPS://AMAZON.COM"));
	   
	   assertTrue(urlVal.isValid("http://www.amazon.net"));
	   assertTrue(urlVal.isValid("HTTP://WWW.AMAZON.NET"));
	   assertTrue(urlVal.isValid("http://amazon.net"));
	   assertTrue(urlVal.isValid("HTTP://AMAZON.NET"));
	   assertTrue(urlVal.isValid("https://amazon.net"));
	   assertTrue(urlVal.isValid("HTTPS://AMAZON.NET"));
	   
	   assertTrue(urlVal.isValid("http://www.amazon.org"));
	   assertTrue(urlVal.isValid("HTTP://WWW.AMAZON.ORG"));
	   assertTrue(urlVal.isValid("http://amazon.org"));
	   assertTrue(urlVal.isValid("HTTP://AMAZON.ORG"));
	   assertTrue(urlVal.isValid("https://amazon.org"));
	   assertTrue(urlVal.isValid("HTTPS://AMAZON.ORG"));
	   
	   //assertTrue(urlVal.isValid("amazon.com"));
	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   assertTrue(urlVal.isValid("http://www.amazon.org"));
	   assertTrue(urlVal.isValid("ftp://www.amazon.org"));
	   assertTrue(urlVal.isValid("h3t://www.amazon.org"));
	  
	   
	   assertTrue(urlVal.isValid("http://www.google.com"));
	   assertTrue(urlVal.isValid("http://www.go.com"));
	   assertTrue(urlVal.isValid("http://www.go.au"));
	   assertTrue(urlVal.isValid("http://0.0.0.0"));
	   assertTrue(urlVal.isValid("http://255.255.255.255"));
	   assertTrue(urlVal.isValid("http://256.256.256.256"));
	   assertTrue(urlVal.isValid("http://255.com"));
	   assertTrue(urlVal.isValid("http://go.cc"));
	   
	   assertTrue(urlVal.isValid("http://www.google.com:80"));
	   //assertTrue(urlVal.isValid("http://www.google.com:65535")); //BUG
	   assertTrue(urlVal.isValid("http://www.google.com:0"));
	   //assertTrue(urlVal.isValid("http://www.google.com:65636")); //BUG
	   
	   assertTrue(urlVal.isValid("http://www.google.com/test1"));
	   assertTrue(urlVal.isValid("http://www.google.com/t123"));
	   assertTrue(urlVal.isValid("http://www.google.com/$23"));
	   assertTrue(urlVal.isValid("http://www.google.com/test1/"));
	   assertTrue(urlVal.isValid("http://www.google.com/test1/file"));
	   assertTrue(urlVal.isValid("http://www.google.com/t123/file"));
	   assertTrue(urlVal.isValid("http://www.google.com/$23/test1"));

	   //assertTrue(urlVal.isValid("http://www.yelp.com/?action=view")); //BUG
	   //assertTrue(urlVal.isValid("http://www.yelp.com/?action=edit&mode=up"));
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   }
   
   public void testYourSecondPartition(){
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   
	   assertFalse(urlVal.isValid("////"));
	   assertFalse(urlVal.isValid("3ht://www.google.com"));
	   assertFalse(urlVal.isValid("htp:/www.google.com")); 
	   assertFalse(urlVal.isValid("http:/www.google.com"));
	   assertFalse(urlVal.isValid("://www.google.com"));
	   //assertFalse(urlVal.isValid("http://256.256.256.256")); //BUG
	   assertFalse(urlVal.isValid("://1.2.3.4.5"));
	   assertFalse(urlVal.isValid("://1.2.3.4."));
	   assertFalse(urlVal.isValid("://1.2.3"));
	   assertFalse(urlVal.isValid("://.1.2.3.4"));
	   assertFalse(urlVal.isValid("http://www.go.a"));
	   assertFalse(urlVal.isValid("http://www.go.a1a"));
	   assertFalse(urlVal.isValid("http://www.go.a1a"));
	   //assertFalse(urlVal.isValid("http://www.go.cc")); //BUG
	   assertFalse(urlVal.isValid("http://go.1aa"));
	   assertFalse(urlVal.isValid("http://www.aaa"));
	   assertFalse(urlVal.isValid("http://www.aaa."));
	   assertFalse(urlVal.isValid("http://aaa"));
	   assertFalse(urlVal.isValid("http://www.google.com:-1"));
	   assertFalse(urlVal.isValid("http://www.google.com:65a"));
	   assertFalse(urlVal.isValid("http://www.google.com/.."));
	   assertFalse(urlVal.isValid("http://www.google.com/../"));
	   assertFalse(urlVal.isValid("http://www.google.com/..//file"));
	   assertFalse(urlVal.isValid("http://www.google.com/test1//file"));
	   assertFalse(urlVal.isValid("http://www.google.com/.."));
	   assertFalse(urlVal.isValid("http://www.google.com/../"));
	   //assertFalse(urlVal.isValid("http://www.google.com/#")); //BUG
	   assertFalse(urlVal.isValid("http://www.google.com/../file"));
	   assertFalse(urlVal.isValid("http://www.google.com/..//file"));
	   //assertFalse(urlVal.isValid("http://www.google.com/#/file")); //BUG

	   
	   

   }
   

   
   public void testIsValid()
   {
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   //for(int i = 0;i<10000;i++)
		   for(int i = 0;i<1;i++)
	   {
		   
		   String testUrl = "";
		   
		   System.out.println(firstPart[0].item);
		   

		   for (int firstIndex = 0; firstIndex < firstPart.length ; firstIndex++)
			   
		   {
			   for (int secondIndex = 0; secondIndex < secondPart.length ; secondIndex++)
				   
			   {
				   for (int thirdIndex = 0; thirdIndex < thirdPart.length ; thirdIndex++)
					   
				   {
					   for (int fourthIndex = 0; fourthIndex < fourthPart.length ; fourthIndex++)
						   
					   {
						   for (int fifthIndex = 0; fifthIndex < fifthPart.length ; fifthIndex++)
							   
						   {
							   
							   testUrl = testUrl + firstPart[firstIndex].item;
							   testUrl = testUrl + secondPart[secondIndex].item;
							   testUrl = testUrl + thirdPart[thirdIndex].item;
							   testUrl = testUrl + fourthPart[fourthIndex].item;
							   testUrl = testUrl + fifthPart[fifthIndex].item;
							   
							   System.out.println("testing: " + testUrl);
							   
							   if (firstPart[firstIndex].valid == true && secondPart[secondIndex].valid == true && thirdPart[thirdIndex].valid == true && fourthPart[fourthIndex].valid == true && fifthPart[fifthIndex].valid == true)
							   {
								   
								   System.out.println("Expected: true, got: " + urlVal.isValid(testUrl) + "\n");
								   
								   //assertTrue(urlVal.isValid(testUrl));
								   
							   }
							   
							   else if (firstPart[firstIndex].valid == false || secondPart[secondIndex].valid == false || thirdPart[thirdIndex].valid == false || fourthPart[fourthIndex].valid == false || fifthPart[fifthIndex].valid == false)
							   {
								   
								   System.out.println("Expected: false, got: " + urlVal.isValid(testUrl) + "\n");
								   
								   //assertFalse(urlVal.isValid(testUrl));
								   
							   }
							   testUrl = "";
							   
						   }
					   }
				   }
			   }
			   

			   
			   testUrl = testUrl + firstPart[i].item;
			   testUrl = testUrl + secondPart[i].item;
			   testUrl = testUrl + thirdPart[i].item;
			   testUrl = testUrl + fourthPart[i].item;
			   testUrl = testUrl + fifthPart[i].item;
			   
			   System.out.println("testing: " + testUrl + "\n");
			   
			   testUrl = "";
			   
			   
		   }
		   
		   
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   
   ResultPair[] firstPart = {
		   new ResultPair("http://", true),
           new ResultPair("ftp://", true),
           new ResultPair("h3t://", true),
           new ResultPair("3ht://", false),
           new ResultPair("http:/", false),
           new ResultPair("http:", false),
           new ResultPair("http/", false),
           new ResultPair("://", false),
           new ResultPair("", true)
    };
   
   
	

	ResultPair[] secondPart = {
		new ResultPair("google.com", true),
        new ResultPair("amazon.com", true),
        new ResultPair("ebay.com", true),
        new ResultPair("", true)
        
	};
	
	ResultPair[] thirdPart = {
		new ResultPair(":90", true),
	    new ResultPair(":95", true),
	    new ResultPair(":100", true),
	    new ResultPair("", true)
	};
	
	ResultPair[] fourthPart = {
			
        new ResultPair("/$23", true),
        new ResultPair("/..", false),
        new ResultPair("/../", false),
        new ResultPair("/test1/", true),
	};
	
	ResultPair[] fifthPart = {
			
			
			
		new ResultPair("?action=view", true),
        new ResultPair("?action=edit&mode=up", true),
        new ResultPair("", true)
};
	
	
	
	
	
	
	
}

	
