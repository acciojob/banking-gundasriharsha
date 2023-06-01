package com.driver;

import java.util.HashMap;import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{



    String tradeLicenseId; //consists of Uppercase English characters only

    public String   getTradeLicenseId() {
        return tradeLicenseId;
    }
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception
    {
        super(name,balance,5000.00);
        this.tradeLicenseId=tradeLicenseId;

        if(balance<5000)
            throw new Exception("Insufficient Balance");

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean flag = false;
        int n=this.tradeLicenseId.length();
        for(int i=1;i<n;i++)
        {
            if(this.tradeLicenseId.charAt(i-1) == this.tradeLicenseId.charAt(i))
            {
                flag=true;
                break;
            }
        }

        if(flag)
        {

            String validId=makeValid(this.tradeLicenseId);

            if(validId.equals("-1"))
            {
                throw new Exception("Valid License can not be generated");
            }
            else
            {
                this.tradeLicenseId=validId;
            }
        }

    }
    public  String makeValid(String str)
    {
        int[] freq=new int[26];

        char[] chars = str.toCharArray();
        int n=str.length();

        int maxfreq=0;
        char maxChar=' ';
        for(int i = 0; i < n; i++)
        {
            freq[chars[i]-'A']++;

            if(freq[chars[i] - 'A'] > maxfreq)
            {
                maxfreq=freq[chars[i] - 'A'];
                maxChar=chars[i];
            }
        }
        if(maxfreq>(n+1)/2)
        {
            return "-1";
        }

        int idx=0;

        char[] ans=new char[n];

        while(maxfreq-- >0)
        {
            ans[idx] = maxChar;
            idx=idx+2;
        }
        freq[maxChar-'A']=0;
        for (int i = 0; i < 26; i++)
        {
            if(freq[i] >0)
            {
                while (freq[i] > 0) {
                    idx=(idx>n-1)? 1 : idx;
                    ans[idx] = (char)(i+'A');
                    idx = idx + 2;
                    freq[i]--;
                }
            }



        }

        return String.valueOf(ans);
        //code here
    }

}