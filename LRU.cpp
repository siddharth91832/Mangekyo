#include <bits/stdc++.h>
using namespace std;

int pageFaults(int pages[], int n, int sizee)
{

  unordered_set<int> s;
  unordered_map<int, int> indexes;

  int page_faults = 0;

  for (int i = 0; i < n; i++)
  {
    if (s.size() < sizee)
    {
      if (s.find(pages[i]) == s.end())
      {
        s.insert(pages[i]);
        page_faults++;
      }

      indexes[pages[i]] = i;
    }
    else
    {
      if (s.find(pages[i]) == s.end())
      {
        int lru = INT_MAX, val;
        for (auto it = s.begin(); it != s.end(); it++)
        {
          if (indexes[*it] < lru)
          {
            lru = indexes[*it];
            val = *it;
          }
        }

        s.erase(val);
        s.insert(pages[i]);
        page_faults++;
      }

      indexes[pages[i]] = i;
    }
  }

  return page_faults;
}





int main()
{

  cout << "Enter Number of Pages : ";

  int n;
  cin >> n;

  int pages[n];

  cout << "\nEnter the sequences of pages :-\n ";

  for (int i = 0; i < n; i++)
  {
    cin >> pages[i];
  }


  int size[] = {2, 3, 4, 5, 6};


  cout << "\n\nFrame Size     " << "    Page Faults " << "\n";

  for (int i = 0; i < 5; i++)
  {
    cout << "  " << size[i] << "                     " << pageFaults(pages, n, size[i]) << "\n";
  }

  cout << "\n\n";

  return 0;
}
