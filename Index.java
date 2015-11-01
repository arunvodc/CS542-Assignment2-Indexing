package Index;

import java.io.*;
import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.IOException;

class Hash
{
public int i=0,j=0,k=0,l=0,m=0,n=0,in=0;
public String Str[][] = new String[27][11];
public int Global[]   = new int[47];
public int Global2[]  = new int[47];
public int Local2[]   = new int[17];
public int Local3[]   = new int[33];
public int Local4[]   = new int[65];
public String db[]    = new String[501];
public byte[] bytes   = new byte[1024];
public String str;

public void printGlobal() // Print Pointers to Locations in the Global Depth
{
	System.out.println("Global Depth: ");
	for (i=1;i<=46;i++)
	{
		System.out.print(Global[i]+", ");
	}
	System.out.println();
}

public void printLocal2() // Print Pointers to Locations in the Local Depth 2
{
	System.out.println("Local 2 Hash: ");
	for (i=1;i<=16;i++)
	{
		System.out.print(Local2[i]+", ");
	}
	System.out.println();
}

public void printLocal3() // Print Pointers to Locations in the Local Depth 3
{
	System.out.println("Local 3 Hash: ");
	for (i=1;i<=32;i++)
	{
		System.out.print(Local3[i]+", ");
	}
	System.out.println();
}

public void printLocal4() // Print Pointers to Locations in the Local Depth 4
{
	System.out.println("Local 4 Hash: ");
	for (i=1;i<=64;i++)
	{
		System.out.print(Local4[i]+", ");
	}
	System.out.println();
}

public void dbprintLocal2()
{
	System.out.println("DB Local 2 Hash: ");
	for (i=1;i<=16;i++)
	{
		if(db[i].equals(""))
			System.out.print("0, ");
		else
		{
			System.out.print(db[i].charAt(0));
			if(db[i].charAt(1)==',')
				System.out.print(", ");
			else
				System.out.print(db[i].charAt(1)+", ");
		}
	}
	System.out.println();
}

public void dbprintLocal3()
{
	System.out.println("DB Local 3 Hash: ");
	for (i=51;i<=82;i++)
	{
		if(db[i].equals(""))
			System.out.print("0, ");
		else
		{
			System.out.print(db[i].charAt(0));
			if(db[i].charAt(1)==',')
				System.out.print(", ");
			else
				System.out.print(db[i].charAt(1)+", ");
		}
	}
	System.out.println();
}

public void dbprintLocal4()
{
	System.out.println("DB Local 4 Hash: ");
	for (i=101;i<=164;i++)
	{
		if(db[i].equals(""))
			System.out.print("0, ");
		else
		{
			System.out.print(db[i].charAt(0));
			if(db[i].charAt(1)==',')
				System.out.print(", ");
			else
				System.out.print(db[i].charAt(1)+", ");
		}
	}
	System.out.println();
}

public void First_Run() // Initial setup of files to execute the program
{
	try
	{
		for (i=1;i<=4;i++)
		{
			Global[i]=(i-1)*4+1;
		}
		
		for (i=5;i<=16;i++)
		{
			Global[i]=0;
		}
		
		for (i=21;i<=46;i++)
		{
			Global[i]=i-20;
		}
		
		RandomAccessFile rafg = new RandomAccessFile("Global.txt", "rw");
		
		for(i=1;i<=46;i++)
		{
			str = Integer.toString(Global[i])+'\n';
			bytes = str.getBytes();
			rafg.write(bytes);
		}

		rafg.close();
		
		RandomAccessFile rafl2 = new RandomAccessFile("Local2.txt", "rw");
		
		for(i=1;i<=16;i++)
		{
			str = Integer.toString(Local2[i])+'\n';
			bytes = str.getBytes();
			rafl2.write(bytes);
		}
		rafl2.close();
		
		RandomAccessFile rafl3 = new RandomAccessFile("Local3.txt", "rw");
		
		for(i=1;i<=32;i++)
		{
			str = Integer.toString(Local3[i])+'\n';//"0\n";
			bytes = str.getBytes();
			rafl3.write(bytes);
		}
		rafl3.close();
		
		RandomAccessFile rafl4 = new RandomAccessFile("Local4.txt", "rw");
		
		for(i=1;i<=64;i++)
		{
			str = Integer.toString(Local4[i])+'\n';
			bytes = str.getBytes();
			rafl4.write(bytes);
		}
		rafl4.close();

		for (i=1;i<=26;i++)
			for (j=1;j<=10;j++)
				Str[i][j]="";

		RandomAccessFile rafs = new RandomAccessFile("String.txt", "rw");
		
		for (i=1;i<=26;i++)
		{
			for (j=1;j<=10;j++)
			{
				str = Str[i][j]+'\n';
				bytes = str.getBytes();
				rafs.write(bytes);	
			}			
		}
		rafs.close();
		
		RandomAccessFile raf = new RandomAccessFile("cs542.db", "rw");
		
		for(i=1;i<=500;i++)
		{
			bytes = "\n".getBytes();
			raf.write(bytes);
		}
		
		raf.close();

	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
// End of First_Run

public void Last_Run() // Method to commit the changes to the database
{
	try
	{
		RandomAccessFile rafg = new RandomAccessFile("Global.txt", "rw");
		
		for(i=1;i<=46;i++)
		{
			str = Integer.toString(Global[i])+'\n';
			bytes = str.getBytes();
			rafg.write(bytes);
		}

		rafg.close();
		
		RandomAccessFile rafl2 = new RandomAccessFile("Local2.txt", "rw");
		
		for(i=1;i<=16;i++)
		{
			str = Integer.toString(Local2[i])+'\n';
			bytes = str.getBytes();
			rafl2.write(bytes);
		}
		rafl2.close();
		
		RandomAccessFile rafl3 = new RandomAccessFile("Local3.txt", "rw");
		
		for(i=1;i<=32;i++)
		{
			str = Integer.toString(Local3[i])+'\n';
			bytes = str.getBytes();
			rafl3.write(bytes);
		}
		rafl3.close();
		
		RandomAccessFile rafl4 = new RandomAccessFile("Local4.txt", "rw");
		
		for(i=1;i<=64;i++)
		{
			str = Integer.toString(Local4[i])+'\n';
			bytes = str.getBytes();
			rafl4.write(bytes);
		}
		rafl4.close();

		RandomAccessFile rafs = new RandomAccessFile("String.txt", "rw");

		for (i=1;i<=26;i++)
		{
			for (j=1;j<=10;j++)
			{
				str = Str[i][j]+"\n";
				bytes = str.getBytes();
				rafs.write(bytes);	
			}		
		}			
		rafs.close();
		
		RandomAccessFile raf = new RandomAccessFile("cs542.db", "rw");
		for(i=1;i<=500;i++)
		{
			bytes = (db[i]+"\n").getBytes();
			raf.write(bytes);
		}
		raf.close();

	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
// End of Last_Run

public void Put_test() // Method to read the data from the database to the main memory
{
try
{
	RandomAccessFile rafg = new RandomAccessFile("Global.txt", "rw");

	for(i=1;i<=46;i++)
	{
		in=Integer.parseInt(rafg.readLine());
		Global[i]=in;
	}	
	rafg.close();
	
	RandomAccessFile rafl2 = new RandomAccessFile("Local2.txt", "rw");
	
	for(i=1;i<=16;i++)
	{
		in=Integer.parseInt(rafl2.readLine());
		Local2[i]=in;
	}
	rafl2.close();
	
	RandomAccessFile rafl3 = new RandomAccessFile("Local3.txt", "rw");
	
	for(i=1;i<=32;i++)
	{
		in=Integer.parseInt(rafl3.readLine());
		Local3[i]=in;
	}
	rafl3.close();
	
	RandomAccessFile rafl4 = new RandomAccessFile("Local4.txt", "rw");
	
	for(i=1;i<=64;i++)
	{
		in=Integer.parseInt(rafl4.readLine());
		Local4[i]=in;
	}
	rafl4.close();
	
	RandomAccessFile rafs = new RandomAccessFile("String.txt", "rw");

	for (i=1;i<=26;i++)
		for (j=1;j<=10;j++)
			Str[i][j] = rafs.readLine();

	rafs.close();
	
	RandomAccessFile raf = new RandomAccessFile("cs542.db", "rw");
	
	for(i=1;i<=500;i++)
	{
		db[i] = raf.readLine();
	}
	
	raf.close();

}
catch(IOException e)
{
	e.printStackTrace();
}
}
// End of Put_Test

public void Put(String key, String data) // To insert String data
{
	char ch = key.charAt(0);
	int index = (int)ch;
	int dbindex;
	if(index>96)
		index-=32;
	index-=64;
	String temp="";
	for(j=1;j<=10;j++)
	{
		if(Str[index][j].equals(temp))
		{
			dbindex=200+(index-1)*10+j;
			Str[index][j]=key;
			db[dbindex]=key+","+data;
			break;
		}
	}
}
// End of Put (String)

public String Get(String key, String data) // To fetch String data
{
	char ch = key.charAt(0);
	int index = (int)ch;
	if(index>96)
		index-=32;
	index-=64;
	data=key+","+data;
	int dbindex;
	for(j=1;j<=10;j++)
	{
		dbindex=200+(index-1)*10+j;
		if(Str[index][j].equals(key)&&db[dbindex].equals(data))
			break;

	}
	if(j==11)
		return "Data not found";
	index+=64;
	if(index<96)
		index+=32;
	ch = (char) index;
	return "Hash Key is: "+ch;
}
// End of Get String

public void Remove(String key) // To remove String data
{
	char ch = key.charAt(0);
	int index = (int)ch;
	if(index>96)
		index-=32;
	index-=64;
	int dbindex;
	for(j=1;j<=10;j++)
	{
		dbindex=200+(index-1)*10+j;
		if(Str[index][j].equals(key))
			Str[index][j]="";

	}
	/*
	int index = (int)hashKey;
	if(index>96)
		index-=32;
	index-=44;
	for(j=1;j<=10;j++)
			Str[index][j]="";
	*/
}
// End of Remove (String)

public void Put(int key, String data) // To insert number data
{

	int index, pos;
	index = key%4;
	pos = Global[index+1];
	if(pos>48)
		Put_Level4(key, pos, data, index);
	else if(pos>16)
		Put_Level3(key, pos, data, index);
	else
		Put_Level2(key, pos, data, index);
}
//End of Put (Integer)

public void Put_Level2(int key, int pos, String data,int index) // Local Depth 2 operations during insertion
{	
	for(i=pos;i<pos+4;i++)
	{
		if(Local2[i]==0)
		{
			Local2[i]=key;
			db[i] = Integer.toString(key)+","+data;
			break;
		}
	}
	if(i==pos+4)
	{
		reHash(2,index,pos);
		Put(key,data);
	}
}
// End of Put_Level2

public void Put_Level3(int key, int pos, String data,int index) // Local Depth 3 operations during insertion
{
	if(key%8==index)
		pos=Global[index+1];
	else
		pos=Global[index+5];
	pos-=16;
	for(i=pos;i<pos+4;i++)
	{
		if(Local3[i]==0)
		{
			Local3[i] = key;
			db[i+50] = Integer.toString(key)+","+data;
			break;
		}
	}
	if(i==pos+4)
	{
		if(key%8>3)
			pos-=4;
		reHash(3,index, pos);
		Put(key,data);
	}
	
}
//End of Put_Level3

public void Put_Level4(int key, int pos, String data,int index) // Local Depth 4 operations during insertion
{
	
	if(key%16==index)
		pos=Global[index+1];
	else if(key%16==index+4)
		pos=Global[index+5];
	else if(key%16==index+8)
		pos=Global[index+9];
	else
		pos=Global[index+13];
	
	pos-=48;
	
	for(i=pos;i<pos+4;i++)
	{
		if(Local4[i]==0)
		{
			Local4[i] = key;
			db[i+100] = Integer.toString(key)+","+data;
			break;
		}
	}
}
//End of Put_Level4

public void reHash(int level, int index, int pos) // To Re-Hash after insertion 
{
	switch(level)
	{
	case 2:
		index = pos/4;
		k = pos;
		i = index*8+1;
		j = index*8+5;
		Global[index+1]   = i+16;
		Global[index+5] = j+16;
		while(k<pos+4)
		{
			if(Local2[k]%8==index)
			{
				Local3[i] = Local2[k];
				db[i+50] = db[k];
				Local2[k] = 0;
				db[k] = "";
				i++;
			}
			else
			{
				Local3[j] = Local2[k];
				db[j+50] = db[k];
				Local2[k] = 0;
				db[k] = "";
				j++;
			}
		k++;
		}
	break;
	
	case 3:
		index = pos/8;
		k = pos;
		i = index*16+1;
		j = index*16+5;
		m = index*16+9;
		n = index*16+13;
		Global[index+1]   = i+48;
		Global[index+5]   = j+48;
		Global[index+9]   = m+48;
		Global[index+13]  = n+48;
		while(k<pos+8)
		{
			if(Local3[k]%16==index)
			{
				Local4[i] = Local3[k];
				db[i+100] = db[k+50];
				Local3[k] = 0;
				db[k+50] = "";
				i++;
			}
			else if((Local3[k]%16) == (index+4))
			{
				Local4[j] = Local3[k];
				db[j+100] = db[k+50];
				Local3[k] = 0;
				db[k+50] = "";
				j++;
			}
			else if((Local3[k]%16) == (index+8))
			{
				Local4[m] = Local3[k];
				db[m+100] = db[k+50];
				Local3[k] = 0;
				db[k+50] = "";
				m++;
			}
			else
			{
				Local4[n] = Local3[k];
				db[n+100] = db[k+50];
				Local3[k] = 0;
				db[k+50] = "";
				n++;
			}
		k++;
		}
	break;
	}
}
// End of reHash

public void reHash_Remove(int index) // To Re-Hash after deletion
{
	int min,max,c1=0,c2=0;
	min=index*16+1;
	max=index*16+4;
	for(i=min;i<=max;i++)
	{
		if(Local4[i]!=0)
			c1++;
	}
	
	min=index*16+9;
	max=index*16+12;
	for(i=min;i<=max;i++)
	{
		if(Local4[i]!=0)
			c1++;
	}
	
	min=index*16+5;
	max=index*16+8;
	for(i=min;i<=max;i++)
	{
		if(Local4[i]!=0)
			c2++;
	}
	
	min=index*16+13;
	max=index*16+16;
	for(i=min;i<=max;i++)
	{
		if(Local4[i]!=0)
			c2++;
	}
	
	if(c1<=4&&c2<=4&&(c1!=0||c2!=0))  // Rehash from Local4 to Local 3 - ((c1+c2)>4)
	{
		Global[index+1]=index*8+1+16;
		Global[index+5]=index*8+5+16;
		Global[index+9]=0;
		Global[index+13]=0;
		min=index*16+1;
		max=index*16+4;
		j=index*8+1;
		k=index*8+5;
		for(i=min;i<=max;i++)
		{
			if(Local4[i]!=0)
			{
			Local3[j]=Local4[i];
			db[j+50]=db[i+100];
			Local4[i]=0;
			db[i+100]="";
			j++;
			}
		}
		
		min=index*16+5;
		max=index*16+8;
		for(i=min;i<=max;i++)
		{
			if(Local4[i]!=0)
			{
			Local3[k]=Local4[i];
			db[k+50]=db[i+100];
			Local4[i]=0;
			db[i+100]="";
			k++;
			}
		}
		
		min=index*16+9;
		max=index*16+12;
		for(i=min;i<=max;i++)
		{
			if(Local4[i]!=0)
			{
			Local3[j]=Local4[i];
			db[j+50]=db[i+100];
			Local4[i]=0;
			db[i+100]="";
			j++;
			}
		}
		
		min=index*16+13;
		max=index*16+16;
		for(i=min;i<=max;i++)
		{
			if(Local4[i]!=0)
			{
			Local3[k]=Local4[i];
			db[k+50]=db[i+100];
			Local4[i]=0;
			db[i+100]="";
			k++;
			}
		}
	}
	
	for(c1=0,i=index*8+1;i<=index*8+8;i++)
	{
		if(Local3[i]!=0)
			c1++;
	}
	
	if(c1<=4&&c1!=0)  // Rehash from Local3 to Local2
	{
		Global[index+1]=index*4+1;
		Global[index+5]=0;
		j=index*4+1;
		for(i=index*8+1;i<=index*8+8;i++)
		{
			if(Local3[i]!=0)
			{
				Local2[j]=Local3[i];
				db[j]=db[i+50];
				Local3[i]=0;
				db[i+50]="";
				j++;
			}
		}
	}
}
// End of reHash Remove

public void Remove(int key) // To remove the key for integer data
{
	int index;
	index = (key%4)+1;
	if(Global[index]>48)
		Remove_Level4(key,index);
	else if(Global[index]>16)
		Remove_Level3(key,index);
	else
		Remove_Level2(key,index);
	reHash_Remove(index-1);
}
// End of Remove

public void Remove_Level2(int key, int index) // To remove the key for integer data in Local Depth 2
{
	int pos=Global[index];
	for(i=pos;i<pos+4;i++)
		if(Local2[i]==key)
		{
			Local2[i]=0;
			//db[i]="";
		}
}
//End of Remove_Level4

public void Remove_Level3(int key, int index) // To remove the key for integer data in Local Depth 3
{
	int pos;
	if(key%8==(index-1))
		pos=Global[index];
	else
		pos=Global[index+4];
	pos-=16;

	for(i=pos;i<pos+4;i++)
		if(Local3[i]==key)
		{
			Local3[i]=0;
			//db[i+50]="";
		}
}
//End of Remove_Level4

public void Remove_Level4(int key, int index) // To remove the key for integer data in Local Depth 4
{
	int pos;
	index-=1;
	if(key%16==index)
		pos=Global[index+1];
	else if(key%16==index+4)
		pos=Global[index+5];
	else if(key%16==index+8)
		pos=Global[index+9];
	else
		pos=Global[index+13];
	pos-=48;

	for(i=pos;i<pos+4;i++)
		if(Local4[i]==key)
		{
			Local4[i]=0;
			//db[i+100]="";
		}
}
//End of Remove_Level4

public String Get(int key, String str) // To fetch number data
{
	int index;
	index = (key%4)+1;
	if(Global[index]>48)
	{
		int val = Get_Level4(key,index, str);
		if(val!=-1)
			return "Local Depth 4. Position in bucket: "+index+". Key value: "+key;
		else
			return "NULL";
	}
	else if(Global[index]>16)
	{
		int val = Get_Level3(key,index, str);
		if(val!=-1)
			return "Local Depth 3. Position in bucket: "+index+". Key value: "+key;
			//return "Local Depth 3. Key no: "+val;
		else
			return "NULL";
	}
	else
	{
		int val = Get_Level2(key,index, str);
		if(val!=-1)
			return "Local Depth 4. Position in bucket: "+index+". Key value: "+key;
		//return "Local Depth 2. Key no: "+val;
		else
			return "NULL";
	}
}
// End of Get

public int Get_Level2(int key, int index, String str) // Fetch operations in Local Depth 2
{
	int pos=Global[index];
	for(i=pos;i<pos+4;i++)
		if(Local2[i]==key)
		{
			str=Integer.toString(key)+","+str;
			if(db[i].equals(str))
				return i;
		}
	return -1;
}
//End of Remove_Level4

public int Get_Level3(int key, int index, String str) // Fetch operations in Local Depth 3
{
	int pos;
	if(key%8==(index-1))
		pos=Global[index];
	else
		pos=Global[index+4];
	pos-=16;

	for(i=pos;i<pos+4;i++)
		if(Local3[i]==key)
		{
			str=Integer.toString(key)+","+str;
			System.out.println("Str: "+str+" i+50: "+(i+50));
			if(db[i+50].equals(str))
				return i;
		}
	return -1;
}
//End of Remove_Level4

public int Get_Level4(int key, int index, String str) // Fetch operations in Local Depth 4
{
	int pos;
	index-=1;
	if(key%16==index)
		pos=Global[index+1];
	else if(key%16==index+4)
		pos=Global[index+5];
	else if(key%16==index+8)
		pos=Global[index+9];
	else
		pos=Global[index+13];
	pos-=48;

	for(i=pos;i<pos+4;i++)
		if(Local4[i]==key)
		{
			str=Integer.toString(key)+","+str;
			if(db[i+100].equals(str))
				return i;
		}
	return -1;
}
//End of Remove_Level4

}
// End of Class Hash

public class Index {

public static void main(String args[]) // Main
{
	Scanner in = new Scanner(System.in);
	Hash h= new Hash();

	int key=-1,opt=0,opt2=0;
	String val;
	
	System.out.println("Is this your first run in this system (or) Do you want to reset all the indexes and data (y/n): ");
		char ch = in.next().charAt(0);
		
	if(ch=='y')
	{
		h.First_Run();
		System.out.println("Initialization / Reset is Done");
	}
	
	h.Put_test();
	
	System.out.println("Note: For entering data in a tuple, first data should be as Data 1, for which the index is created on. Second data should be entered in Data 2.\n      Additional data can be given by appending with Data 2 e.g. (john|25|California). If so, the same value needs to be entered during Search.\n");
	
	do
	{
	System.out.println("What do you want to do now?\nEnter 1 for numbers\nEnter 2 for Strings\nEnter 0 for exit"); // Enter 3 for generating the Index structures\n
		opt=in.nextInt();
		
	if(opt==1||opt==2)
	{
		System.out.println("1 - Insert\n2 - Search\n3 - Delete\n");
		opt2=in.nextInt();
	
	if(opt2==1) // Insert Data
	{
	if(opt==1)
		System.out.println("Enter the data to insert. Enter 0 to stop.");
	do
	{
	if(opt==1)
	{
		System.out.println("Enter data 1 (Number): ");
		key=in.nextInt();
		if(key==0)
			break;
		System.out.println("Enter data 2 (String): ");
		val =in.nextLine();
		if(val.equals(""))
			val= in.nextLine();
		h.Put(key,val);
	}
	else
	{	
		System.out.println("Enter data 1 (String): ");
		String str =in.nextLine();
		if(str.equals(""))
			str = in.nextLine();
		if(str.equals("0"))
		{
			key = 0;
			break;
		}
		System.out.println("Enter data 2 (String): ");
		String str2 =in.nextLine();
		if(str2.equals(""))
			str2 = in.nextLine();
		h.Put(str, str2);
	}
	}while(key!=0);

	}
	
	else if(opt2==2) // Search Data
	{
		if(opt==1)
		{
			System.out.println("Enter the data 1 on which the index is created (Number): ");
			key = in.nextInt();
			System.out.println("Enter data 2 (String): ");
			String str2 =in.nextLine();
			if(str2.equals(""))
				str2 = in.nextLine();
			if(h.Get(key,str2).equals("NULL"))
				System.out.println("Data not found.");
			else
				System.out.println(h.Get(key,str2));
		}
			
		else
		{
			System.out.println("Enter the data 1 on which the index is created (String): ");
			String str =in.nextLine();
			if(str.equals(""))
				str = in.nextLine();
			System.out.println("Enter data 2 (String): ");
			String str2 =in.nextLine();
			if(str2.equals(""))
				str2 = in.nextLine();
			if(str.equals(""))
				str = in.nextLine();
			if(h.Get(str,str2).equals("NULL"))
				System.out.println("Data not found.");
			else
				System.out.println(h.Get(str,str2));
		}
	}
	else // Delete Data
	{
		if(opt==1)
		{

			System.out.print("Enter the data to be removed (Number): ");
			h.Remove(in.nextInt());
		}
			
		else
		{

			System.out.print("Enter the data 1, on which the index is created, to be removed (String): ");
			String str =in.nextLine();
			if(str.equals(""))
				str = in.nextLine();
			h.Remove(str);
		}
	}
	}
	
	else
	{
		/*
		if(opt==3)
		{
		h.printGlobal();
		h.printLocal2();
		h.dbprintLocal2();
		h.printLocal3();
		h.dbprintLocal3();
		h.printLocal4();
		h.dbprintLocal4();
		}
		*/
	}
	
	}while(opt!=0);

	System.out.print("Do you want to commit (y/n): ");
	ch = in.next().charAt(0);

	if(ch=='y')
	{
		h.Last_Run();
		System.out.println("Committed.");
	}
	else
	{
		System.out.println("Not Committed.");
	}
}
}
