#include "List.h"
#include "List.cpp"
#include <iostream>

using namespace std;

template <class T>
void print(List<T> list) 
{
   for (int i = 0; i < list.size(); i++)
      cout << list.get(i) << " ";
   cout << endl;
}

int main()
{
   const int SIZE = 10;

   // create list of integers and doubles
   List<int> intList(SIZE);
   List<double> doubleList(SIZE);

   // populate lists
   for (int i = 0; i < SIZE; i++) {
      intList.add(i * 2);
      doubleList.add(i * 2.14); 
   }

   //print lists
   cout << "integer list values: " << endl;
   print(intList);
   cout << "double list values: " << endl;
   print(doubleList);

   // populate again
   for (int i = 0; i < SIZE; i++) {
      intList[i]++;
      doubleList[i]++;
   }

   //print lists 
   cout << "integer list values: " << endl;
   print(intList);
   cout << "double list values: " << endl;
   print(doubleList);
   
   return 0;
}
