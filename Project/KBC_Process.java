package kbcp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class KBC_Process 
{
	
	FileReader f=new FileReader("KBCQues.txt");
	BufferedReader br=new BufferedReader(this.f);
	
	KBC_Process()throws FileNotFoundException{};
	
	public String getQuestion() throws IOException
	{
		String s;
		s=br.readLine();
		s=s.trim();
		return s;
	}
	
	public String getanswer() throws IOException
	{
		String s;
		s=br.readLine();
		s=s.trim();
		return s;
	}
	
	public String getCorrectAns() throws IOException
	{
		String s;
		s=br.readLine();
		s=s.trim();
		return s;
	} 
}
