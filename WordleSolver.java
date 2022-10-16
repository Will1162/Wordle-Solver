import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class WordleSolver
{
	public static void main(String[] args)
	{
		System.out.println("Possible words:");
		String word = "___a_";
		String invalidLetters = "rtiopsdcnm";
		String[] yellowLetters =
		{
			"al", // pos 1
			"l", // pos 2
			"ae", // pos 3
			"l", // pos 4
			"e"  // pos 5
		};

		try
		{
			FileInputStream fstream = new FileInputStream("words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			while ((strLine = br.readLine()) != null)
			{
				boolean match = true;

				for (int i = 0; i < invalidLetters.length(); i++)
				{
					if (strLine.indexOf(invalidLetters.charAt(i)) != -1)
					{
						match = false;
						break;
					}
				}

				if (match)
				{
					for (int i = 0; i < yellowLetters.length; i++)
					{
						if (yellowLetters[i] != "")
						{
							for (int j = 0; j < yellowLetters[i].length(); j++)
							{
								int index = strLine.indexOf(yellowLetters[i].charAt(j));
								if (index == -1 || index == i)
								{
									match = false;
									break;
								}
							}
						}
					}
				}

				if (match)
				{
					for (int i = 0; i < 5; i++)
					{
						if (word.charAt(i) != strLine.charAt(i) && word.charAt(i) != '_')
						{
							match = false;
							break;
						}
					}
				}

				if (match)
				{
					System.out.println(strLine);
				}
			}

			fstream.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}	
}
